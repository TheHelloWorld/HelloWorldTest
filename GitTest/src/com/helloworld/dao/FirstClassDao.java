package com.helloworld.dao;

import org.apache.ibatis.annotations.Param;

import com.helloworld.bean.Account;



/** 
 * @Description: 这里用一句话描述这个类的作用
 * @see: BaseDataOfDayDao 此处填写需要参考的类
 * @version 2014年12月31日 上午9:31:47 
 * @author jiude.sun
 */
public interface FirstClassDao
{
	
	/**
	 * 根据用户名、密码返回数量
	 * @param name
	 * @param password
	 * @return
	 */
	public Integer checkUser(@Param("username")String username,@Param("password")String password);
    
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
