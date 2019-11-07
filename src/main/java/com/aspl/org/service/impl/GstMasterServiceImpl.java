package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.GstMasterDTO;
import com.aspl.org.entity.GstMaster;
import com.aspl.org.repository.GstMasterRepository;
import com.aspl.org.service.GstMasterService;


@Service
@Transactional
public class GstMasterServiceImpl implements GstMasterService {

	@Autowired
	GstMasterRepository gstRepo;
	
	@Override
	public List<GstMasterDTO> getAllGstByGstType(String gstType) {
		
		List<GstMasterDTO> gstDTOs = new ArrayList<>();
		try {
			List<GstMaster> gstEntity = gstRepo.findByGstType(gstType);
			for(GstMaster gst : gstEntity) {
				GstMasterDTO gstDTO = new GstMasterDTO();
				gstDTO.setGstId(gst.getGstId());
				gstDTO.setGstType(gst.getGstType());
				gstDTO.setGstValue(gst.getGstValue());
				gstDTOs.add(gstDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return gstDTOs;
	}

}
