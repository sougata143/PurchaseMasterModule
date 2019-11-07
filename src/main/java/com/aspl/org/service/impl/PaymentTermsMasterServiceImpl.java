package com.aspl.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.aspl.org.dto.PaymentTermsMasterforVendorDTO;
import com.aspl.org.entity.PaymentTermsMasterforVendor;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.service.PaymentTermsMasterService;


/*
 * Service for Payment Terms Master of Vendor 
 */
@Service
@Transactional

public class PaymentTermsMasterServiceImpl implements PaymentTermsMasterService{
	
	@Autowired
	PaymentTermsMasterDao paymentTermsMasterDao;
	
	/*
	 * @Param paymentTermsCode
	 * 
	 * Method to find paymentTerms master by paymentTermsCode
	 * 
	 * @Return paymentMethodMaster
	 * 
	 */

	@Override
	public PaymentTermsMasterforVendor findByPaymentTermsCode(String paymentTermsCode) {
		
		PaymentTermsMasterforVendor paymentTermsMaster=paymentTermsMasterDao.findByPaymentTermsCode(paymentTermsCode);
		  return paymentTermsMaster;
	}
	
	/*
	   * @Param paymentTermsMasterforVendor
	   * 
	   * Method for saving paymentterms master for vendor
	   * 
	   * @Return paymentTermsMasterforVendor
	   */

	@Override
	public PaymentTermsMasterforVendor paymentTermsMasterSave(PaymentTermsMasterforVendor paymentTermsMasterforVendor) {
		return paymentTermsMasterDao.save(paymentTermsMasterforVendor);
	}
	
	/*
	 * Method for getting all paymentterms master list
	 * 
	 * 
	 */

	@Override
	public List<PaymentTermsMasterforVendor> getallpaymenttermslist() {
		return paymentTermsMasterDao.findAll();
	}
	
	/*
	 *@Param paymentTermsMasterforVendorDTO
	 *
	 * Method for updating payment terms master for vendor
	 * 
	 * @Return paymentTermsMasterforVendorDTO
	 */

	@Override
	public PaymentTermsMasterforVendorDTO updatePaymentTermsMaster(
			PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO) {
		
		PaymentTermsMasterforVendor ptm = preparePaymentTermsMasterEntityFromDTO(paymentTermsMasterforVendorDTO);
		ptm.setId(paymentTermsMasterforVendorDTO.getId());
		try {
			paymentTermsMasterDao.save(ptm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return paymentTermsMasterforVendorDTO;
	}
	
	/*
	 * @Param id
	 * 
	 * Method for soft delete paymentterms master of vendor
	 * 
	 * @Return paymenttermsMaster
	 * 
	 */


	@Override
	public void softDeletePaymentTermsMaster(Integer id) {
		PaymentTermsMasterforVendor pmm = paymentTermsMasterDao.findById(id).get();
		pmm.setIsActive(0);
		paymentTermsMasterDao.save(pmm);
	}

	@Override
	public void permDeletePaymentTermsMaster(Integer id) {
		paymentTermsMasterDao.deleteById(id);
		
	}
	
	/*
	 * @Param paymentTermsMasterforVendorDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return ptMaster 
	 */


	@Override
	public PaymentTermsMasterforVendor preparePaymentTermsMasterEntityFromDTO(PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO)
	{
			PaymentTermsMasterforVendor ptMaster = new PaymentTermsMasterforVendor();
			
			ptMaster.setDescription(paymentTermsMasterforVendorDTO.getDescription());
			if(paymentTermsMasterforVendorDTO.getVendorDTO()!=null) {
				//if(paymentMethodMasterforVendorDTO.getVendorDTO().getId()!=null) {
				ptMaster.setId(paymentTermsMasterforVendorDTO.getVendorDTO().getId());
				}
			
			ptMaster.setPaymentTermsCode(paymentTermsMasterforVendorDTO.getPaymentTermsCode());
			ptMaster.setDays(paymentTermsMasterforVendorDTO.getDays());
			ptMaster.setDisc_amt(paymentTermsMasterforVendorDTO.getDisc_amt());
			ptMaster.setIsActive(1);
			
			return ptMaster;
	}
	
	/*
	 * @Param id
	 * 
	 * Method to get details of payment terms master of vendor by id
	 * 
	 * @Return ptmDTO
	 * 
	 */

	@Override
	public PaymentTermsMasterforVendorDTO getPaymentTermsMasterById(Integer id) {
		PaymentTermsMasterforVendor ptm = paymentTermsMasterDao.findById(id).get();
	     PaymentTermsMasterforVendorDTO ptmDTO = new PaymentTermsMasterforVendorDTO();
	     ptmDTO = preparePaymentTermsMasterDTOFromEntity(ptm);
		return ptmDTO;
	}
	
	/*
	 * @Param paymentTermsMaster
	 * 
	 * Method for creating PaymentTermsMaster DTO from PaymentTermsMaster entity
	 * 
	 * @Return @ptmDTO
	 */

	@Override
	public PaymentTermsMasterforVendorDTO preparePaymentTermsMasterDTOFromEntity(
			PaymentTermsMasterforVendor paymentTermsMaster) {
		PaymentTermsMasterforVendorDTO ptmDTO = new PaymentTermsMasterforVendorDTO();
		ptmDTO.setPaymentTermsCode(paymentTermsMaster.getPaymentTermsCode());
		ptmDTO.setDays(paymentTermsMaster.getDays());
		ptmDTO.setId(paymentTermsMaster.getId());
		ptmDTO.setIsActive(paymentTermsMaster.getIsActive());
		ptmDTO.setDescription(paymentTermsMaster.getDescription());
		ptmDTO.setDisc_amt(paymentTermsMaster.getDisc_amt());

	
		return ptmDTO;
	}

}
