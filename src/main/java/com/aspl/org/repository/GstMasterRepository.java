package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.GstMaster;

@Repository
public interface GstMasterRepository extends JpaRepository<GstMaster, Integer> {

	List<GstMaster> findByGstType(String gstType);
	
}
