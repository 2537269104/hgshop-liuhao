package com.liuhao.hgshop.dao;

import java.util.List;

import com.liuhao.hgshop.pojo.Spec;
import com.liuhao.hgshop.pojo.SpecOption;

public interface SpecDao {

	List<Spec> list(String name);

	int addSpec(Spec spec);

	int addOption(SpecOption specOption);

	int updateSpec(Spec spec);

	int deleteSpecOtions(int id);

	int deleteSpec(int id);

	Spec get(int id);

	int deleteSpecOtionsBatch(int[] ids);

	int deleteSpecBatch(int[] ids);
	
	List<Spec> listAll();
}
