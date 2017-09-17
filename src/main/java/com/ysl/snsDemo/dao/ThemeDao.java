package com.ysl.snsDemo.dao;

import java.util.List;

import com.ysl.snsDemo.entity.Theme;
import com.ysl.snsDemo.entity.ThemeVO;

public interface ThemeDao {
	
	/**
	 * 发布一个主题
	 * @param theme 主题内容
	 * @return
	 */
	public int publishTheme(Theme theme);
	
	/**
	 * 修改一个主题
	 * @return
	 */
	public int updateTheme(Theme theme);
	
	/**
	 * 删除一个主题
	 * @param themeId 主题ID
	 * @return
	 */
	public int deleteTheme(long themeId);
	
	/**
	 * 根据主题内容查找主题信息
	 * @param themeId
	 * @return
	 */
	public Theme getThemeById(long themeId);
	
	/**
	 * 根据条件查询主题信息
	 * @param themeVO
	 * @return
	 */
	public List<Theme> queryThemes(ThemeVO themeVO);
}
