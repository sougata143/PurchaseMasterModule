package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.ItemCategoryMappingDTO;
import com.aspl.org.entity.ItemCategorySubCategoryMap;

public interface ItemCategorySubCategoryMappingService {

	public ItemCategoryMappingDTO saveItemCategorySubcategory(ItemCategoryMappingDTO itemCategoryMappingDTO);
	public ItemCategoryMappingDTO updateItemCategorySubcategory(ItemCategoryMappingDTO itemCategoryMappingDTO);
	public List<ItemCategoryMappingDTO> getAllItemCategorySubcategoryMapping();
	public List<ItemCategoryMappingDTO> getItemCategoryMappingByItemId(String itemId);
	public List<ItemCategoryMappingDTO> getItemCategoryMappingByCategory(Integer categoryId);
	public List<ItemCategoryMappingDTO> getItemCategoryMappingSubCategory(Integer subCategory);
	public ItemCategorySubCategoryMap softDeleteItemCategoryMapping(Integer categoryMappingId);
	public void permDeleteItemCategoryMapping(Integer categoryMappingId);
	
}
