package com.aspl.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.PaymentMethodMasterforVendor;

@Repository

public interface PaymentMethodMasterDao extends JpaRepository<PaymentMethodMasterforVendor, Integer> {
	
	PaymentMethodMasterforVendor findByPaymentMethodCode(String paymentMethodCode);
	

}
