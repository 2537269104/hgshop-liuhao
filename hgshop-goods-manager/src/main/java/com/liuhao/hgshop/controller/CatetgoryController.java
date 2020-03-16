package com.liuhao.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuhao.hgshop.pojo.Category;
import com.liuhao.hgshop.service.GoodsService;


/**
 *  类别管理
 * @author 刘浩
 *
 */
@Controller
@RequestMapping("cat")
public class CatetgoryController {
	
	
	@Reference
	GoodsService goodsService;
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		return "cat/list";
	}
	
	@RequestMapping("treeData")
	@ResponseBody
	public List<Category> treeData(HttpServletRequest request) {
		return goodsService.treeCategory();
	}
	/**
	 * 样式的添加
	 * @param request
	 * @param parentId
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(HttpServletRequest request,
			@RequestParam(defaultValue = "0")int parentId,String name) {
		
		Category category = new Category();
		category.setParentId(parentId);
		category.setName(name);
		
		return goodsService.addCategory(category)>0?"success":"failed";
	}
	@ResponseBody
	@RequestMapping("del")
	public String del(HttpServletRequest request,@RequestParam(defaultValue = "0")int id) {
	
		return goodsService.deleteCategory(id)>0?"success":"failed";
	}

	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request,
			Category cat) {
		System.err.println( "cat is " +  cat);
		return goodsService.updateCategory(cat)>0 ?"success":"failed";
	}
}
