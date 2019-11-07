package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.UomMaster;

@Repository
public interface UomMasterRepo extends JpaRepository<UomMaster, Integer> {

	List<UomMaster> findByIsActive(Integer isActive);
	UomMaster findByUomCode(String uomCode);
	Long countByIsActive(Integer isActive);
	
}
