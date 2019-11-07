package com.aspl.org.service;

import java.util.List;


import com.aspl.org.dto.SubCategoryDTO;
import com.aspl.org.entity.SubCategory;

public interface SubCategoryService {

	public List<SubCategoryDTO> getAllSubCategory();
	public SubCategoryDTO getSubCategoryBySubCategoryId(Integer subCategoryId);
	public SubCategoryDTO getSubCategoryBySubCategoryName(String subCategoryName);
	public List<SubCategoryDTO> getSubCategoryByCategory(String categoryId);
	public SubCategoryDTO saveSubCategory(SubCategoryDTO subCategoryDTO);
	public SubCategoryDTO updateSubCategory(SubCategoryDTO subCategoryDTO);
	public SubCategory softDeleteSubCategory(String subCategoryId);
	public String permDeleteSubCategory(String subCategoryId);
	
}
