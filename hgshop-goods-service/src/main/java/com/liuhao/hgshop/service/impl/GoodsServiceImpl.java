package com.liuhao.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.hgshop.dao.BrandDao;
import com.liuhao.hgshop.dao.CategoryDao;
import com.liuhao.hgshop.dao.SkuDao;
import com.liuhao.hgshop.dao.SpuDao;
import com.liuhao.hgshop.pojo.Brand;
import com.liuhao.hgshop.pojo.Category;
import com.liuhao.hgshop.pojo.Sku;
import com.liuhao.hgshop.pojo.SpecOption;
import com.liuhao.hgshop.pojo.Spu;
import com.liuhao.hgshop.pojo.SpuEsVo;
import com.liuhao.hgshop.pojo.SpuVo;
import com.liuhao.hgshop.service.GoodsService;
import com.liuhao.hgshop.utils.ElSearchUtil;

/**
 * 
 * @author 刘浩
 *
 */
@Service(interfaceClass=GoodsService.class)
public class GoodsServiceImpl  implements GoodsService{
	
	@Autowired
	CategoryDao catDao;
	@Autowired
	SpuDao spuDao;
	@Autowired
	SkuDao skuDao;
	@Autowired
	ElSearchUtil<SpuEsVo> elSearchUtils;
	@Autowired
	KafkaTemplate<String, String> kafakTemplate;
	
	
	@Autowired
	BrandDao brandDao;
	@Override
	public int addBrand(Brand brand) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBrand(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Brand> listBrand(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		return catDao.add(category);
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return catDao.update(category);
	}

	@Override
	public int deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return catDao.delete(id);
	}

	/**
	 * 
	 */
	@Override
	public PageInfo<Category> listCategory(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> treeCategory() {
		// TODO Auto-generated method stub
		return catDao.tree();
	}


	// spu的列表
	@Override
	public PageInfo<Spu> listSpu(int page, SpuVo vo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		
		return new PageInfo<Spu>(spuDao.list(vo));
	}

	@Override
	public int addSpu(Spu spu) {
		// TODO Auto-generated method stub
		int cnt =  spuDao.add(spu);
		//kafaTemplate.send("MyAddSpu", "spuId", cnt+"");
		
		// 将该数据收集到搜搜引擎当中
		Spu newSpu = spuDao.findById(spu.getId());
		System.err.println(" >>>>>>>>>>> spuEsVo is " + newSpu);
		SpuEsVo spuEsVo = new SpuEsVo(newSpu);
		System.out.println(" >>>>>>>>>>> spuEsVo is " + spuEsVo);
		elSearchUtils.saveObject(spu.getId().toString(), spuEsVo);
		
		// 使用kafak 去发送消息  把商品id 发送到主题MyAddSpu 上。
		kafakTemplate.send("1709d", "addspu",spu.getId().toString() );
		
		
		return cnt;
	}

	@Override
	public int updateSpu(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.update(spu);
	}

	@Override
	public int deleteSpu(int id) {
		// TODO Auto-generated method stub
		return spuDao.delete(id);
	}

	@Override
	public int deleteSpuBatch(int[] ids) {
		// TODO Auto-generated method stub
		return spuDao.deleteSpuBatch(ids);
	}

	@Override
	public List<Brand> getAllBrands() {
		// TODO Auto-generated method stub
		return brandDao.listAll();
	}

	@Override
	public PageInfo<Sku> listSku(int page, Sku sku) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		return new PageInfo<Sku>(skuDao.list(sku));
	}

	@Override
	public int addSku(Sku sku) {
		// TODO Auto-generated method stub
		//先加主表
		int cnt = skuDao.addSku(sku);
		List<SpecOption> specs = sku.getSpecs();
		//在添加specOption表
		for (SpecOption specOption : specs) {
			cnt+=skuDao.addSkuSpec(sku.getId(), specOption);
		}
		
		return cnt;
	}

	@Override
	public Sku getSku(int id) {
		// TODO Auto-generated method stub
		return skuDao.get(id);
	}

	@Override
	public int updateSku(Sku sku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSku(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSkuBatch(int[] id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Spu getSpu(int id) {
		// TODO Auto-generated method stub
		return spuDao.findById(id);
	}
	
	
	@Override
	public List<Sku> listSkuBySpu(int spuId) {
		// TODO Auto-generated method stub
		return skuDao.listBySpu(spuId);
	}
}
