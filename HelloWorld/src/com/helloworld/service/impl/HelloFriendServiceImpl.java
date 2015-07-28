package com.helloworld.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.helloworld.bean.Friend;
import com.helloworld.dao.HelloFriendDao;
import com.helloworld.service.HelloFriendService;

@Service("helloFriendService")
public class HelloFriendServiceImpl implements HelloFriendService{
	
	@Resource
    private HelloFriendDao helloFriendDao;
	
	/**
	 * ��Ӻ���
	 * @param friend
	 */
	public void addFriendRequest(Friend friend){
		helloFriendDao.addFriendRequest(friend);
	}
	
	
	/**
	 * ɾ������
	 * @param userid
	 * @param friendid
	 */
	public void removeFriendByIds(Long userid,Long friendid){
		helloFriendDao.removeFriendByIds(userid, friendid);
		helloFriendDao.removeFriendByIds(friendid, userid);
	}
	
	/**
	 * ���ں���
	 * @param userid
	 * @param friendid
	 */
	public void updateFriendInBlack(@Param("userid")Long userid,@Param("friendid")Long friendid){
		helloFriendDao.updateFriendInBlack(userid, friendid);
	}
}
