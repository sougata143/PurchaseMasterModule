package com.aspl.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.DeliveryTermsMasterforVendorDTO;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.service.DeliveryTermsMasterService;


/*
 * Service for Delivery Terms Master of Vendor 
 */
@Service
@Transactional
public class DeliveryTermsMasterServiceImpl implements DeliveryTermsMasterService {
	
	@Autowired
	DeliveryTermsMasterDao deliveryTermsMasterDao;
	

	/*
	 * @Param deliveryTermsCode
	 * 
	 * Method for delivery terms master by delivery terms code
	 * 
	 * @Return deliveryTermsMaster
	 * 
	 */

	@Override
	public DeliveryTermsMasterforVendor findByDeliveryTermsCode(String deliveryTermsCode) {
		
		DeliveryTermsMasterforVendor deliveryTermsMaster=deliveryTermsMasterDao.findByDeliveryTermsCode(deliveryTermsCode);
		  return deliveryTermsMaster;
	}
	
	/*
	   * @Param deliveryTermsMasterforVendor
	   * 
	   * Method for saving delivery terms master
	   * 
	   * @Return deliveryTermsMasterforVendor
	   */


	@Override
	public DeliveryTermsMasterforVendor deliveryTermsMasterSave(DeliveryTermsMasterforVendor deliveryTermsMasterforVendor) {
		return deliveryTermsMasterDao.save(deliveryTermsMasterforVendor);
	}
	
	/*
	 * Method for getting all delivery terms master list
	 * 
	 * 
	 */

	@Override
	public List<DeliveryTermsMasterforVendor> getalldeliverytermslist() {
		return deliveryTermsMasterDao.findAll();
	}
	
	/*
	 *@Param deliveryTermsMasterforVendorDTO
	 *
	 * Method for updating delivery terms master
	 * 
	 * @Return deliveryTermsMasterforVendorDTO
	 */

	@Override
	public DeliveryTermsMasterforVendorDTO updateDeliveryTermsMaster(
			DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO) {
		DeliveryTermsMasterforVendor dtm = prepareDeliveryTermsMasterEntityFromDTO(deliveryTermsMasterforVendorDTO);
		dtm.setId(deliveryTermsMasterforVendorDTO.getId());
		try {
			deliveryTermsMasterDao.save(dtm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deliveryTermsMasterforVendorDTO;
	}
	
	/*
	 * @Param id
	 * 
	 * Method for soft delete delivery terms master
	 * 
	 * @Return dtm
	 * 
	 */

	@Override
	public void softDeleteDeliveryTermsMaster(Integer id) {
		DeliveryTermsMasterforVendor dtm = deliveryTermsMasterDao.findById(id).get();
		dtm.setIsActive(0);
		deliveryTermsMasterDao.save(dtm);
		
	}

	@Override
	public void permDeleteDeliveryTermsMaster(Integer id) {
		deliveryTermsMasterDao.deleteById(id);
	}
	
	/*
	 * @Param deliveryTermsMasterforVendorDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return dtMaster 
	 */
 
	public DeliveryTermsMasterforVendor prepareDeliveryTermsMasterEntityFromDTO(
			DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO) {
    DeliveryTermsMasterforVendor dtMaster = new DeliveryTermsMasterforVendor();
		
    dtMaster.setDescription(deliveryTermsMasterforVendorDTO.getDescription());
		if(deliveryTermsMasterforVendorDTO.getVendorDTO()!=null) {
			//if(paymentMethodMasterforVendorDTO.getVendorDTO().getId()!=null) {
			dtMaster.setId(deliveryTermsMasterforVendorDTO.getVendorDTO().getId());
			}
		
		dtMaster.setDeliveryTermsCode(deliveryTermsMasterforVendorDTO.getDeliveryTermsCode());
		dtMaster.setIsActive(1);
		
		return dtMaster;
	}
	
	/*
	 * @Param id
	 * 
	 * Method to get details of delivery terms master of vendor by id
	 * 
	 * @Return DeliveryTermsMasterforVendorDTO
	 * 
	 */

	@Override
	public DeliveryTermsMasterforVendorDTO getDeliveryTermsMasterById(Integer id) {
		DeliveryTermsMasterforVendor dtm = deliveryTermsMasterDao.findById(id).get();
	     DeliveryTermsMasterforVendorDTO dtmDTO = new DeliveryTermsMasterforVendorDTO();
	     dtmDTO = prepareDeliveryTermsMasterDTOFromEntity(dtm);
		return dtmDTO;
	}
	

	/*
	 * @Param deliveryTermsMaster
	 * 
	 * Method for creating delivery Terms master DTO from deliveryTermsMaster entity
	 * 
	 * @Return @dtmDTO
	 */


	@Override
	public DeliveryTermsMasterforVendorDTO prepareDeliveryTermsMasterDTOFromEntity(
			DeliveryTermsMasterforVendor deliveryTermsMaster) {
	    //if(deliveryTermsMaster.getVendorid() != 0) {
		DeliveryTermsMasterforVendorDTO dtmDTO = new DeliveryTermsMasterforVendorDTO();
		dtmDTO.setDeliveryTermsCode(deliveryTermsMaster.getDeliveryTermsCode());
		dtmDTO.setDescription(deliveryTermsMaster.getDescription());
		dtmDTO.setId(deliveryTermsMaster.getId());
		dtmDTO.setIsActive(deliveryTermsMaster.getIsActive());
		
	
		return dtmDTO;
	

}
}
