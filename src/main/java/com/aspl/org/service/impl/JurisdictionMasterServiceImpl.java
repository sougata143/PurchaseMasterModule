package com.aspl.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.JurisdictionMasterForVendorDTO;
import com.aspl.org.entity.JurisdictionMasterForVendor;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.service.JurisdictionMasterService;

/*
 * Service for Jurisdiction Master of Vendor 
 */
@Service
@Transactional
public class JurisdictionMasterServiceImpl implements JurisdictionMasterService{
	
	@Autowired
	JurisdictionMasterDao jurisdictionMasterdao;
	
	/*
	 * @Param jurisdictionCode
	 * 
	 * Method to find jurisdiction master of vendor by jurisdiction code
	 * 
	 * @Return jurisdictionMaster
	 * 
	 */

	@Override
	public JurisdictionMasterForVendor findByJurisdictionCode(String jurisdictionCode) {
		
		JurisdictionMasterForVendor jurisdictionMaster=jurisdictionMasterdao.findByJurisdictionCode(jurisdictionCode);
		  return jurisdictionMaster;
	}
	
	/*
	   * @Param jurisdictionMasterforVendor
	   * 
	   * Method for saving jurisdiction master for vendor
	   * 
	   * @Return jurisdictionMasterforVendor
	   */
	
	@Override
	public JurisdictionMasterForVendor jurisdictionMasterSave(JurisdictionMasterForVendor jurisdictionMasterforVendor) {
	
		return jurisdictionMasterdao.save(jurisdictionMasterforVendor);
	}

	/*
	 * Method for getting all jurisdiction master list
	 * 
	 * 
	 */

	

	@Override
	public List<JurisdictionMasterForVendor> getalljurisdictionlist() {
		return jurisdictionMasterdao.findAll();
	}
	
	/*
	 *@Param jurisdictionMasterforVendorDTO
	 *
	 * Method for updating jurisdiction master for vendor
	 * 
	 * @Return jurisdictionMasterforVendorDTO
	 */

	@Override
	public JurisdictionMasterForVendorDTO updateJurisdictionMaster(
			JurisdictionMasterForVendorDTO jurisdictionMasterforVendorDTO) {
		JurisdictionMasterForVendor jurisdictionMaster = prepareJurisdictionMasterEntityFromDTO(jurisdictionMasterforVendorDTO);
		jurisdictionMaster.setId(jurisdictionMasterforVendorDTO.getId());
		try {
			jurisdictionMasterdao.save(jurisdictionMaster);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jurisdictionMasterforVendorDTO;
	}
	
	/*
	 * @Param id
	 * 
	 * Method for soft delete jurisdiction master
	 * 
	 * @Return jurisdictionMaster
	 * 
	 */

	

	@Override
	public void softDeleteJurisdictionMaster(Integer id) {
		JurisdictionMasterForVendor jurisdictionMaster = jurisdictionMasterdao.findById(id).get();
		jurisdictionMaster.setIsActive(0);
		jurisdictionMasterdao.save(jurisdictionMaster);
		
	}

	@Override
	public void permDeleteJurisdictionMaster(Integer id) {
		jurisdictionMasterdao.deleteById(id);
		
	}
	
	/*
	 * @Param jurisdictionMasterforVendorDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return jurisdictionMaster 
	 */

	@Override
	public JurisdictionMasterForVendor prepareJurisdictionMasterEntityFromDTO(
			JurisdictionMasterForVendorDTO jurisdictionMasterforVendorDTO) {
		
		JurisdictionMasterForVendor jurisdictionMaster = new JurisdictionMasterForVendor();
		
		jurisdictionMaster.setDescription(jurisdictionMasterforVendorDTO.getDescription());
			if(jurisdictionMasterforVendorDTO.getVendorDTO()!=null) {
				//if(paymentMethodMasterforVendorDTO.getVendorDTO().getId()!=null) {
				jurisdictionMaster.setId(jurisdictionMasterforVendorDTO.getVendorDTO().getId());
				}
			
			jurisdictionMaster.setJurisdictionCode(jurisdictionMasterforVendorDTO.getJurisdictionCode());
			jurisdictionMaster.setIsActive(1);
			
			
			return jurisdictionMaster;
		}
	
	/*
	 * @Param id
	 * 
	 * Method to get details of jurisdiction master of vendor by id
	 * 
	 * @Return jmDTO
	 * 
	 */

	@Override
	public JurisdictionMasterForVendorDTO getJurisdictionMasterById(Integer id) {
		JurisdictionMasterForVendor jm = jurisdictionMasterdao.findById(id).get();
		JurisdictionMasterForVendorDTO jmDTO = new JurisdictionMasterForVendorDTO();
		jmDTO = prepareJurisdictionMasterDTOFromEntity(jm);
		return jmDTO;
	}
	
	/*
	 * @Param jurisdictionMaster
	 * 
	 * Method for creating jurisdictionMaster DTO from jurisdictionMaster entity
	 * 
	 * @Return @jmDTO
	 */

	@Override
	public JurisdictionMasterForVendorDTO prepareJurisdictionMasterDTOFromEntity(
			JurisdictionMasterForVendor jurisdictionMaster) {
		JurisdictionMasterForVendorDTO jmDTO = new JurisdictionMasterForVendorDTO();
		jmDTO.setJurisdictionCode(jurisdictionMaster.getJurisdictionCode());
		jmDTO.setDescription(jurisdictionMaster.getDescription());
		jmDTO.setId(jurisdictionMaster.getId());
		jmDTO.setIsActive(jurisdictionMaster.getIsActive());
		
	
		return jmDTO;
	
	}
	}



	


