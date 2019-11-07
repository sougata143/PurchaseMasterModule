package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aspl.org.dto.DeliveryTermsMasterforVendorDTO;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;



@Service
public interface DeliveryTermsMasterService {
	
	DeliveryTermsMasterforVendor findByDeliveryTermsCode(String deliveryTermsCode);
	
   DeliveryTermsMasterforVendor deliveryTermsMasterSave(DeliveryTermsMasterforVendor deliveryTermsMasterforVendor);
	
	List<DeliveryTermsMasterforVendor> getalldeliverytermslist();
	
	public DeliveryTermsMasterforVendorDTO getDeliveryTermsMasterById(Integer id);
	public DeliveryTermsMasterforVendorDTO prepareDeliveryTermsMasterDTOFromEntity(DeliveryTermsMasterforVendor deliveryTermsMaster);
	
	public DeliveryTermsMasterforVendorDTO updateDeliveryTermsMaster(DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO);
	public void softDeleteDeliveryTermsMaster(Integer id);
	public void permDeleteDeliveryTermsMaster(Integer id);

	DeliveryTermsMasterforVendor prepareDeliveryTermsMasterEntityFromDTO(DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO);


	
}
