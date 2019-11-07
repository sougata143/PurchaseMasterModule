package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.aspl.org.dto.PaymentTermsMasterforVendorDTO;
import com.aspl.org.entity.PaymentTermsMasterforVendor;

@Service

public interface PaymentTermsMasterService {
    PaymentTermsMasterforVendor findByPaymentTermsCode(String paymentTermsCode);
	
    PaymentTermsMasterforVendor paymentTermsMasterSave(PaymentTermsMasterforVendor paymentTermsMasterforVendor);
		
	List<PaymentTermsMasterforVendor> getallpaymenttermslist();
	
	public PaymentTermsMasterforVendorDTO getPaymentTermsMasterById(Integer id);
	public PaymentTermsMasterforVendorDTO preparePaymentTermsMasterDTOFromEntity(PaymentTermsMasterforVendor paymentTermsMaster);
	
	public PaymentTermsMasterforVendorDTO updatePaymentTermsMaster(PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO);
	public void softDeletePaymentTermsMaster(Integer id);
	public void permDeletePaymentTermsMaster(Integer id);

	PaymentTermsMasterforVendor preparePaymentTermsMasterEntityFromDTO(PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO);


	

}
