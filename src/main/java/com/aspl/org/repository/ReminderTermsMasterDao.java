package com.aspl.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.ReminderTermsMasterForVendor;
@Repository
public interface ReminderTermsMasterDao extends JpaRepository<ReminderTermsMasterForVendor, Integer>{
	
	ReminderTermsMasterForVendor findByReminderTermsCode(String reminderTermsCode);
	

}
