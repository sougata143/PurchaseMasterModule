package com.aspl.org.dto;

public class ShippingMethodMasterforVendorDTO {

	private Integer id;
	private String shippingMethodCode;
	private String description;
	private VendorMasterDTO vendorDTO;
	private Integer isActive;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShippingMethodCode() {
		return shippingMethodCode;
	}
	public void setShippingMethodCode(String shippingMethodCode) {
		this.shippingMethodCode = shippingMethodCode;
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
