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


import com.aspl.org.dto.PaymentMethodMasterforVendorDTO;
import com.aspl.org.entity.PaymentMethodMasterforVendor;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.PaymentMethodMasterService;


@RestController
@RequestMapping("/paymentMethodMaster")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentMethodMasterControllerforVendor {
	public static final Logger logger = LoggerFactory.getLogger(PaymentMethodMasterControllerforVendor.class);
	
	@Autowired PaymentMethodMasterService paymentMethodMasterService;

	@PostMapping("/paymentmethodmstsave")
	public ResponseDetails paymentmethodmaster(@RequestBody PaymentMethodMasterforVendor paymentMethodMasterforVendor){
		
		
		if(paymentMethodMasterService.findByPaymentMethodCode(paymentMethodMasterforVendor.getPaymentMethodCode())!=null) {
				return new ResponseDetails(new Date(), "Sorry Payment Method code"+paymentMethodMasterforVendor.getPaymentMethodCode()+" already exist.", null);
			}
		paymentMethodMasterService.paymentMethodMasterSave(paymentMethodMasterforVendor);
			return new ResponseDetails(new Date(), "'"+paymentMethodMasterforVendor.getDescription()+"' added.", null);
	}

	@GetMapping(path="/getallpaymentmethodlist", produces = "application/json")
	public List<PaymentMethodMasterforVendor> getallpaymentmethodlist() {
		
		return  paymentMethodMasterService.getallpaymentmethodlist();
	}
	
	@GetMapping("getPaymentMethodMasterByPaymentMethodId/{paymentMethodId}")
	public PaymentMethodMasterforVendorDTO getPaymentMethodMasterByPaymentMethodId(@PathVariable("id") Integer id) {
		return paymentMethodMasterService.getPaymentMethodMasterById(id);
	}
	
	@PutMapping("paymentmethodmstupdate")
	public PaymentMethodMasterforVendorDTO updatePaymentMethodMaster(@RequestBody PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO) {
		return paymentMethodMasterService.updatePaymentMethodMaster(paymentMethodMasterforVendorDTO);
	}
	
	@PutMapping("softDeletePaymentMethodMaster/{id}")
	public void softDeletePaymentMethodMaster(@PathVariable("id") Integer id) {
		paymentMethodMasterService.softDeletePaymentMethodMaster(id);
	}
	
	@DeleteMapping("permDeletePaymentMethodMaster/{id}")
	public void permDeletePaymentMethodMaster(@PathVariable("id") Integer id) {
		paymentMethodMasterService.permDeletePaymentMethodMaster(id);
	}
	

}
