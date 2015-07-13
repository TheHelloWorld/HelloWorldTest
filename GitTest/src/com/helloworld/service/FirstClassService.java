package com.helloworld.service;

import com.helloworld.bean.Account;

public interface FirstClassService {
	
	/**
	 * 检查用户名密码是否正确
	 * @param username
	 * @param password
	 * @return
	 */
	public String checkUser(String username,String password);
	
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
	

}
