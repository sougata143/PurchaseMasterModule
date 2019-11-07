package com.aspl.org.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reminder_terms")
public class ReminderTermsMasterForVendor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String reminderTermsCode;
	private String description;
	private Integer maxReminder;
	private Integer isActive;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getReminderTermsCode() {
		return reminderTermsCode;
	}


	public void setReminderTermsCode(String reminderTermsCode) {
		this.reminderTermsCode = reminderTermsCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getMaxReminder() {
		return maxReminder;
	}


	public void setMaxReminder(Integer maxReminder) {
		this.maxReminder = maxReminder;
	}


	public Integer getIsActive() {
		return isActive;
	}


	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}


	
}
