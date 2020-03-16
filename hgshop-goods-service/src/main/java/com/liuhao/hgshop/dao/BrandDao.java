package com.liuhao.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.liuhao.hgshop.pojo.Brand;

public interface BrandDao {

	List<Brand> list(String name);

	int addBrand(Brand brand);

	int updateBrand(Brand brand);

	int deleteBrand(int id);

	Brand get(int id);

	int deleteBrandBatch(int[] ids);

	@Select("SELECT id,name,first_char as firstChar "
			+ " FROM hg_brand "
			+ "where deleted_flag=0"
			+ " ORDER BY name ")
	List<Brand> listAll();
}
