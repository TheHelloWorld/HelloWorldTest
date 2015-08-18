package com.helloworld.service;

import java.util.List;


import com.helloworld.bean.Mission;




public interface HelloMissionService {
	
	/**
	 * �������
	 * @param mission
	 */
	public void addMission(Mission mission);
		
	/**
	 * ��������
	 * @param owner_id
	 * @param id
	 */
	public void updateMissionOwnerById(Long owner_id,Long id);
	
	/**
	 * �޸�����
	 * @param mission
	 */
	public void updateMissionById(Mission mission);
	
	/**
	 * ����id�޸�����״̬
	 * @param status
	 * @param id
	 */
	public void updateMissionStatusById(String status,Long id);
	
	/**
	 * ������п�������
	 * @return
	 */
	public List<Mission> getAlLAvailableMission();
	
	/**
	 * ����owner_id������и��˻�������
	 * @param owner_id
	 * @return
	 */
	public List<Mission> getMessionByOwnerId(Long owner_id);
	
}
