package com.aspl.org.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_terms")
public class PaymentTermsMasterforVendor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String paymentTermsCode;
	private String description;
	private Integer days;
	private Double disc_amt;
	@Column(name="is_active")
	private Integer isActive;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaymentTermsCode() {
		return paymentTermsCode;
	}
	public void setPaymentTermsCode(String paymentTermsCode) {
		this.paymentTermsCode = paymentTermsCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Double getDisc_amt() {
		return disc_amt;
	}
	public void setDisc_amt(Double disc_amt) {
		this.disc_amt = disc_amt;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	
	

	
}
