package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.CategoryDTO;
import com.aspl.org.entity.Category;

public interface CategoryService {

	public List<CategoryDTO> getAllCategory();
	public CategoryDTO getCategoryByCategoryId(Integer categoryId);
	public CategoryDTO getCategoryByName(String categoryName);
	public CategoryDTO getCategoryBySubCategory(String subCategoryId);
	public CategoryDTO saveCategory(CategoryDTO category);
	public CategoryDTO updateCategory(CategoryDTO category);
	public Category permDeleteCategory(Integer categoryId);
	public Category softDeleteCategory(Integer categoryId);
	
}
