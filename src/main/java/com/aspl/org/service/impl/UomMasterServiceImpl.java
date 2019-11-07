package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.entity.UomMaster;
import com.aspl.org.repository.UomMasterRepo;
import com.aspl.org.service.UomMasterService;

/*
 * Service for UOM master CRUD operations
 */
@Service
@Transactional
public class UomMasterServiceImpl implements UomMasterService {

	@Autowired
	UomMasterRepo uomRepo;
	
	
	/*
	 * @Param uomId
	 * 
	 * Method for fetching UOM by id
	 * 
	 * @Return UomMasterDTO
	 */
	@Override
	public UomMaster getUomByUomId(Integer uomId) {
	
		UomMaster uomDTO = new UomMaster();
		try {
			uomDTO = uomRepo.findById(uomId).get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return uomDTO;
	}

	/*
	 * @Param uomCode
	 * 
	 * Method for getting UOM by uomCode
	 * 
	 * @Return UomMasterDTO
	 */
	@Override
	public UomMaster getUomByUomCode(String uomCode) {
		
		UomMaster uomDTO = new UomMaster();
		try {
			uomDTO = uomRepo.findByUomCode(uomCode);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return uomDTO;
	}

	/*
	 * @Param uomId
	 * 
	 * Method for soft delete UOM
	 * 
	 * @Return UomMasterDTO
	 */
	@Override
	public UomMaster softDeleteUom(Integer uomId) {
		// TODO Auto-generated method stub
		try {
			
		}catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public UomMaster saveUom(UomMaster uomMaster) {
		
		try {
			uomRepo.save(uomMaster);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return uomMaster;
	}

	/*
	 * @Param uomMaster
	 * 
	 * Method for update UOM
	 * 
	 * @Return UomMasterDTO
	 */
	@Override
	public UomMaster updateUomMaster(UomMaster uomMaster) {
		
		try {
			UomMaster uom = uomRepo.findById(uomMaster.getUomId()).get();
			
			if(uom!=null) {
				uomRepo.save(prepareUomMaster(uomMaster));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return uomMaster;
	}

	/*
	 * @Param uomMaster
	 * 
	 * Method for preparing DTO from UOM entity
	 * 
	 * @Return UomMasterDTO
	 */
	@Override
	public UomMaster prepareUomMasterDTO(UomMaster uomMaster) {
		
		UomMaster uomMasterDTO = new UomMaster();
		uomMasterDTO.setDecimalPlace(uomMaster.getDecimalPlace());
		uomMasterDTO.setIsActive(uomMaster.getIsActive());
		uomMasterDTO.setUomCode(uomMaster.getUomCode());
		uomMasterDTO.setUomDescription(uomMaster.getUomDescription());
		uomMasterDTO.setUomId(uomMaster.getUomId());
		return uomMasterDTO;
	}

	/*
	 * @Param uomMasterDTO
	 * 
	 * Method for preparing entity from DTO
	 * 
	 * @Retrun UomMaster
	 */
	@Override
	public UomMaster prepareUomMaster(UomMaster uomMasterDTO) {
		
		UomMaster uomMaster = new UomMaster();
		uomMaster.setDecimalPlace(uomMasterDTO.getDecimalPlace());
		uomMaster.setIsActive(1);
		uomMaster.setUomCode(uomMasterDTO.getUomCode());
		uomMaster.setUomDescription(uomMasterDTO.getUomDescription());
		uomMaster.setUomId(uomMasterDTO.getUomId());
		return uomMaster;
	}

	/*
	 * Method for getting all the UOM master
	 * 
	 * @Return List<UomMasterDTO>
	 */
	@Override
	public List<UomMaster> getAllUomMaster() {
		
		List<UomMaster> uoms = new ArrayList<>();
		try {
			uoms = uomRepo.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return uoms;
	}

	/*
	 * @Param uomId
	 * 
	 * Method for permanently delete UOM
	 * 
	 */
	@Override
	public void permDeleteUom(Integer uomId) {
		
		try {
			uomRepo.deleteById(uomId);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
