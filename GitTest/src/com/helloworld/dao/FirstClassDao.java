package com.helloworld.dao;

import org.apache.ibatis.annotations.Param;

import com.helloworld.bean.Account;



/** 
 * @Description: ������һ�仰��������������
 * @see: BaseDataOfDayDao �˴���д��Ҫ�ο�����
 * @version 2014��12��31�� ����9:31:47 
 * @author jiude.sun
 */
public interface FirstClassDao
{
	
	/**
	 * �����û��������뷵������
	 * @param name
	 * @param password
	 * @return
	 */
	public Integer checkUser(@Param("username")String username,@Param("password")String password);
    
	/**
	 * ����û�
	 * @param account
	 */
	public void addUser(Account account);
	
	/**
	 * ����id�޸��û�״̬
	 * @param id
	 */
	public void updateStatusById(Long id);
	
	/**
	 * �û��޸�����
	 * @param account
	 */
	public void updateAccountById(Account account);

}
