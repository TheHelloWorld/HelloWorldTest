package com.helloworld.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.helloworld.bean.Mission;

public interface HelloMissionDao {
	
	/**
	 * 添加任务
	 * @param mission
	 */
	public void addMission(Mission mission);
	
	
	/**
	 * 接受任务
	 * @param owner_id
	 * @param id
	 */
	public void updateMissionById(@Param("owner_id")Long owner_id,@Param("id")Long id);
	
	/**
	 * 根据id修改任务状态
	 * @param status
	 * @param id
	 */
	public void updateMissionStatusById(@Param("status")String status,@Param("id")Long id);
	
	/**
	 * 获得所有可用任务
	 * @return
	 */
	public List<Mission> getAlLAvailableMission();
	
	/**
	 * 根据owner_id获得所有该账户下任务
	 * @param owner_id
	 * @return
	 */
	public List<Mission> getMessionByOwnerId(Long owner_id);
	
}
