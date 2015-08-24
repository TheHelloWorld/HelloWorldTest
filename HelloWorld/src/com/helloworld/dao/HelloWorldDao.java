package com.helloworld.dao;

import org.apache.ibatis.annotations.Param;

import com.helloworld.bean.Account;



/** 
 * @Description: 这里用一句话描述这个类的作用
 * @see: HelloWorldDao 此处填写需要参考的类
 * @version 2015年08月01日 上午9:31:47 
 * @author zikun.liu
 */
public interface HelloWorldDao
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
	
	/**
	 * 查询当前email是否重复
	 * @param email
	 * @return
	 */
	public Integer getCountByEmail(String email);
	
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
	
	/**
	 * 根据id获得账户信息
	 * @param id
	 * @return
	 */
	public Account getAccountById(Long id);

}
