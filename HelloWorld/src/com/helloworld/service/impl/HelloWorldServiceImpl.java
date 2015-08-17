package com.helloworld.service.impl;

import javax.annotation.Resource;

import com.helloworld.bean.Account;
import com.helloworld.dao.HelloWorldDao;
import com.helloworld.service.HelloWorldService;
import com.helloworld.util.MD5Util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService{
	
	private static final Logger logger = Logger.getLogger(HelloWorldServiceImpl.class);
	
	@Resource
    private HelloWorldDao helloWorldDao;
	
	/**
	 * 检查用户名密码是否正确
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public String checkUser(String username,String password){
		try{
			password = MD5Util.GetMD5Code(password);
			int count = helloWorldDao.checkUser(username,password);
			if(count>0){
				return  "Y";
			}else{
				return  "N";
			}
		}catch(Exception e){
			logger.error("HelloWorld err ServiceImple checkUser msg:"+e.getMessage());
			return "N";
		}	
	}
	
	/**
	 * 添加用户
	 * @param account
	 */
	@Override
	public void addUser(Account account){
		try{
			//进行MD5加密
			account.setPassword(MD5Util.GetMD5Code(account.getPassword()));
			helloWorldDao.addUser(account);
		}catch(Exception e){
			logger.error("HelloWorld err ServiceImple addUser msg:"+e.getMessage());
		}
	}
	
	/**
	 * 根据id修改用户状态
	 * @param id
	 */
	@Override
	public void updateStatusById(Long id){
		try{
			helloWorldDao.updateStatusById(id);
		}catch(Exception e){
			logger.error("HelloWorld err ServiceImple updateStatusById msg:"+e.getMessage());
		}		
	}
	
	/**
	 * 用户修改资料
	 * @param account
	 */
	@Override
	public void updateAccountById(Account account){
		try{
			helloWorldDao.updateAccountById(account);
		}catch(Exception e){
			logger.error("HelloWorld err ServiceImple updateAccountById msg:"+e.getMessage());
		}		
	}
	
	@Override
	public String checkEmail(String email){
		try{
			if(helloWorldDao.getCountByEmail(email)>0){
				return "N";
			}else{
				return "Y";
			}
		}catch(Exception e){
			logger.error("HelloWorld err ServiceImple checkEmail msg:"+e.getMessage());
			return "N";
		}
	}
	
	/**
	 * 根据id判断账户是否存在
	 * @param id
	 * @return
	 */
	@Override
	public Integer getNumById(Long id){
		try{
			Integer num = helloWorldDao.getNumById(id);
			return num;
		}catch(Exception e){
			logger.error("HelloWorld err ServiceImple getNumById msg:"+e.getMessage());
			return null;
		}		
	}
	
	/**
	 * 根据id获得账户激活状态
	 * @param id
	 * @return
	 */
	@Override
	public String getStatusById(Long id){
		try{
			String str = helloWorldDao.getStatusById(id);
			return str;
		}catch(Exception e){
			logger.error("HelloWorld err ServiceImple getStatusById msg:"+e.getMessage());
			return null;
		}
	}
	
	/**
	 * 根据用户名、密码获得账户激活状态
	 * @param account
	 * @return
	 */
	@Override
	public String getStatusByAccount(Account account){
		try{
			String str = helloWorldDao.getStatusByAccount(account);
			return  str;
		}catch(Exception e){
			logger.error("HelloWorld err ServiceImple getStatusByAccount msg:"+e.getMessage());
			return null;
		}	
	}

}
