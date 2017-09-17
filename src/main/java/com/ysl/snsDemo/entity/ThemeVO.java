package com.ysl.snsDemo.entity;

import java.io.Serializable;

/**
 * 朋友圈主题表查询VO
 * 
 * @author 杨森林
 */
public class ThemeVO implements Serializable {

	private static final long serialVersionUID = -7223621370148574795L;
	
	/**
	 * 发布者ID
	 */
	private long publisherId;
	/**
	 * 开始时间
	 */
	private String startDate;
	/**
	 * 结束时间
	 */
	private String endDate;

	public long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(long publisherId) {
		this.publisherId = publisherId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
