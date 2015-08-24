package com.helloworld.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.helloworld.bean.Mission;

public interface HelloMissionDao {
	
	/**
	 * �������
	 * @param mission
	 */
	public void addMission(Mission mission);
	
	/**
	 * �޸�����
	 * @param mission
	 */
	public void updateMissionById(Mission mission);
		
	/**
	 * ��������
	 * @param owner_id
	 * @param id
	 */
	public void updateMissionOwnerById(@Param("owner_id")Long owner_id,@Param("id")Long id);
	
	/**
	 * ����id�޸�����״̬
	 * @param status
	 * @param id
	 */
	public void updateMissionStatusById(@Param("status")String status,@Param("id")Long id);
	
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
	
	/**
	 * �޸��˻�����ֵ
	 * @param experience
	 * @param id
	 * @return
	 */
	public void updateExperienceById(@Param("experience")Integer experience,@Param("id")Long id);
	
}
