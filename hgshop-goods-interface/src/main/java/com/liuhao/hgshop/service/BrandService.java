package com.liuhao.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.liuhao.hgshop.pojo.Brand;

public interface BrandService {

	/**
	   *  品牌表的列表查询+分页
	 * @param name
	 * @param page
	 * @return
	 */
    PageInfo<Brand> list(String name,int page);
	/**
	 * 品牌表的添加
	 * @param spec
	 * @return
	 */
	int add(Brand brand);
	/**
	 * 品牌表的修改
	 * @param spec
	 * @return
	 */
	int update(Brand brand);
	/**
	 * 品牌表的删除
	 * @param id
	 * @return
	 */
	int delete(int id);
	
	/**
	 * 查找一个品牌 用于修改时候的回显
	 * @param id
	 * @return
	 */
	Brand findById(int id);
	
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	int deleteBatch(int[] id);
	
}
