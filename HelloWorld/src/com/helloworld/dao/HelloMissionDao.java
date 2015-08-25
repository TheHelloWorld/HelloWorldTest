package com.helloworld.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.helloworld.bean.Mission;

public interface HelloMissionDao {
	
	/**
	 * 发布任务
	 * @param mission
	 */
	public void addMission(Mission mission);
	
	/**
	 * 修改任务
	 * @param mission
	 */
	public void updateMissionById(Mission mission);
		
	/**
	 * 接任务
	 * @param owner_id
	 * @param id
	 */
	public void updateMissionOwnerById(@Param("owner_id")Long owner_id,@Param("id")Long id);
	
	/**
	 * 修改任务状态̬
	 * @param status
	 * @param id
	 */
	public void updateMissionStatusById(@Param("status")String status,@Param("id")Long id);
	
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
	 * 获得所有已经被接了的任务(status = 'IN')
	 * @return
	 */
	public List<Mission> getAllInMission();
	
	/**
	 * 获得任务经验
	 * @param experience
	 * @param id
	 * @return
	 */
	public void updateExperienceById(@Param("experience")Integer experience,@Param("id")Long id);
	
}
