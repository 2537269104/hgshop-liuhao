package com.liuhao.hgshop.dao;

import java.util.List;

import com.liuhao.hgshop.pojo.Category;


/**
 * 
 * @author 刘浩
 *
 */
public interface CategoryDao {

	 List<Category> tree();

	int delete(Integer id);

	int update(Category category);

	int add(Category category);
}
