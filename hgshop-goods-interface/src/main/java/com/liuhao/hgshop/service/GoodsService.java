package com.liuhao.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.liuhao.hgshop.pojo.Brand;
import com.liuhao.hgshop.pojo.Category;

/**
 * 商品的服务接口
 * @author 刘浩
 *
 */
public interface GoodsService {

	/**
	 * 添加商标的方法
	 * @param brand
	 * @return
	 */
	int addBrand(Brand brand);
	/**
	 * 修改商标的方法
	 * @param brand
	 * @return
	 */
	int updateBrand(Brand brand);
	/**
	 * 根据id对商标进行删除
	 * @param id
	 * @return
	 */
	int deleteBrand(Integer id);
	/**
	 * 商标数据列表 +分页+首字母的模糊搜索
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Brand> listBrand( String firstChar,int page); 
	
	/**
	   * 添加商品类别
	 * @param category
	 * @return
	 */
	int addCategory(Category category);
	/**
	 * 修改商品的类别
	 * @param category
	 * @return
	 */
	int updateCategory(Category category);
	/**
	 * 根据id对商品类别进行删除
	 * @param id
	 * @return
	 */
	int deleteCategory(Integer id);
	/**
	 * 样式表的分页查询+首字母搜索
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Category> listCategory( String firstChar,int page); 
	/**
	 * 以树的形式显示列表
	 * @return
	 */
	List<Category> treeCategory(); 
	
}
