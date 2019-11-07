package com.aspl.org.dto;

import java.io.Serializable;

public class CategoryMappingDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer categoryId;
	private String categoryName;
	
	
	
	public CategoryMappingDTO() {
		super();
		
	}
	
	
	
	public CategoryMappingDTO(Integer categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}



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


}
