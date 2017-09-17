package com.ysl.snsDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysl.snsDemo.dao.ThemeDao;
import com.ysl.snsDemo.entity.Theme;
import com.ysl.snsDemo.entity.ThemeVO;
import com.ysl.snsDemo.service.ThemeService;

@Service
@CacheConfig(cacheNames="themeCache")//默认缓存名
public class ThemeServiceImpl implements ThemeService{
	
	@Autowired
	private ThemeDao themeDao;
	
	@CachePut(key="#p0.id")//以ID为key把数据缓存到redis 
	@Override
	public Theme publishTheme(Theme theme) {
		//使用MYSQL的自增生产ID
		themeDao.publishTheme(theme);
		return themeDao.getThemeById(theme.getId());
	}
	
	@CachePut(key="#p0.id")//以ID为key更新redis缓存
	@Override
	public Theme updateTheme(Theme theme) {
		themeDao.updateTheme(theme);
		return themeDao.getThemeById(theme.getId());
	}
	
	@CacheEvict(key="#p0")//把对象从缓存中移除
	@Override
	public int deleteTheme(long themeId) {
		return themeDao.deleteTheme(themeId);
	}

	@Override
	public PageInfo<Theme> getThemeList(PageInfo<Theme> pageInfo, ThemeVO theme) {
		Page<Theme> page = PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
		this.themeDao.queryThemes(theme);
		return page.toPageInfo();
	}
	
	@Cacheable(key="#p0")//先查缓存，缓存中没有再去读数据库
	@Override
	public Theme getThemeById(long themeId) {
		return themeDao.getThemeById(themeId);
	}
}
