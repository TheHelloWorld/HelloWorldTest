package com.helloworld.action;



import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.helloworld.bean.Mission;
import com.helloworld.service.HelloMissionService;



@Controller 
public class HelloMissionAction {
	
	private static final Logger logger = Logger.getLogger(HelloMissionAction.class);
	
	@Resource
    private HelloMissionService helloMissionService;
	 
	/**
	 * 添加任务
	 * @param mission
	 */
	@RequestMapping(value = "addMission")
	public void addMission(Mission mission){
		try{
			helloMissionService.addMission(mission);
		}catch(Exception e){
			logger.error("HelloMission err addMission Action msg:"+e.getMessage());
		}
		
	}
	
	
	/**
	 * 接受任务
	 * @param owner_id
	 * @param id
	 */
	public void updateMissionById(Long owner_id,Long id){
		helloMissionService.updateMissionById(owner_id, id);
	}
	
	/**
	 * 根据id修改任务状态
	 * @param status
	 * @param id
	 */
	public void updateMissionStatusById(String status,Long id){
		helloMissionService.updateMissionStatusById(status, id);
	}
	
	/**
	 * 获得所有可用任务
	 * @return
	 */
	public List<Mission> getAlLAvailableMission(){
		return helloMissionService.getAlLAvailableMission();
	}
	
	/**
	 * 根据owner_id获得所有该账户下任务
	 * @param owner_id
	 * @return
	 */
	public List<Mission> getMessionByOwnerId(Long owner_id){
		return helloMissionService.getMessionByOwnerId(owner_id);
	}
	 
 	
}
