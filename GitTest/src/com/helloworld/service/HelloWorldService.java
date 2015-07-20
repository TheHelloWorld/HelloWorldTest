package com.helloworld.service;

import com.helloworld.bean.Account;

public interface HelloWorldService {
	
	/**
	 * 检查用户名密码是否正确
	 * @param username
	 * @param password
	 * @return
	 */
	public String checkUser(String username,String password);
	
	/**
	 * 查询当前email是否重复
	 * @param email
	 * @return
	 */
	public String checkEmail(String email);
	
	/**
	 * 添加用户
	 * @param account
	 */
	public void addUser(Account account);
	
	/**
	 * 根据id修改用户状态
	 * @param id
	 */
	public void updateStatusById(Long id);
	
	/**
	 * 用户修改资料
	 * @param account
	 */
	public void updateAccountById(Account account);
	
	/**
	 * 根据id判断账户是否存在
	 * @param id
	 * @return
	 */
	public Integer getNumById(Long id);
	
	/**
	 * 根据id获得账户激活状态
	 * @param id
	 * @return
	 */
	public String getStatusById(Long id);
	
	/**
	 * 根据用户名、密码获得账户激活状态
	 * @param account
	 * @return
	 */
	public String getStatusByAccount(Account account);
	

}
