package com.aspl.org.dto;

public class ItemForCategoryMapDTO {

	private Integer itemId;
	private String itemCode;
	private String itemName;
	private CategoryMappingDTO category;
	private SubCategoryForMappingDTO subCategory;
	private String vendorId;
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public CategoryMappingDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryMappingDTO category) {
		this.category = category;
	}
	public SubCategoryForMappingDTO getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategoryForMappingDTO subCategory) {
		this.subCategory = subCategory;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	
}
