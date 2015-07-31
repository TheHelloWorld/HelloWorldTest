package com.helloworld.service;


import java.util.List;

import com.helloworld.bean.Friend;

public interface HelloFriendService {
	
	/**
	 * ��Ӻ���
	 * @param friend
	 */
	public void addFriendRequest(Friend friend);
	
	
	/**
	 * ɾ������
	 * @param userid
	 * @param friendid
	 */
	public void removeFriendByIds(Long userid,Long friendid);
	
	/**
	 * ���ں���
	 * @param userid
	 * @param friendid
	 */
	public void updateFriendInBlack(Long userid,Long friendid);
	
	/**
	 * ����id��ú����б�
	 * @param userid
	 * @return
	 */
	public List<Friend> getFriendById(Long userid);
}
