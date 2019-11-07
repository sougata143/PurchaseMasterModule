package com.aspl.org.dto;

public class ItemCategoryMappingDTO {

	private ItemForCategoryMapDTO itemDTO;
	private CategoryMappingDTO category;
	private SubCategoryForMappingDTO subCategory;
	private Integer itemCategoryMappingId;
	
	
	public ItemForCategoryMapDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(ItemForCategoryMapDTO itemDTO) {
		this.itemDTO = itemDTO;
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
	public Integer getItemCategoryMappingId() {
		return itemCategoryMappingId;
	}
	public void setItemCategoryMappingId(Integer itemCategoryMappingId) {
		this.itemCategoryMappingId = itemCategoryMappingId;
	}
	
}
