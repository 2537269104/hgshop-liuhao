package com.liuhao.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.liuhao.hgshop.pojo.Spec;

public interface SpecService {

	/**
	   *  规格表的列表查询+分页
	 * @param name
	 * @param page
	 * @return
	 */
    PageInfo<Spec> list(String name,int page);
	/**
	 * 规格表的添加
	 * @param spec
	 * @return
	 */
	int add(Spec spec);
	/**
	 * 规格表的修改
	 * @param spec
	 * @return
	 */
	int update(Spec spec);
	/**
	 * 规格表的删除
	 * @param id
	 * @return
	 */
	int delete(int id);
	
	/**
	 * 查找一个规格 用于修改时候的回显
	 * @param id
	 * @return
	 */
	Spec findById(int id);
	
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	int deleteBatch(int[] id);
	
	
	List<Spec> listAll();
	
}
