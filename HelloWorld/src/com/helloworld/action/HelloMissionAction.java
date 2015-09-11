package com.helloworld.action;


import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.helloworld.bean.Mission;
import com.helloworld.service.HelloMissionService;
import com.helloworld.service.HelloWorldService;



@Controller 
public class HelloMissionAction {
	
	private static final Logger logger = Logger.getLogger(HelloMissionAction.class);
	
	@Resource
    private HelloMissionService helloMissionService;
	
	@Resource
    private HelloWorldService helloWorldService;
	
	
	/**
	 * 添加任务
	 * @param mission
	 */
	@RequestMapping(value = "toAddMission")
	public String toAddMission(Long id,Model model){
		try{
			model.addAttribute("id", id);
			return "addMissionPage";
		}catch(Exception e){
			logger.error("HelloMission err Action addMission msg:"+e.getMessage());
			e.printStackTrace();
			return "500";
		}	
	}
	
	/**
	 * 添加任务
	 * @param mission
	 */
	@ResponseBody
	@RequestMapping(value = "addMission")
	public String addMission(Mission mission){
		try{		
			helloMissionService.addMission(mission);				
			return "Y";
		}catch(Exception e){
			logger.error("HelloMission err Action addMission msg:"+e.getMessage());
			e.printStackTrace();
			return "N";
		}	
	}
	
	@RequestMapping(value = "toUpdateMission")
	public String toUpdateMission(Long id,Model model){
		try{
			Mission mission = helloMissionService.getMissionById(id);
			model.addAttribute("model", mission);
			return "updateMission";
		}catch(Exception e){
			logger.error("HelloMission err Action toUpdateMission msg:"+e.getMessage());
			e.printStackTrace();
			return "500";
		}
	}
	
	
	/**
	 * 接受任务
	 * @param owner_id
	 * @param id
	 */
	
	@RequestMapping(value = "updateMissionOwnerById")
	public void updateMissionOwnerBydId(Long owner_id,Long id){
		try{
			helloMissionService.updateMissionOwnerById(owner_id, id);
		}catch(Exception e){
			logger.error("HelloMission err Action updateMissionOwnerById msg:"+e.getMessage());
			e.printStackTrace();
		}		
	}
	
	
	
	/**
	 * 修改任务
	 * @param mission
	 */
	@RequestMapping(value = "updateMission")
	public String updateMissionById(Mission mission,Model model){
		try{
			helloMissionService.updateMissionById(mission);
			List<Mission> listIMission = helloMissionService.getAllInMission();
			model.addAttribute("listIMission",listIMission);
			return "backStageManagement";
		}catch(Exception e){
			logger.error("HelloMission err Action updateMissionById msg:"+e.getMessage());
			e.printStackTrace();
			return "500";
		}		
	}
	
	
	/**
	 * 根据id修改任务状态
	 * @param status
	 * @param id
	 */
	@RequestMapping(value = "updateMissionStatusById")
	public void updateMissionStatusById(String status,Long id){
		try{
			helloMissionService.updateMissionStatusById(status, id);
		}catch(Exception e){
			logger.error("HelloMission err Action updateMissionStatusById msg:"+e.getMessage());
			e.printStackTrace();
		}
	}
 	
}
