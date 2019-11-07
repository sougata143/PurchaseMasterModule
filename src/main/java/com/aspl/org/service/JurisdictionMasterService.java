package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.aspl.org.dto.JurisdictionMasterForVendorDTO;
import com.aspl.org.entity.JurisdictionMasterForVendor;


@Service
public interface JurisdictionMasterService {
	
	JurisdictionMasterForVendor findByJurisdictionCode(String jurisdictionCode);
	
	JurisdictionMasterForVendor jurisdictionMasterSave(JurisdictionMasterForVendor jurisdictionMasterforVendor);
		
	List<JurisdictionMasterForVendor> getalljurisdictionlist();
	
	public JurisdictionMasterForVendorDTO getJurisdictionMasterById(Integer id);
	public JurisdictionMasterForVendorDTO prepareJurisdictionMasterDTOFromEntity(JurisdictionMasterForVendor jurisdictionMaster);
	
	public JurisdictionMasterForVendorDTO updateJurisdictionMaster(JurisdictionMasterForVendorDTO jurisdictionMasterforVendorDTO);
	public void softDeleteJurisdictionMaster(Integer id);
	public void permDeleteJurisdictionMaster(Integer id);

	JurisdictionMasterForVendor prepareJurisdictionMasterEntityFromDTO(JurisdictionMasterForVendorDTO jurisdictionMasterforVendorDTO);
	

}
