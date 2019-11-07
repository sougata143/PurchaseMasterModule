package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;



import com.aspl.org.dto.ReminderTermsMasterForVendorDTO;
import com.aspl.org.entity.ReminderTermsMasterForVendor;

@Service

public interface ReminderTermsMasterService {
	 ReminderTermsMasterForVendor findByReminderTermsCode(String reminderTermsCode);
		
	 ReminderTermsMasterForVendor reminderTermsMasterSave(ReminderTermsMasterForVendor reminderTermsMasterForVendor);
			
		List<ReminderTermsMasterForVendor> getallremindertermslist();
		
		public ReminderTermsMasterForVendorDTO getReminderTermsMasterById(Integer id);
		public ReminderTermsMasterForVendorDTO prepareReminderTermsMasterDTOFromEntity(ReminderTermsMasterForVendor reminderTermsMaster);
		
		public ReminderTermsMasterForVendorDTO updateReminderTermsMaster (ReminderTermsMasterForVendorDTO reminderTermsMasterforVendorDTO);
		public void softDeleteReminderTermsMaster(Integer id);
		public void permDeleteReminderTermsMaster(Integer id);

		ReminderTermsMasterForVendor prepareReminderTermsMasterEntityFromDTO(ReminderTermsMasterForVendorDTO reminderTermsMasterforVendorDTO);

		//void permDeleteReminderTermsMaster(Integer id);

}
