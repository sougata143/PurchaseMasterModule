package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.GstMasterDTO;

public interface GstMasterService {

	public List<GstMasterDTO> getAllGstByGstType(String gstType);
	
}
