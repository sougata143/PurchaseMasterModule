package com.aspl.org.dto;

public class JurisdictionMasterForVendorDTO {

	private Integer id;
	private String jurisdictionCode;
	private String description;
	private VendorMasterDTO vendorDTO;
	private Integer isActive;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJurisdictionCode() {
		return jurisdictionCode;
	}
	public void setJurisdictionCode(String jurisdictionCode) {
		this.jurisdictionCode = jurisdictionCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public VendorMasterDTO getVendorDTO() {
		return vendorDTO;
	}
	public void setVendorDTO(VendorMasterDTO vendorDTO) {
		this.vendorDTO = vendorDTO;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	


	


	
}
