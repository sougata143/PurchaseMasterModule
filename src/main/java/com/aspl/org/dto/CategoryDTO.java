package com.aspl.org.dto;

import java.util.List;


public class CategoryDTO {

	private Integer categoryId;
	private String categoryName;
	private List<SubCategoryNameDTO> subCategoryName;
	
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<SubCategoryNameDTO> getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(List<SubCategoryNameDTO> subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	
	
}
