package com.helloworld.service.impl;

import java.util.List;

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
	 * 添加好友
	 * @param friend
	 */
	@Override
	public void addFriendRequest(Friend friend){
		helloFriendDao.addFriendRequest(friend);
	}
	
	
	/**
	 * 删除好友
	 * @param userid
	 * @param friendid
	 */
	@Override
	public void removeFriendByIds(Long userid,Long friendid){
		helloFriendDao.removeFriendByIds(userid, friendid);
		helloFriendDao.removeFriendByIds(friendid, userid);
	}
	
	/**
	 * 拉黑好友
	 * @param userid
	 * @param friendid
	 */
	@Override
	public void updateFriendInBlack(@Param("userid")Long userid,@Param("friendid")Long friendid){
		helloFriendDao.updateFriendInBlack(userid, friendid);
	}
	
	/**
	 * 根据id获得好友列表
	 */
	@Override
	public List<Friend> getFriendById(Long userid){
		return helloFriendDao.getFriendyId(userid);
	}
}
