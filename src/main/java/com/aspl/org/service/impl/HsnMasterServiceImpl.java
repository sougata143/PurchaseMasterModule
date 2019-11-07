package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.HsnMasterDTO;

import com.aspl.org.entity.HsnMaster;

import com.aspl.org.repository.HsnMasterRepo;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.service.HsnMasterService;


/*
 * Service for HSN master CRUD operations
 */
@Service
public class HsnMasterServiceImpl implements HsnMasterService {

	@Autowired
	HsnMasterRepo hsnRepo;
	
	@Autowired
	ItemMasterDao itemDao;
	
	/*
	 * @Param hsnMaster
	 * 
	 * Method for converting DTO from Entity
	 * 
	 * @Return HsnMasterDTO
	 */
	@Override
	public HsnMasterDTO prepareHsnMasterDTOFromEntity(HsnMaster hsnMaster) {
		
		HsnMasterDTO hsnDTO = new HsnMasterDTO();
		hsnDTO.setChapter(hsnMaster.getChapter());
		hsnDTO.setHeading(hsnMaster.getHeading());
		hsnDTO.setHsnDescription(hsnMaster.getHsnDescription());
		hsnDTO.setHsnId(hsnMaster.getHsnId());
		hsnDTO.setIsActive(hsnMaster.getIsActive());
		
//		if(hsnMaster.getItemId()!=null) {
//			ItemMaster item = itemDao.findById(hsnMaster.getItemId()).get();
//			ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO(); 
//			itemDTO.setItemCode(item.getItemCode());
//			itemDTO.setItemId(item.getId());
//			itemDTO.setItemName(item.getItemName());
//			
//			hsnDTO.setItemDTO(itemDTO);
//		}
		
		hsnDTO.setSubHeading(hsnMaster.getSubHeading());
		return hsnDTO;
	}

	/*
	 * @Param hsnMasterDTO
	 * 
	 * Method for converting DTO to Entity
	 * 
	 * @Return HsnMaster
	 */
	@Override
	public HsnMaster prepareHsnMasterEntityFromDTO(HsnMasterDTO hsnMasterDTO) {
		
		HsnMaster hsnMaster = new HsnMaster();
		
		hsnMaster.setChapter(hsnMasterDTO.getChapter());
		hsnMaster.setHeading(hsnMasterDTO.getHeading());
		hsnMaster.setHsnDescription(hsnMasterDTO.getHsnDescription());
//		if(hsnMasterDTO.getItemDTO()!=null) {
//			if(hsnMasterDTO.getItemDTO().getItemId()!=null) {
//				hsnMaster.setItemId(hsnMasterDTO.getItemDTO().getItemId());
//			}
//		}
		hsnMaster.setSubHeading(hsnMasterDTO.getSubHeading());
		hsnMaster.setIsActive(1);
		
		return hsnMaster;
	}
	
	/*
	 * Method for fetching all HSN master
	 * 
	 * @Return List<HsnMasterDTO>
	 */
	@Override
	public List<HsnMasterDTO> getAllHsnMaster() {
		
		List<HsnMaster> hsnMasters = hsnRepo.findByIsActive(1);
		List<HsnMasterDTO> hsnDTOs = new ArrayList<>();
		for(HsnMaster hsn : hsnMasters) {
			HsnMasterDTO hsnDTO = new HsnMasterDTO();
			hsnDTO = prepareHsnMasterDTOFromEntity(hsn);
			hsnDTOs.add(hsnDTO);
		}
		return hsnDTOs;
	}

	/*
	 * @Param hsnId
	 * 
	 * Method for getting HSN master by hsnId
	 * 
	 * @Return HsnMasterDTO
	 */
	@Override
	public HsnMasterDTO getHsnMasterById(Integer hsnId) {
		
		HsnMaster hsn = hsnRepo.findById(hsnId).get();
		HsnMasterDTO hsnDTO = new HsnMasterDTO();
		hsnDTO = prepareHsnMasterDTOFromEntity(hsn);
		return hsnDTO;
	}

	/*
	 * @Param itemId
	 * 
	 * Method for getting HSN master by itemId
	 * 
	 * @Return HsnMasterDTO
	 */
	@Override
	public HsnMasterDTO getHsnMasterByItemId(Integer itemId) {
		
//		HsnMaster hsn = hsnRepo.findByItemId(itemId);
		HsnMasterDTO hsnDTO = new HsnMasterDTO();
//		hsnDTO = prepareHsnMasterDTOFromEntity(hsn);
		return hsnDTO;
	}

	/*
	 * @Param hsnMasterDTO
	 * 
	 * Method for saving HSN master
	 * 
	 * @Return HsnMasterDTO
	 */
	@Override
	public HsnMasterDTO saveHsnMaster(HsnMasterDTO hsnMasterDTO) {
		
		HsnMaster hsn = new HsnMaster();
		hsn = prepareHsnMasterEntityFromDTO(hsnMasterDTO);
		try {
			hsnRepo.save(hsn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return hsnMasterDTO;
	}

	/*
	 * @Param hsnMasterDTO
	 * 
	 * Method for updating HSN master
	 * 
	 * @Return HsnMasterDTO
	 */
	@Override
	public HsnMasterDTO updateHsnMaster(HsnMasterDTO hsnMasterDTO) {
		
		HsnMaster hsn = prepareHsnMasterEntityFromDTO(hsnMasterDTO);
		hsn.setHsnId(hsnMasterDTO.getHsnId());
		try {
			hsnRepo.save(hsn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return hsnMasterDTO;
	}

	/*
	 * @Param hsnId
	 * 
	 * Method for soft delete HSN master
	 * 
	 */
	@Override
	public void softDeleteHsnMaster(Integer hsnId) {
		
		HsnMaster hsn = hsnRepo.findById(hsnId).get();
		hsn.setIsActive(0);
		hsnRepo.save(hsn);
	}

	/*
	 * @Param hsnId
	 * 
	 * Method for permanent delete HSN master
	 * 
	 */
	@Override
	public void permDeleteHsnMaster(Integer hsnId) {
		// TODO Auto-generated method stub
		hsnRepo.deleteById(hsnId);
	}

	

}
