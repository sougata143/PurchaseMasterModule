package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.aspl.org.dto.PaymentMethodMasterforVendorDTO;
import com.aspl.org.entity.PaymentMethodMasterforVendor;

@Service

public interface PaymentMethodMasterService {
	
	PaymentMethodMasterforVendor findByPaymentMethodCode(String paymentMethodCode);
	
	PaymentMethodMasterforVendor paymentMethodMasterSave(PaymentMethodMasterforVendor paymentMethodMasterforVendor);
		
	List<PaymentMethodMasterforVendor> getallpaymentmethodlist();
	
	public PaymentMethodMasterforVendorDTO getPaymentMethodMasterById(Integer id);
	public PaymentMethodMasterforVendorDTO preparePaymentMethodMasterDTOFromEntity(PaymentMethodMasterforVendor paymentMethodMaster);
	
	public PaymentMethodMasterforVendorDTO updatePaymentMethodMaster(PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO);
	public void softDeletePaymentMethodMaster(Integer id);
	public void permDeletePaymentMethodMaster(Integer id);

	PaymentMethodMasterforVendor preparePaymentMethodMasterEntityFromDTO(PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO);

}
