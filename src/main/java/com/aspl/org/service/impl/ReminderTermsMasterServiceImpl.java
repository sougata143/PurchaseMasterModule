package com.aspl.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.ReminderTermsMasterForVendorDTO;
import com.aspl.org.entity.ReminderTermsMasterForVendor;
import com.aspl.org.repository.ReminderTermsMasterDao;
import com.aspl.org.service.ReminderTermsMasterService;

/*
 * Service for Reminder Terms Master of Vendor 
 */
@Service
@Transactional

public class ReminderTermsMasterServiceImpl implements ReminderTermsMasterService{
	@Autowired ReminderTermsMasterDao reminderTermsMasterDao;
	
	/*
	 * @Param reminderTermsCode
	 * 
	 * Method to find Reminder Terms master by reminderTermsCode
	 * 
	 * @Return reminderTermsMaster
	 * 
	 */

	@Override
	public ReminderTermsMasterForVendor findByReminderTermsCode(String reminderTermsCode) {
		
		ReminderTermsMasterForVendor reminderTermsMaster=reminderTermsMasterDao.findByReminderTermsCode(reminderTermsCode);
		  return reminderTermsMaster;
	}
	
	/*
	   * @Param reminderTermsMasterForVendor
	   * 
	   * Method for saving reminder terms master for vendor
	   * 
	   * @Return reminderTermsMasterForVendor
	   */

	@Override
	public ReminderTermsMasterForVendor reminderTermsMasterSave(
			ReminderTermsMasterForVendor reminderTermsMasterForVendor) {
	
		return reminderTermsMasterDao.save(reminderTermsMasterForVendor);
	}
	
	/*
	 * Method for getting all reminder terms master list
	 * 
	 * 
	 */

	@Override
	public List<ReminderTermsMasterForVendor> getallremindertermslist() {
		return reminderTermsMasterDao.findAll();
	}
	
	/*
	 *@Param reminderTermsMasterforVendorDTO
	 *
	 * Method for updating reminder terms master for vendor
	 * 
	 * @Return reminderTermsMasterforVendorDTO
	 */

	@Override
	public ReminderTermsMasterForVendorDTO updateReminderTermsMaster(
			ReminderTermsMasterForVendorDTO reminderTermsMasterforVendorDTO) {
		ReminderTermsMasterForVendor rtm = prepareReminderTermsMasterEntityFromDTO(reminderTermsMasterforVendorDTO);
		rtm.setId(reminderTermsMasterforVendorDTO.getId());
		try {
			reminderTermsMasterDao.save(rtm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return reminderTermsMasterforVendorDTO;
	}
	
	/*
	 * @Param id
	 * 
	 * Method for soft delete reminder terms master of vendor
	 * 
	 * @Return rtm
	 * 
	 */

	@Override
	public void softDeleteReminderTermsMaster(Integer id) {
		ReminderTermsMasterForVendor rtm = reminderTermsMasterDao.findById(id).get();
		rtm.setIsActive(0);
		reminderTermsMasterDao.save(rtm);
	}

	@Override
	public void permDeleteReminderTermsMaster(Integer id) {
		reminderTermsMasterDao.deleteById(id);
		
	}
	
	/*
	 * @Param reminderTermsMasterforVendorDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return rtMaster 
	 */

	@Override
	public ReminderTermsMasterForVendor prepareReminderTermsMasterEntityFromDTO(
			ReminderTermsMasterForVendorDTO reminderTermsMasterforVendorDTO) {
		 ReminderTermsMasterForVendor rtMaster = new ReminderTermsMasterForVendor();
			
		 rtMaster.setDescription(reminderTermsMasterforVendorDTO.getDescription());
				if(reminderTermsMasterforVendorDTO.getVendorDTO()!=null) {
					rtMaster.setId(reminderTermsMasterforVendorDTO.getVendorDTO().getId());
					}
				
				rtMaster.setReminderTermsCode(reminderTermsMasterforVendorDTO.getReminderTermsCode());
				rtMaster.setMaxReminder(reminderTermsMasterforVendorDTO.getMaxReminder());
				rtMaster.setIsActive(1);
				
				return rtMaster;	
				}
	
	/*
	 * @Param id
	 * 
	 * Method to get details of reminder terms master of vendor by id
	 * 
	 * @Return rtmDTO
	 * 
	 */

	@Override
	public ReminderTermsMasterForVendorDTO getReminderTermsMasterById(Integer id) {
		ReminderTermsMasterForVendor rtm = reminderTermsMasterDao.findById(id).get();
		ReminderTermsMasterForVendorDTO rtmDTO = new ReminderTermsMasterForVendorDTO();
		rtmDTO = prepareReminderTermsMasterDTOFromEntity(rtm);
		return rtmDTO;
	}
	
	/*
	 * @Param reminderTermsMasterforVendorDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return rtMaster 
	 */


	@Override
	public ReminderTermsMasterForVendorDTO prepareReminderTermsMasterDTOFromEntity(
			ReminderTermsMasterForVendor reminderTermsMaster) {
		ReminderTermsMasterForVendorDTO rtmDTO = new ReminderTermsMasterForVendorDTO();
		rtmDTO.setReminderTermsCode(reminderTermsMaster.getReminderTermsCode());
		rtmDTO.setDescription(reminderTermsMaster.getDescription());
		rtmDTO.setId(reminderTermsMaster.getId());
		rtmDTO.setMaxReminder(reminderTermsMaster.getMaxReminder());
		
	
		return rtmDTO;
	}


}
