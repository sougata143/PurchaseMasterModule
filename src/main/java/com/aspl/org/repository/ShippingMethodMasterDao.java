package com.aspl.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.ShippingMethodMasterforVendor;

@Repository
public interface ShippingMethodMasterDao extends JpaRepository<ShippingMethodMasterforVendor, Integer>{
	
	ShippingMethodMasterforVendor findByShippingMethodCode(String ShippingMethodCode);
	
	

}
