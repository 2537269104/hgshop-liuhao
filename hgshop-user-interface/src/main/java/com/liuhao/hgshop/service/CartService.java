package com.liuhao.hgshop.service;

import com.liuhao.hgshop.pojo.Cart;
import com.github.pagehelper.PageInfo;

/**
 * 购物车的服务
 * @author 刘浩
 *
 */
public interface CartService {

	//添加
	/**
	 * 
	 * @param uid 用户id
	 * @param skuId
	 * @param buyNum  购买数量
	 * @return
	 */
	int addCart(Integer uid, int skuId, int buyNum);
	
	//删除
	/**
	 * 
	 * @param ids   购物车的主键id
	 * @return
	 */
	int delCart(int[] ids);
	/**
	 * 清空购物车
	 * @return
	 */
	public int clearCart(int uid) ;
	
	//查看购物车
	/**
	 * 
	 * @param uid 用户id
	 * @param page
	 * @return
	 */
	PageInfo<Cart> list(int uid,int page);

	/**
	 * 
	 * @param uid
	 * @param cartIds
	 * @return
	 */
	int createOrder(Integer uid, String address,int[] cartIds); 
	
	
	

}
