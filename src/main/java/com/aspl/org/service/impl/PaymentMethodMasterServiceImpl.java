package com.aspl.org.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.aspl.org.dto.PaymentMethodMasterforVendorDTO;
import com.aspl.org.entity.PaymentMethodMasterforVendor;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.service.PaymentMethodMasterService;

/*
 * Service for PaymentMethod Master for Vendor 
 */
@Service
@Transactional

public class PaymentMethodMasterServiceImpl implements PaymentMethodMasterService {
	@Autowired
	PaymentMethodMasterDao paymentMethodMasterDao;
	
	/*
	 * @Param paymentMethodCode
	 * 
	 * Method to find paymentMethodMaster for vendor by paymentMethodCode code
	 * 
	 * @Return paymentMethodMaster
	 * 
	 */

	@Override
	public PaymentMethodMasterforVendor findByPaymentMethodCode(String paymentMethodCode) {
		
		PaymentMethodMasterforVendor paymentMethodMaster=paymentMethodMasterDao.findByPaymentMethodCode(paymentMethodCode);
		  return paymentMethodMaster;
	}
	

	/*
	   * @Param paymentMethodMasterforVendor
	   * 
	   * Method for saving payment method master for vendor
	   * 
	   * @Return paymentMethodMasterforVendor
	   */


	@Override
	public PaymentMethodMasterforVendor paymentMethodMasterSave(
			PaymentMethodMasterforVendor paymentMethodMasterforVendor) {
		return paymentMethodMasterDao.save(paymentMethodMasterforVendor);
	}
	
	/*
	 * Method for getting all payment Method master list
	 * 
	 * 
	 */


	@Override
	public List<PaymentMethodMasterforVendor> getallpaymentmethodlist() {
		return paymentMethodMasterDao.findAll();
	}
	
	/*
	 * @Param paymentMethodMasterforVendorDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return paymentMethodMaster 
	 */
	
	@Override
	public PaymentMethodMasterforVendor preparePaymentMethodMasterEntityFromDTO(PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO) {
	
		PaymentMethodMasterforVendor pmMaster = new PaymentMethodMasterforVendor();
		
		pmMaster.setDescription(paymentMethodMasterforVendorDTO.getDescription());
		if(paymentMethodMasterforVendorDTO.getVendorDTO()!=null) {
			//if(paymentMethodMasterforVendorDTO.getVendorDTO().getId()!=null) {
				pmMaster.setId(paymentMethodMasterforVendorDTO.getVendorDTO().getId());
			}
		
	pmMaster.setPaymentMethodCode(paymentMethodMasterforVendorDTO.getPaymentMethodCode());
	pmMaster.setIsActive(1);
		
		return pmMaster;
	}
	
	/*
	 *@Param paymentMethodMasterforVendorDTO
	 *
	 * Method for updating paymentMethod master for vendor
	 * 
	 * @Return paymentMethodMasterforVendorDTO
	 */

	@Override
	public PaymentMethodMasterforVendorDTO updatePaymentMethodMaster(
			PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO) {
		PaymentMethodMasterforVendor pmm = preparePaymentMethodMasterEntityFromDTO(paymentMethodMasterforVendorDTO);
		pmm.setId(paymentMethodMasterforVendorDTO.getId());
		try {
			paymentMethodMasterDao.save(pmm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return paymentMethodMasterforVendorDTO;
	}
	
	/*
	 * @Param id
	 * 
	 * Method for soft delete paymentMethod master
	 * 
	 * @Return paymentMethodMaster
	 * 
	 */

	@Override
	public void softDeletePaymentMethodMaster(Integer id) {
		PaymentMethodMasterforVendor pmm = paymentMethodMasterDao.findById(id).get();
		pmm.setIsActive(0);
		paymentMethodMasterDao.save(pmm);
	}

	@Override
	public void permDeletePaymentMethodMaster(Integer id) {
	 
		paymentMethodMasterDao.deleteById(id);
	}
	
	
	/*
	 * @Param id
	 * 
	 * Method to get details of payment method master of vendor by id
	 * 
	 * @Return pmmDTO
	 * 
	 */

	@Override
	public PaymentMethodMasterforVendorDTO getPaymentMethodMasterById(Integer id) {
		PaymentMethodMasterforVendor pmm = paymentMethodMasterDao.findById(id).get();
		PaymentMethodMasterforVendorDTO pmmDTO = new PaymentMethodMasterforVendorDTO();
		pmmDTO = preparePaymentMethodMasterDTOFromEntity(pmm);
		return pmmDTO;
	}
	
	
	/*
	 * @Param paymentMethodMaster
	 * 
	 * Method for creating paymentMethodMaster DTO from paymentMethodMaster entity
	 * 
	 * @Return @pmmDTO
	 */

	@Override
	public PaymentMethodMasterforVendorDTO preparePaymentMethodMasterDTOFromEntity(
			PaymentMethodMasterforVendor paymentMethodMaster) {
		    //if(deliveryTermsMaster.getVendorid() != 0) {
		    PaymentMethodMasterforVendorDTO pmmDTO = new PaymentMethodMasterforVendorDTO();
		    pmmDTO.setPaymentMethodCode(paymentMethodMaster.getPaymentMethodCode());
		    pmmDTO.setDescription(paymentMethodMaster.getDescription());
		    pmmDTO.setId(paymentMethodMaster.getId());
		    pmmDTO.setIsActive(paymentMethodMaster.getIsActive());
			
		    
		
			return pmmDTO;
	}

}
