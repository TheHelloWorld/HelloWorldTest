package com.helloworld.service.impl;

import javax.annotation.Resource;

import com.helloworld.bean.Account;
import com.helloworld.dao.FirstClassDao;
import com.helloworld.service.FirstClassService;
import com.helloworld.util.MD5Util;

import org.springframework.stereotype.Service;

@Service("firstClassService")
public class FristClassServiceImpl implements FirstClassService{
	
	@Resource
    private FirstClassDao firstClassDao;
	
	/**
	 * ����û��������Ƿ���ȷ
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public String checkUser(String username,String password){
		password = MD5Util.GetMD5Code(password);
		int count = firstClassDao.checkUser(username,password);
		if(count>0){
			return  "Y";
		}else{
			return  "N";
		}
		
	}
	
	/**
	 * ����û�
	 * @param account
	 */
	@Override
	public void addUser(Account account){
		firstClassDao.addUser(account);
	}
	
	/**
	 * ����id�޸��û�״̬
	 * @param id
	 */
	@Override
	public void updateStatusById(Long id){
		firstClassDao.updateStatusById(id);
	}
	
	/**
	 * �û��޸�����
	 * @param account
	 */
	@Override
	public void updateAccountById(Account account){
		firstClassDao.updateAccountById(account);
	}

}
