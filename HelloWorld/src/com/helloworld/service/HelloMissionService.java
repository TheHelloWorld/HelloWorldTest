package com.helloworld.service;

import java.util.List;


import com.helloworld.bean.Mission;




public interface HelloMissionService {
	
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
	public void updateMissionOwnerById(Long owner_id,Long id);
	
	/**
	 * 修改任务
	 * @param mission
	 */
	public void updateMissionById(Mission mission);
	
	/**
	 * 根据id修改任务状态
	 * @param status
	 * @param id
	 */
	public void updateMissionStatusById(String status,Long id);
	
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
