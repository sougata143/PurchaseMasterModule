package com.aspl.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.aspl.org.dto.ShippingMethodMasterforVendorDTO;
import com.aspl.org.entity.ShippingMethodMasterforVendor;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.service.ShippingMethodMasterService;


/*
 * Service for Shipping Method Terms Master of Vendor 
 */
@Service
@Transactional

public class ShippingMethodMasterServiceImpl implements ShippingMethodMasterService {
	
	@Autowired
	ShippingMethodMasterDao shippingMethodMasterDao;
	
	/*
	 * @Param shippingMethodCode
	 * 
	 * Method to find Shipping Method master by shippingMethodCode
	 * 
	 * @Return shippingMethodMaster
	 * 
	 */

	@Override
	public ShippingMethodMasterforVendor findByShippingMethodCode(String shippingMethodCode) {
		
		ShippingMethodMasterforVendor shippingMethodMaster=shippingMethodMasterDao.findByShippingMethodCode(shippingMethodCode);
		  return shippingMethodMaster;
	}
	
	/*
	   * @Param shippingMethodMasterforVendor
	   * 
	   * Method for saving shipping method master for vendor
	   * 
	   * @Return shippingMethodMasterforVendor
	   */

	@Override
	public ShippingMethodMasterforVendor shippingMethodMasterSave(
			ShippingMethodMasterforVendor shippingMethodMasterforVendor) {
		return shippingMethodMasterDao.save(shippingMethodMasterforVendor);
	}
	

	/*
	 * Method for getting all shipping method master list
	 * 
	 * 
	 */

	@Override
	public List<ShippingMethodMasterforVendor> getallshippingmethodlist() {
		return shippingMethodMasterDao.findAll();
	}
	
	/*
	 *@Param shippingMethodMasterforVendorDTO
	 *
	 * Method for updating shipping method master for vendor
	 * 
	 * @Return shippingMethodMasterforVendorDTO
	 */

	@Override
	public ShippingMethodMasterforVendorDTO updateShippingMethodMaster(
			ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO) {
		ShippingMethodMasterforVendor smm = prepareShippingMethodMasterEntityFromDTO(shippingMethodMasterforVendorDTO);
		smm.setId(shippingMethodMasterforVendorDTO.getId());
		try {
			shippingMethodMasterDao.save(smm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return shippingMethodMasterforVendorDTO;
	}
	
	/*
	 * @Param id
	 * 
	 * Method for soft delete shipping method master of vendor
	 * 
	 * @Return smm
	 * 
	 */

	@Override
	public void softDeleteShippingMethodMaster(Integer id) {
		ShippingMethodMasterforVendor smm = shippingMethodMasterDao.findById(id).get();
		smm.setIsActive(0);
		shippingMethodMasterDao.save(smm);
	}

	@Override
	public void permDeleteShippingMethodMaster(Integer id) {
		shippingMethodMasterDao.deleteById(id);
		
	}
	
	/*
	 * @Param shippingMethodMasterforVendorDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return smm 
	 */
	

	@Override
	public ShippingMethodMasterforVendor prepareShippingMethodMasterEntityFromDTO(
			ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO) {
		
     ShippingMethodMasterforVendor smm = new ShippingMethodMasterforVendor();
		
     smm.setDescription(shippingMethodMasterforVendorDTO.getDescription());
		if(shippingMethodMasterforVendorDTO.getVendorDTO()!=null) {
			//if(paymentMethodMasterforVendorDTO.getVendorDTO().getId()!=null) {
			smm.setId(shippingMethodMasterforVendorDTO.getVendorDTO().getId());
			}
		
		smm.setShippingMethodCode(shippingMethodMasterforVendorDTO.getShippingMethodCode());
		smm.setIsActive(1);
		
		return smm;
	}

	/*
	 * @Param id
	 * 
	 * Method to get details of shipping method master of vendor by id
	 * 
	 * @Return rtmDTO
	 * 
	 */
	@Override
	public ShippingMethodMasterforVendorDTO getShippingMethodMasterById(Integer id) {
		ShippingMethodMasterforVendor smm = shippingMethodMasterDao.findById(id).get();
		ShippingMethodMasterforVendorDTO smmDTO = new ShippingMethodMasterforVendorDTO();
		smmDTO = prepareShippingMethodMasterDTOFromEntity(smm);
		return smmDTO;
	}
	
	/*
	 * @Param shippingMethodMaster
	 * 
	 * Method for creating ShippingMethodMaster DTO from ShippingMethodMaster entity
	 * 
	 * @Return @smmDTO
	 */


	@Override
	public ShippingMethodMasterforVendorDTO prepareShippingMethodMasterDTOFromEntity(
			ShippingMethodMasterforVendor shippingMethodMaster  ) {
		ShippingMethodMasterforVendorDTO smmDTO = new ShippingMethodMasterforVendorDTO();
		smmDTO.setShippingMethodCode(shippingMethodMaster.getShippingMethodCode());
		smmDTO.setDescription(shippingMethodMaster.getDescription());
		smmDTO.setId(shippingMethodMaster.getId());
		smmDTO.setIsActive(shippingMethodMaster.getIsActive());
		
		

		return smmDTO;
	}
	

}
