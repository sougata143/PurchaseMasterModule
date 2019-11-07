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

import com.aspl.org.dto.PaymentTermsMasterforVendorDTO;
import com.aspl.org.entity.PaymentTermsMasterforVendor;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.PaymentTermsMasterService;


@RestController
@RequestMapping("/paymentTermsMaster")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentTermsMasterControllerforVendor {
	
	public static final Logger logger = LoggerFactory.getLogger(PaymentTermsMasterControllerforVendor.class);
	
	@Autowired PaymentTermsMasterService paymentTermsMasterService;

	@PostMapping("/paymenttermsmstsave")
	public ResponseDetails paymenttermsmaster(@RequestBody PaymentTermsMasterforVendor paymentTermsMasterforVendor){
		
		
		if(paymentTermsMasterService.findByPaymentTermsCode(paymentTermsMasterforVendor.getPaymentTermsCode())!=null) {
				return new ResponseDetails(new Date(), "Sorry Payment Terms code"+paymentTermsMasterforVendor.getPaymentTermsCode()+" already exist.", null);
			}
		paymentTermsMasterService.paymentTermsMasterSave(paymentTermsMasterforVendor);
			return new ResponseDetails(new Date(), "'"+paymentTermsMasterforVendor.getDescription()+"' added.", null);
	}

	@GetMapping(path="/getallpaymentmethodlist", produces = "application/json")
	public List<PaymentTermsMasterforVendor> getallpaymenttermslist() {
		
		return  paymentTermsMasterService.getallpaymenttermslist();
	}
	
	@GetMapping("getPaymentTermsMasterByPaymentTermsId/{paymentTermsId}")
	public PaymentTermsMasterforVendorDTO getPaymentTermsMasterByPaymentTermsId(@PathVariable("id") Integer id) {
		return paymentTermsMasterService.getPaymentTermsMasterById(id);
	}
	
	@PutMapping("paymenttermsmstupdate")
	public PaymentTermsMasterforVendorDTO updatePaymentTermsMaster(@RequestBody PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO) {
		return paymentTermsMasterService.updatePaymentTermsMaster(paymentTermsMasterforVendorDTO);
	}
	
	
	@PutMapping("softDeletePaymentTermsMaster/{id}")
	public void softDeletePaymentTermsMaster(@PathVariable("id") Integer id) {
		paymentTermsMasterService.softDeletePaymentTermsMaster(id);
	}
	
	@DeleteMapping("permDeletePaymentTermsMaster/{id}")
	public void permDeletePaymentTermsMaster(@PathVariable("id") Integer id) {
		paymentTermsMasterService.permDeletePaymentTermsMaster(id);
	}

}
