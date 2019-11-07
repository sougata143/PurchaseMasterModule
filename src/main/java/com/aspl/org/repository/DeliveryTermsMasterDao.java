package com.aspl.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.DeliveryTermsMasterforVendor;
@Repository
public interface DeliveryTermsMasterDao extends JpaRepository<DeliveryTermsMasterforVendor, Integer> {
	
	DeliveryTermsMasterforVendor findByDeliveryTermsCode(String deliveryTermsCode);
	
	//DeliveryTermsMasterforVendor findByDescription(String description);

}
