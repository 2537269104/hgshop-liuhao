package com.liuhao.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.liuhao.hgshop.pojo.Brand;
import com.liuhao.hgshop.service.BrandService;

@Controller
@RequestMapping("brand")
public class BrandController {

        @Reference
        private BrandService brandService;
        /**
                         *  进入规格的列表
         * @param request
         * @param page
         * @param name
         * @return
         */
        @RequestMapping("list")
        public String list(HttpServletRequest request,
    			@RequestParam(defaultValue="1") int page,
    			@RequestParam(defaultValue="") String firstChar) {
        
        	PageInfo<Brand> pageInfo = brandService.list(firstChar,page);
        	System.err.println(pageInfo.getList());
        	request.setAttribute("pageInfo", pageInfo);
        	request.setAttribute("queryName", firstChar);
        	return "brand/list";
        }
        @ResponseBody
        @RequestMapping("add")
        public String add(HttpServletRequest request,Brand brand ) {
        	
        	System.out.println("brand" + brand);
        	
        	//调用服务
        	int add = brandService.add(brand);
        	
        	return add>0?"success":"false";
        }
        
    	/**
    	 * 用于修改数据时候的回显
    	 * @param request
    	 * @param id 规格id
    	 * @return
    	 */
    	@RequestMapping("getBrand")
    	@ResponseBody
    	public Brand getBrand(HttpServletRequest request, int id){
    		return brandService.findById(id);
    		
    	}
    	/**
    	 * 删除规格
    	 * @param request
    	 * @param id  规格的id
    	 * @return
    	 */
    	@RequestMapping("delBrand")
    	@ResponseBody
    	public String delSpec(HttpServletRequest request,int id) {
    		//调用服务
    		int delNum = brandService.delete(id);
    		return delNum>0?"success":"false";
    	}
    	
    	/**
    	 * 删除规格
    	 * @param request
    	 * @param id  规格的id
    	 * @return
    	 */
    	@RequestMapping("delBrandBatch")
    	@ResponseBody
    	public String delSpecBatch(HttpServletRequest request,@RequestParam(name="ids[]") int[] ids) {
    		System.out.println("要删除的额数据");
    		for (int i : ids) {
    			System.out.println(" i is " + i  );
    		}
    		//调用服务
    		int delNum = brandService.deleteBatch(ids);
    		return delNum>0?"success":"false";
    	}
    	@ResponseBody
    	@RequestMapping("update")
    	public String update(HttpServletRequest request,Brand brand ) {
        	
        	System.out.println("brand" + brand);
        	
        	//调用服务
        	int update = brandService.update(brand);
        	
        	return update>0?"success":"false";
        }
}
