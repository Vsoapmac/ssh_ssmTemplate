package smg.Vsoapmac.service;

import java.util.List;

import smg.Vsoapmac.springmvc.bean.city;

public interface cityService {
	
	/* 找到所有的city */
	public List<city> findAllcity();
	
	/* 根据id找到city */
	public city findById(int id);
	
	/**
	 *  根据分页查询
	 *  @param page 第几页
	 *  @param show 一页展示多少个
	 */
	public List<city> findlimit(int page , int show);
}
