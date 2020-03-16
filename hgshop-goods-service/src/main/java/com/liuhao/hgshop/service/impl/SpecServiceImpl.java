package com.liuhao.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.hgshop.dao.SpecDao;
import com.liuhao.hgshop.pojo.Spec;
import com.liuhao.hgshop.pojo.SpecOption;
import com.liuhao.hgshop.service.SpecService;
@Service(interfaceClass = SpecService.class)
public class SpecServiceImpl implements SpecService{

	@Autowired
	private SpecDao specDao;
	@Override
	public PageInfo<Spec> list(String name, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 3);
		return new PageInfo<Spec>(specDao.list(name));
	}

	@Override
	public int add(Spec spec) {
		
		//添加主表
		specDao.addSpec(spec);
		
		//需要获取主键id 对spec-option表进行操作
		List<SpecOption> options = spec.getOptions();
		int n= 1;
		for (SpecOption specOption : options) {
			//设置spec-option 表中的spec_id值
			specOption.setSpecId(spec.getId());
			//对表spec-option进行添加
			specDao.addOption(specOption);
		    n++;
		}
		// 返回的是影响数据的条数
		return n;
	}

	@Override
	public int update(Spec spec) {
		// TODO Auto-generated method stub
		// 去子表中删除
				specDao.deleteSpecOtions(spec.getId());
				// 修改主表
				specDao.updateSpec(spec);	 
				// 插入子表
				List<SpecOption> options = spec.getOptions();
				for (SpecOption specOption : options) {
					// 设置主表的id
					specOption.setSpecId(spec.getId());
					specDao.addOption(specOption);
				}
				
				return 1;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		//先删除子表
		specDao.deleteSpecOtions(id);
		//然后删除主表
		return specDao.deleteSpec(id);
	}

	@Override
	public Spec findById(int id) {
		// TODO Auto-generated method stub
		return specDao.get(id);
	}

	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		//批量删除子表
		specDao.deleteSpecOtionsBatch(ids);
		//删除主表
		specDao.deleteSpecBatch(ids);
		
		return 1;
	}

	@Override
	public List<Spec> listAll() {
		// TODO Auto-generated method stub
		return specDao.listAll();
	}

}
