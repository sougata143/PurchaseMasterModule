package com.aspl.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.PaymentTermsMasterforVendor;

@Repository

public interface PaymentTermsMasterDao extends JpaRepository<PaymentTermsMasterforVendor, Integer>{
	
	
	PaymentTermsMasterforVendor findByPaymentTermsCode(String paymentTermsCode);
	

}
