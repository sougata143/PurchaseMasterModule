package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.aspl.org.dto.ShippingMethodMasterforVendorDTO;
import com.aspl.org.entity.ShippingMethodMasterforVendor;



@Service
public interface ShippingMethodMasterService {
	
    ShippingMethodMasterforVendor findByShippingMethodCode(String shippingMethodCode);
	
    ShippingMethodMasterforVendor shippingMethodMasterSave(ShippingMethodMasterforVendor shippingMethodMasterforVendor);
		
	List<ShippingMethodMasterforVendor> getallshippingmethodlist();
	
	public ShippingMethodMasterforVendorDTO getShippingMethodMasterById(Integer id);
	public ShippingMethodMasterforVendorDTO prepareShippingMethodMasterDTOFromEntity(ShippingMethodMasterforVendor shippingMethodMaster);
	
	
	public ShippingMethodMasterforVendorDTO updateShippingMethodMaster(ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO);
	public void softDeleteShippingMethodMaster(Integer id);
	public void permDeleteShippingMethodMaster(Integer id);

	ShippingMethodMasterforVendor prepareShippingMethodMasterEntityFromDTO(ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO);


}
