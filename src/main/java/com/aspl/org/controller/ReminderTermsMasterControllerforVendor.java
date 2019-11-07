package com.aspl.org.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.aspl.org.dto.ReminderTermsMasterForVendorDTO;
import com.aspl.org.entity.ReminderTermsMasterForVendor;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.ReminderTermsMasterService;

@RestController
@RequestMapping("/reminderTermsMaster")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReminderTermsMasterControllerforVendor {
	
public static final Logger logger = LoggerFactory.getLogger(ReminderTermsMasterControllerforVendor.class);
	
	@Autowired ReminderTermsMasterService reminderTermsMasterService;

	@PostMapping("/remindertermsmstsave")
	public ResponseDetails remindertermsmaster(@RequestBody ReminderTermsMasterForVendor reminderTermsMasterforVendor){
		logger.info("reminderTermsMasterforVendor = "+reminderTermsMasterforVendor);
		
		if(reminderTermsMasterService.findByReminderTermsCode(reminderTermsMasterforVendor.getReminderTermsCode())!=null) {
				return new ResponseDetails(new Date(), "Sorry Reminder Terms code"+reminderTermsMasterforVendor.getReminderTermsCode()+" already exist.", null);
			}
		reminderTermsMasterService.reminderTermsMasterSave(reminderTermsMasterforVendor);
			return new ResponseDetails(new Date(), "'"+reminderTermsMasterforVendor.getDescription()+"' added.", null);
	}

	@GetMapping(path="/getallremindertermslist", produces = "application/json")
	public List<ReminderTermsMasterForVendor> getallremindertermslist() {
		logger.info("getallremindertermslist");
		return  reminderTermsMasterService.getallremindertermslist();
	}
	
	@GetMapping("getReminderTermsMasterByReminderTermsId/{reminderTermsId}")
	public ReminderTermsMasterForVendorDTO getReminderTermsMasterByReminderTermsId(@PathVariable("id") Integer id) {
		return reminderTermsMasterService.getReminderTermsMasterById(id);
	}
	
	@PutMapping("remindertermsmstupdate")
	public ReminderTermsMasterForVendorDTO updateReminderTermsMaster(@RequestBody ReminderTermsMasterForVendorDTO reminderTermsMasterforVendorDTO) {
		return reminderTermsMasterService.updateReminderTermsMaster(reminderTermsMasterforVendorDTO);
	}
	
	
	@PutMapping("softDeleteReminderTermsMaster/{id}")
	public void softDeleteReminderTermsMaster(@PathVariable("id") Integer id) {
		reminderTermsMasterService.softDeleteReminderTermsMaster(id);
	}
	
	@DeleteMapping("permDeleteReminderTermsMaster/{id}")
	public void permDeleteReminderTermsMaster(@PathVariable("id") Integer id) {
		reminderTermsMasterService.permDeleteReminderTermsMaster(id);
	}


}
