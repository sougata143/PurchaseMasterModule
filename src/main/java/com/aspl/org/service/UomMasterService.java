package com.aspl.org.service;

import java.util.List;

import com.aspl.org.entity.UomMaster;

public interface UomMasterService {

	public List<UomMaster> getAllUomMaster();
	public UomMaster getUomByUomId(Integer uomId);
	public UomMaster getUomByUomCode(String uomCode);
	public void permDeleteUom(Integer uomId);
	public UomMaster softDeleteUom(Integer uomId);
	public UomMaster saveUom(UomMaster uomMaster);
	public UomMaster updateUomMaster(UomMaster uomMaster);
	
	UomMaster prepareUomMasterDTO(UomMaster uomMaster);
	UomMaster prepareUomMaster(UomMaster uomMasterDTO);
	
}
