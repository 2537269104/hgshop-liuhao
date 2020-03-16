package com.liuhao.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.hgshop.dao.OrderDao;
import com.liuhao.hgshop.pojo.Order;
import com.liuhao.hgshop.pojo.OrderDetail;
import com.liuhao.hgshop.service.OrderService;

/**
 * 
 * @author zhuzg
 *
 */
@Service(interfaceClass=OrderService.class)
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDao orderDao;

	@Override
	public PageInfo<Order> list(int userId, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		
		return new PageInfo<Order>(orderDao.list(userId));
	}

	@Override
	public List<OrderDetail> listDetail(int orderId, int page) {
		// TODO Auto-generated method stub
		return orderDao.listDetail(orderId);
	}
	
}
