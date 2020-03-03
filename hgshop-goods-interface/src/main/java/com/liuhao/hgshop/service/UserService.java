package com.liuhao.hgshop.service;
/**
 * 用户的服务接口
 * @author 刘浩
 ***** Dubbo 服务接口函数必须要有非Void 的返回值********
 */
public interface UserService {

	/**
	   *  登录成功
	 * @param userName
	 * @param passWord
	 * @return
	 */
	boolean login(String userName,String passWord);
}
