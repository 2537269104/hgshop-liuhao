package com.liuhao.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.hgshop.dao.BrandDao;
import com.liuhao.hgshop.pojo.Brand;
import com.liuhao.hgshop.service.BrandService;
@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl implements BrandService{

	
	
	@Autowired
	private BrandDao brandDao;
	@Override
	public PageInfo<Brand> list(String firstChar, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 3);
		return new PageInfo<Brand>(brandDao.list(firstChar));
	}

	@Override
	public int add(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.addBrand(brand);
	}

	@Override
	public int update(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.updateBrand(brand);
	}

	@Override
	public Brand findById(int id) {
		// TODO Auto-generated method stub
		return brandDao.get(id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return brandDao.deleteBrand(id);
	}

	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		return brandDao.deleteBrandBatch(ids);
	}

}
