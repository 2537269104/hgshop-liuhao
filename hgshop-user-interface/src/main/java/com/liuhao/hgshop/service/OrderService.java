package com.liuhao.hgshop.service;

import java.util.List;

import com.liuhao.hgshop.pojo.Order;
import com.liuhao.hgshop.pojo.OrderDetail;
import com.github.pagehelper.PageInfo;

/**
 * 订单的服务
 * @author 刘浩
 *
 */
public interface OrderService {

	
	/**
	 * 查看订单
	 * @param userId
	 * @param page
	 * @return
	 */
	PageInfo<Order> list(int userId,int page);
	
	/**
	 * 查看订单详情
	 * @param orderId
	 * @param page
	 * @return
	 */
	List<OrderDetail> listDetail(int orderId,int page);
	
	
	
	

}
