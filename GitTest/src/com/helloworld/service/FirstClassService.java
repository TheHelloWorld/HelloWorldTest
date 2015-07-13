package com.helloworld.service;

import com.helloworld.bean.Account;

public interface FirstClassService {
	
	/**
	 * ����û��������Ƿ���ȷ
	 * @param username
	 * @param password
	 * @return
	 */
	public String checkUser(String username,String password);
	
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
