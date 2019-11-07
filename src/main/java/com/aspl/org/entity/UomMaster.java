package com.aspl.org.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uom_master")
public class UomMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uomId;
	
	@Column(name="uom_code")
	private String uomCode;
	
	@Column(name="uom_description")
	private String uomDescription;
	
	@Column(name="decimal_place")
	private Integer decimalPlace;
	
	@Column(name="is_active")
	private Integer isActive;

	public Integer getUomId() {
		return uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public String getUomDescription() {
		return uomDescription;
	}

	public void setUomDescription(String uomDescription) {
		this.uomDescription = uomDescription;
	}

	public Integer getDecimalPlace() {
		return decimalPlace;
	}

	public void setDecimalPlace(Integer decimalPlace) {
		this.decimalPlace = decimalPlace;
	}
	
	

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	

}
