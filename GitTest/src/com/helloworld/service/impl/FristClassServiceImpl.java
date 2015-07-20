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
	 * 检查用户名密码是否正确
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
	 * 添加用户
	 * @param account
	 */
	@Override
	public void addUser(Account account){
		//进行MD5加密
		account.setPassword(MD5Util.GetMD5Code(account.getPassword()));
		firstClassDao.addUser(account);
	}
	
	/**
	 * 根据id修改用户状态
	 * @param id
	 */
	@Override
	public void updateStatusById(Long id){
		firstClassDao.updateStatusById(id);
	}
	
	/**
	 * 用户修改资料
	 * @param account
	 */
	@Override
	public void updateAccountById(Account account){
		firstClassDao.updateAccountById(account);
	}
	
	@Override
	public String checkEmail(String email){
		if(firstClassDao.getCountByEmail(email)>0){
			return "N";
		}else{
			return "Y";
		}
	}
	
	/**
	 * 根据id判断账户是否存在
	 * @param id
	 * @return
	 */
	@Override
	public Integer getNumById(Long id){
		return firstClassDao.getNumById(id);
	}
	
	/**
	 * 根据id获得账户激活状态
	 * @param id
	 * @return
	 */
	@Override
	public String getStatusById(Long id){
		return firstClassDao.getStatusById(id);
	}
	
	/**
	 * 根据用户名、密码获得账户激活状态
	 * @param account
	 * @return
	 */
	@Override
	public String getStatusByAccount(Account account){
		return firstClassDao.getStatusByAccount(account);
	}

}
