package com.ysl.snsDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ysl.snsDemo.entity.Theme;
import com.ysl.snsDemo.entity.ThemeVO;
import com.ysl.snsDemo.service.ThemeService;
import com.ysl.snsDemo.utils.ResultCode;

@RestController
@RequestMapping(value = "/theme")
public class ThemeController {
	
	@Autowired
	private ThemeService themeService;
	
	/**
	 * 发布一个主题
	 * @param theme
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> publishTheme (@ModelAttribute Theme theme){
		if(theme == null){
			return ResponseEntity.ok(new JsonResult(ResultCode.PARAMS_ERROR));
		}
		JsonResult jsonResult = new JsonResult();
		try {
			Theme result = themeService.publishTheme(theme);
			jsonResult.setData(result);
		} catch (Exception e) {
			jsonResult.setCode(ResultCode.EXCEPTION);
			jsonResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(jsonResult);
	}
	
	/**
	 * 根据主题ID删除主题
	 * @param themeId
	 * @return
	 */
	@RequestMapping(value = "/{themeId}", method = RequestMethod.DELETE)
	public ResponseEntity<JsonResult> deleteTheme (@PathVariable("themeId") long themeId){
		JsonResult jsonResult = new JsonResult();
		try {
			int result = themeService.deleteTheme(themeId);
			jsonResult.setData(result);
		} catch (Exception e) {
			jsonResult.setCode(ResultCode.EXCEPTION);
			jsonResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(jsonResult);
	}
	
	/**
	 * 更新主题内容
	 * @param themeId 主题ID
	 * @param content 主题内容
	 * @return
	 */
	@RequestMapping(value = "/{themeId}", method = RequestMethod.PUT)
	public ResponseEntity<JsonResult> updateTheme (@PathVariable("themeId") long themeId,@RequestParam String content){
		JsonResult jsonResult = new JsonResult();
		try {
			Theme theme = themeService.getThemeById(themeId);
			theme.setContent(content);
			Theme result = themeService.updateTheme(theme);
			jsonResult.setData(result);
		} catch (Exception e) {
			jsonResult.setCode(ResultCode.EXCEPTION);
			jsonResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(jsonResult);
	}
	
	/**
	 * 按时间范围分页查询每个用户的主题列表
	 * @param theme
	 * @return
	 */
	@RequestMapping(value = "/list/{publisherId}", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<JsonResult> getThemeList (@PathVariable("publisherId") long publisherId,
			@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,
			@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize,
			@RequestParam("totalPages") int totalPages,@RequestParam("totalSize") int totalSize){
		JsonResult jsonResult = new JsonResult();
		try {
			ThemeVO themeVO = new ThemeVO();
			themeVO.setEndDate(endTime);
			themeVO.setStartDate(startTime);
			themeVO.setPublisherId(publisherId);
			PageInfo<Theme> pageInfo = new PageInfo<Theme>();
			pageInfo.setPageNum(pageNum);
			pageInfo.setPageSize(pageSize);
			pageInfo.setTotal(totalSize);
			pageInfo.setPageSize(totalPages);
			pageInfo = themeService.getThemeList(pageInfo, themeVO);
			jsonResult.setData(pageInfo);
		} catch (Exception e) {
			jsonResult.setCode(ResultCode.EXCEPTION);
			jsonResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(jsonResult);
	}
}
