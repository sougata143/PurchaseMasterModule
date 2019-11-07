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


import com.aspl.org.dto.JurisdictionMasterForVendorDTO;
import com.aspl.org.entity.JurisdictionMasterForVendor;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.JurisdictionMasterService;


@RestController
@RequestMapping("/jurisdictionMaster")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JurisdictionMasterControllerforVendor {
	public static final Logger logger = LoggerFactory.getLogger(JurisdictionMasterControllerforVendor.class);
	
	@Autowired JurisdictionMasterService jurisdictionMasterService;

	@PostMapping("/jurisdictionmstsave")
	public ResponseDetails jurisdictionmaster(@RequestBody JurisdictionMasterForVendor jurisdictionMasterforVendor){
		
		
		if(jurisdictionMasterService.findByJurisdictionCode(jurisdictionMasterforVendor.getJurisdictionCode())!=null) {
				return new ResponseDetails(new Date(), "Sorry Jurisdiction code"+jurisdictionMasterforVendor.getJurisdictionCode()+" already exist.", null);
			}
		jurisdictionMasterService.jurisdictionMasterSave(jurisdictionMasterforVendor);
			return new ResponseDetails(new Date(), "'"+jurisdictionMasterforVendor.getDescription()+"' added.", null);
	}

	@GetMapping(path="/getalljurisdictionlist", produces = "application/json")
	public List<JurisdictionMasterForVendor> getalljurisdictionlist() {
		
		return  jurisdictionMasterService.getalljurisdictionlist();
	}
	
	@GetMapping("getJurisdictionMasterByJurisdictionId/{jurisdictionId}")
	public JurisdictionMasterForVendorDTO getJurisdictionMasterByJurisdictionId(@PathVariable("id") Integer id) {
		return jurisdictionMasterService.getJurisdictionMasterById(id);
	}
	
	
	
	@PutMapping("jurisdictionupdate")
	public JurisdictionMasterForVendorDTO updateJurisdictionMaster(@RequestBody JurisdictionMasterForVendorDTO jurisdictionMasterforVendorDTO) {
		return jurisdictionMasterService.updateJurisdictionMaster(jurisdictionMasterforVendorDTO);
	}
	
	
	@PutMapping("softDeleteJurisdictionMaster/{id}")
	public void softDeleteJurisdictionMaster(@PathVariable("id") Integer id) {
		jurisdictionMasterService.softDeleteJurisdictionMaster(id);
	}
	
	@DeleteMapping("permDeleteJurisdictionMaster/{id}")
	public void permDeleteDeliveryTermsMaster(@PathVariable("id") Integer id) {
		jurisdictionMasterService.permDeleteJurisdictionMaster(id);
	}
	
	

}
