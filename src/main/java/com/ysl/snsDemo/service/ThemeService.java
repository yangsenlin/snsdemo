package com.ysl.snsDemo.service;

import com.github.pagehelper.PageInfo;
import com.ysl.snsDemo.entity.Theme;
import com.ysl.snsDemo.entity.ThemeVO;

public interface ThemeService {
	/**
	 * 发布一个主题
	 * @param theme 主题内容
	 * @return
	 */
	public Theme publishTheme(Theme theme);
	
	/**
	 * 修改一个主题
	 * @return
	 */
	public Theme updateTheme(Theme theme);
	
	/**
	 * 删除一个主题
	 * @param themeId 主题ID
	 * @return
	 */
	public int deleteTheme(long themeId);
	
	/**
	 * 分页查询主题信息
	 * @param pageInfo
	 * @param theme 查询条件
	 * @return
	 */
	public PageInfo<Theme> getThemeList(PageInfo<Theme> pageInfo,ThemeVO theme);
	
	/**
	 * 根据ID查找主题内容
	 * @param themeId
	 * @return
	 */
	public Theme getThemeById(long themeId);
}
