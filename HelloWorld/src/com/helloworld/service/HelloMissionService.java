package com.helloworld.service;

import java.util.List;


import com.helloworld.bean.Mission;




public interface HelloMissionService {
	
	/**
	 * 发布任务
	 * @param mission
	 */
	public void addMission(Mission mission);
		
	/**
	 * 接任务
	 * @param owner_id
	 * @param id
	 */
	public void updateMissionOwnerById(Long owner_id,Long id);
	
	/**
	 * 修改任务
	 * @param mission
	 */
	public void updateMissionById(Mission mission);
	
	/**
	 * 修改任务状态̬
	 * @param status
	 * @param id
	 */
	public void updateMissionStatusById(String status,Long id);
	
	/**
	 * 获得所有未接任务
	 * @return
	 */
	public List<Mission> getAllAvailableMission();
	
	/**
	 * 根据用户id获得所有以接任务
	 * @param owner_id
	 * @return
	 */
	public List<Mission> getMessionByOwnerId(Long owner_id);
	
	/**
	 * 获得任务经验
	 * @param experience
	 * @param id
	 * @return
	 */
	public void updateExperienceById(Integer experience,Long id);
	
}
