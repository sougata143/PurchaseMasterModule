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

import com.aspl.org.dto.DeliveryTermsMasterforVendorDTO;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.DeliveryTermsMasterService;


@RestController
@RequestMapping("/deliveryTermsMaster")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class DeliveryTermsMasterControllerforVendor {
	public static final Logger logger = LoggerFactory.getLogger(DeliveryTermsMasterControllerforVendor.class);
	
	@Autowired DeliveryTermsMasterService deliveryTermsMasterService;

	@PostMapping("/deliverytermssave")
	public ResponseDetails deliverytermsmaster(@RequestBody DeliveryTermsMasterforVendor deliveryTermsMasterforVendor){
		
		
		if(deliveryTermsMasterService.findByDeliveryTermsCode(deliveryTermsMasterforVendor.getDeliveryTermsCode())!=null) {
				return new ResponseDetails(new Date(), "Sorry Delivery terms code"+deliveryTermsMasterforVendor.getDeliveryTermsCode()+" already exist.", null);
			}
		deliveryTermsMasterService.deliveryTermsMasterSave(deliveryTermsMasterforVendor);
			return new ResponseDetails(new Date(), "'"+deliveryTermsMasterforVendor.getDescription()+"' added.", null);
	}

	@GetMapping(path="/getalldeliverytermslist", produces = "application/json")
	public List<DeliveryTermsMasterforVendor> getalldeliverytermslist() {
		
		return  deliveryTermsMasterService.getalldeliverytermslist();
	}
	
	@GetMapping("getDeliveryTermsMasterByDeliveryTermsId/{deliveryTermsId}")
	public DeliveryTermsMasterforVendorDTO getDeliveryTermsMasterByDeliveryTermsId(@PathVariable("id") Integer id) {
		return deliveryTermsMasterService.getDeliveryTermsMasterById(id);
	}
	
	
	
	@PutMapping("deliverytermsmstupdate")
	public DeliveryTermsMasterforVendorDTO updateDeliveryTermsMaster(@RequestBody DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO) {
		return deliveryTermsMasterService.updateDeliveryTermsMaster(deliveryTermsMasterforVendorDTO);
	}
	
	
	@PutMapping("softDeleteDeliveryTermsMaster/{id}")
	public void softDeleteDeliveryTermsMaster(@PathVariable("id") Integer id) {
		deliveryTermsMasterService.softDeleteDeliveryTermsMaster(id);
	}
	
	@DeleteMapping("permDeleteDeliveryTermsMaster/{id}")
	public void permDeleteDeliveryTermsMaster(@PathVariable("id") Integer id) {
		deliveryTermsMasterService.permDeleteDeliveryTermsMaster(id);
	}
	

}
