package com.aspl.org.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subcategory")
public class SubCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer subCategoryId;
	
	@Column(name="sub_category_name")
	private String subCategoryName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id",insertable=false,updatable=false)
	private Category category;
	
//	@OneToMany(fetch=FetchType.LAZY)
//	@JoinColumn(name="id")
//	private List<ItemMaster> itemMaster;
	
	@Column(name="isActive")
	private Integer isActive;
	
	@Column(name="category_id")
	private Integer categoryId;

	public Integer getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

//	public List<ItemMaster> getItemMaster() {
//		return itemMaster;
//	}
//
//	public void setItemMaster(List<ItemMaster> itemMaster) {
//		this.itemMaster = itemMaster;
//	}
	
	
	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	
}
