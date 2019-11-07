package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.HsnMaster;

@Repository
public interface HsnMasterRepo extends JpaRepository<HsnMaster, Integer> {

	List<HsnMaster> findByIsActive(Integer isActive);
	
	
}
