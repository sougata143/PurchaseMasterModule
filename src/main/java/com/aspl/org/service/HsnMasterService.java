package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.HsnMasterDTO;
import com.aspl.org.entity.HsnMaster;

public interface HsnMasterService {

	public List<HsnMasterDTO> getAllHsnMaster();
	public HsnMasterDTO getHsnMasterById(Integer hsnId);
	public HsnMasterDTO getHsnMasterByItemId(Integer itemId);
	public HsnMasterDTO saveHsnMaster(HsnMasterDTO hsnMasterDTO);
	public HsnMasterDTO updateHsnMaster(HsnMasterDTO hsnMasterDTO);
	public void softDeleteHsnMaster(Integer hsnId);
	public void permDeleteHsnMaster(Integer hsnId);
	public HsnMasterDTO prepareHsnMasterDTOFromEntity(HsnMaster hsnMaster);
	public HsnMaster prepareHsnMasterEntityFromDTO(HsnMasterDTO hsnMaster);
	
}
