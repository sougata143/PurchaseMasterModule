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

import com.aspl.org.dto.ShippingMethodMasterforVendorDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.ShippingMethodMasterforVendor;
import com.aspl.org.service.ShippingMethodMasterService;


@RestController
@RequestMapping("/shippingMethodMaster")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShippingMethodMasterControllerforVendor {
	
public static final Logger logger = LoggerFactory.getLogger(ShippingMethodMasterControllerforVendor.class);
	
	@Autowired ShippingMethodMasterService shippingMethodMasterService;

	@PostMapping("/shippingmethodmstsave")
	public ResponseDetails shippingmethodmaster(@RequestBody ShippingMethodMasterforVendor shippingMethodMasterforVendor){
		logger.info("shippingMethodMasterforVendor = "+shippingMethodMasterforVendor);
		
		if(shippingMethodMasterService.findByShippingMethodCode(shippingMethodMasterforVendor.getShippingMethodCode())!=null) {
				return new ResponseDetails(new Date(), "Sorry Shipping Method code"+shippingMethodMasterforVendor.getShippingMethodCode()+" already exist.", null);
			}
		shippingMethodMasterService.shippingMethodMasterSave(shippingMethodMasterforVendor);
			return new ResponseDetails(new Date(), "'"+shippingMethodMasterforVendor.getDescription()+"' added.", null);
	}

	@GetMapping(path="/getallshippingmethodlist", produces = "application/json")
	public List<ShippingMethodMasterforVendor> getallshippingmethodlist() {
		logger.info("getallshippingmethodlist");
		return  shippingMethodMasterService.getallshippingmethodlist();
		
	}
	
	@GetMapping("getShippingMethodMasterByShippingMethodId/{shippingMethodId}")
	public ShippingMethodMasterforVendorDTO getPaymentTermsMasterByPaymentTermsId(@PathVariable("id") Integer id) {
		return shippingMethodMasterService.getShippingMethodMasterById(id);
	}
	
	
	@PutMapping("shippingmethodmstupdate")
	public ShippingMethodMasterforVendorDTO updateShippingMethodMaster(@RequestBody ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO) {
		return shippingMethodMasterService.updateShippingMethodMaster(shippingMethodMasterforVendorDTO);
	}
	
	
	@PutMapping("softDeleteShippingMethodMaster/{id}")
	public void softDeleteShippingMethodMaster(@PathVariable("id") Integer id) {
		shippingMethodMasterService.softDeleteShippingMethodMaster(id);
	}
	
	@DeleteMapping("permDeleteShippingMethodMaster/{id}")
	public void permDeleteShippingMethodMaster(@PathVariable("id") Integer id) {
		shippingMethodMasterService.permDeleteShippingMethodMaster(id);
	}

	

}
