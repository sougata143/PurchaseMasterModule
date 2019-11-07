package com.aspl.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.aspl.org.entity.JurisdictionMasterForVendor;

public interface JurisdictionMasterDao extends JpaRepository<JurisdictionMasterForVendor, Integer> {
	
	JurisdictionMasterForVendor findByJurisdictionCode(String jurisdictionCode); 

}
