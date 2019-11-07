package com.aspl.org.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_category_subcategory_map")
public class ItemCategorySubCategoryMap {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer itemCategoryMappingId;
	
	@Column(name="item_id")
	private String itemId;
	private String categoryId;
	private String subCategoryId;
	private Integer isActive;
	
	public Integer getItemCategoryMappingId() {
		return itemCategoryMappingId;
	}


	public void setItemCategoryMappingId(Integer itemCategoryMappingId) {
		this.itemCategoryMappingId = itemCategoryMappingId;
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemCode(String itemId) {
		this.itemId = itemId;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getSubCategoryId() {
		return subCategoryId;
	}


	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}


	public Integer getIsActive() {
		return isActive;
	}


	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	
	
}
