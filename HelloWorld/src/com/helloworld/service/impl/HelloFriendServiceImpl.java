package com.helloworld.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.helloworld.bean.Friend;
import com.helloworld.dao.HelloFriendDao;
import com.helloworld.service.HelloFriendService;

@Service("helloFriendService")
public class HelloFriendServiceImpl implements HelloFriendService{
	
	private static final Logger logger = Logger.getLogger(HelloFriendServiceImpl.class);
	
	@Resource
    private HelloFriendDao helloFriendDao;
	
	/**
	 * ��Ӻ���
	 * @param friend
	 */
	@Override
	public void addFriendRequest(Friend friend){
		try{
			helloFriendDao.addFriendRequest(friend);
		}catch(Exception e){
			logger.error("HelloFriend err ServiceImple addFriendRequest msg:"+e.getMessage());
		}		
	}
	
	
	/**
	 * ɾ������
	 * @param userid
	 * @param friendid
	 */
	@Override
	public void removeFriendByIds(Long userid,Long friendid){
		try{
			helloFriendDao.removeFriendByIds(userid, friendid);
			helloFriendDao.removeFriendByIds(friendid, userid);
		}catch(Exception e){
			logger.error("HelloFriend err ServiceImple removeFriendByIds msg:"+e.getMessage());
		}	
		
	}
	
	
	/**
	 * ���ں���
	 * @param userid
	 * @param friendid
	 */
	@Override
	public void updateFriendInBlack(Long userid,Long friendid){
		try{
			helloFriendDao.updateFriendInBlack(userid, friendid);
		}catch(Exception e){
			logger.error("HelloFriend err ServiceImple updateFriendInBlack msg:"+e.getMessage());
		}	
		
	}
	
	
	/**
	 * ����id��ú����б�
	 */
	@Override
	public List<Friend> getFriendById(Long userid){
		try{
			List<Friend> list = helloFriendDao.getFriendyId(userid);
			return list;
		}catch(Exception e){
			logger.error("HelloFriend err ServiceImple getFriendById msg:"+e.getMessage());
			return null;
		}	
		
	}
}
