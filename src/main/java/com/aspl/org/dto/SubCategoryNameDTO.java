package com.aspl.org.dto;

import java.util.List;

public class SubCategoryNameDTO {

	private Integer subCategoryId;
	private String subCategoryName;
	private List<ItemForCategoryMapDTO> itemName;
	
	public Integer getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public List<ItemForCategoryMapDTO> getItemName() {
		return itemName;
	}
	public void setItemName(List<ItemForCategoryMapDTO> itemName) {
		this.itemName = itemName;
	}
	
	
}
