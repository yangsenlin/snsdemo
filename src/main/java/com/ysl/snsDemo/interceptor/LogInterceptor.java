package com.ysl.snsDemo.interceptor;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 日志拦截器
 */
public class LogInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
	private static final ThreadLocal<Long> startTimeThreadLocal =
            new NamedThreadLocal<>("ThreadLocal StartTime");
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
            logger.info("ViewName: " + modelAndView.getViewName());
        }
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		if (logger.isDebugEnabled()) {
			// 1、开始时间
            long beginTime = System.currentTimeMillis();
            // 线程绑定变量（该数据只有当前请求的线程可见）
            startTimeThreadLocal.set(beginTime);
            logger.debug("开始计时: {}  URI: {}",
                    new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime),
                    request.getRequestURI());
		}
		return false;
	}
	
}
