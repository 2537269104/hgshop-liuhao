package com.liuhao.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liuhao.hgshop.pojo.Sku;
import com.liuhao.hgshop.pojo.SpecOption;

/**
 * 
 * @author 刘浩
 *
 */
public interface SkuDao {
	
	
	List<Sku> list(Sku sku);
	
	Sku get(int id);
	
	// 添加sku
	int addSku(Sku sku);
	//添加对应sku的属性值
	int addSkuSpec(@Param("skuId") int skuId,@Param("so") SpecOption so);

	/**
	 * 获取一个sku的列表  根据spu
	 * @param spuId
	 * @return
	 */
	List<Sku> listBySpu(int spuId);
	
	
	
	
}
