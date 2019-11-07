package com.aspl.org.dto;

import java.io.Serializable;
import java.util.List;

public class SubCategoryDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer subCategoryId;
	private String subCategoryName;
	private List<ItemForCategoryMapDTO> itemName;
	private Integer category;
	
	

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
	@Override
	public String toString() {
		return "SubCategoryDTO [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + "]";
	}
	public List<ItemForCategoryMapDTO> getItemName() {
		return itemName;
	}
	public void setItemName(List<ItemForCategoryMapDTO> itemName) {
		this.itemName = itemName;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	
	
	
}
