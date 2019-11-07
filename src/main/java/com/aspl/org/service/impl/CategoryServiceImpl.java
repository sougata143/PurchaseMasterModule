package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.CategoryDTO;
import com.aspl.org.dto.SubCategoryNameDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.SubCategory;
import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.SubCategoryRepo;
import com.aspl.org.service.CategoryService;

/*
 * Service for CRUD operations of category master
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	SubCategoryRepo subCategoryRepo;
	
	/*
	 * Method for fetching all the active categories ie searched by isActive = 1
	 */
	@Override
	public List<CategoryDTO> getAllCategory() {
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		List<SubCategoryNameDTO> subCategoryNames = new ArrayList<>();
		try {
			List<Category> categories = categoryRepo.findByIsActive(1);
			
			for(Category cate : categories) {
				CategoryDTO categoryDTO = new CategoryDTO();
				
				categoryDTO.setCategoryId(cate.getCategoryId());
				categoryDTO.setCategoryName(cate.getCategoryName());
				
				
				  for(SubCategory name : cate.getSubCategory()) {
					  SubCategoryNameDTO SubCategoryDTO = new SubCategoryNameDTO();
					  SubCategoryDTO.setSubCategoryId(name.getSubCategoryId());
					  SubCategoryDTO.setSubCategoryName(name.getSubCategoryName());
					 
					/*
					 * List<ItemForCategoryMapDTO> itemNames = new ArrayList<>(); for(ItemMaster
					 * items : name.getItemMaster()) { ItemForCategoryMapDTO itemDTO = new
					 * ItemForCategoryMapDTO(); itemDTO.setItemCode(items.getItemCode());
					 * itemDTO.setItemId(items.getId()); itemDTO.setItemName(items.getItemName());
					 * 
					 * itemNames.add(itemDTO); }
					 * 
					 * SubCategoryDTO.setItemName(itemNames);
					 */
					  subCategoryNames.add(SubCategoryDTO); 
				  }
				 
				
				categoryDTO.setSubCategoryName(subCategoryNames);
				
				categoryDTOs.add(categoryDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return categoryDTOs;
	}

	/*
	 * @Param categoryId
	 * 
	 * Method for fetching category by category id
	 * 
	 */
	@Override
	public CategoryDTO getCategoryByCategoryId(Integer categoryId) {
		CategoryDTO categoryDTO = new CategoryDTO();
		List<SubCategoryNameDTO> subCategoryNames = new ArrayList<>();
		
		try {
			Category category = categoryRepo.findById(categoryId).get();
			categoryDTO.setCategoryId(category.getCategoryId());
			categoryDTO.setCategoryName(category.getCategoryName());
			
			for(SubCategory name : category.getSubCategory()) {
				SubCategoryNameDTO SubCategoryDTO = new SubCategoryNameDTO();
				  SubCategoryDTO.setSubCategoryId(name.getSubCategoryId());
				  SubCategoryDTO.setSubCategoryName(name.getSubCategoryName());
				 
				/*
				 * List<ItemForCategoryMapDTO> itemNames = new ArrayList<>(); for(ItemMaster
				 * items : name.getItemMaster()) { ItemForCategoryMapDTO itemDTO = new
				 * ItemForCategoryMapDTO(); itemDTO.setItemCode(items.getItemCode());
				 * itemDTO.setItemId(items.getId()); itemDTO.setItemName(items.getItemName());
				 * 
				 * itemNames.add(itemDTO); }
				 * 
				 * SubCategoryDTO.setItemName(itemNames);
				 */
				  subCategoryNames.add(SubCategoryDTO); 
			  }
			categoryDTO.setSubCategoryName(subCategoryNames);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return categoryDTO;
	}

	/*
	 * @Param categoryName
	 * 
	 * Method for fetching categories by category name
	 * 
	 */
	@Override
	public CategoryDTO getCategoryByName(String categoryName) {
		CategoryDTO categoryDTO = new CategoryDTO();
		List<SubCategoryNameDTO> subCategoryNames = new ArrayList<>();
		
		try {
			Category category = categoryRepo.findByCategoryName(categoryName);
			categoryDTO.setCategoryId(category.getCategoryId());
			categoryDTO.setCategoryName(category.getCategoryName());
			
			for(SubCategory name : category.getSubCategory()) {
				SubCategoryNameDTO SubCategoryDTO = new SubCategoryNameDTO();
				  SubCategoryDTO.setSubCategoryId(name.getSubCategoryId());
				  SubCategoryDTO.setSubCategoryName(name.getSubCategoryName());
				 
				/*
				 * List<ItemForCategoryMapDTO> itemNames = new ArrayList<>(); for(ItemMaster
				 * items : name.getItemMaster()) { ItemForCategoryMapDTO itemDTO = new
				 * ItemForCategoryMapDTO(); itemDTO.setItemCode(items.getItemCode());
				 * itemDTO.setItemId(items.getId()); itemDTO.setItemName(items.getItemName());
				 * 
				 * itemNames.add(itemDTO); }
				 * 
				 * SubCategoryDTO.setItemName(itemNames);
				 */
				  subCategoryNames.add(SubCategoryDTO); 
			  }
			categoryDTO.setSubCategoryName(subCategoryNames);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return categoryDTO;
	}

	/*
	 * @Param subCategoryID
	 * 
	 * Method for fetching all the categories by subcategory id
	 * 
	 */
	@Override
	public CategoryDTO getCategoryBySubCategory(String subCategoryId) {
		CategoryDTO categoryDTO = new CategoryDTO();
		List<SubCategoryNameDTO> subCategoryNames = new ArrayList<>();
		
		try {
			Category category = categoryRepo.findBySubCategory(subCategoryRepo.findById(Integer.valueOf(subCategoryId)).get());
			categoryDTO.setCategoryId(category.getCategoryId());
			categoryDTO.setCategoryName(category.getCategoryName());
			
			for(SubCategory name : category.getSubCategory()) {
				SubCategoryNameDTO SubCategoryDTO = new SubCategoryNameDTO();
				  SubCategoryDTO.setSubCategoryId(name.getSubCategoryId());
				  SubCategoryDTO.setSubCategoryName(name.getSubCategoryName());
				 
				/*
				 * List<ItemForCategoryMapDTO> itemNames = new ArrayList<>(); for(ItemMaster
				 * items : name.getItemMaster()) { ItemForCategoryMapDTO itemDTO = new
				 * ItemForCategoryMapDTO(); itemDTO.setItemCode(items.getItemCode());
				 * itemDTO.setItemId(items.getId()); itemDTO.setItemName(items.getItemName());
				 * 
				 * itemNames.add(itemDTO); }
				 * 
				 * SubCategoryDTO.setItemName(itemNames);
				 */
				  subCategoryNames.add(SubCategoryDTO); 
			  }
			categoryDTO.setSubCategoryName(subCategoryNames);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return categoryDTO;
	}

	/*
	 * @Param categoryDTO
	 * 
	 * Method for saving the Category
	 * 
	 */
	@Override
	public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setCategoryName(categoryDTO.getCategoryName());
		category.setIsActive(1);
		List<SubCategory> subCategories = new ArrayList<>();
		if(categoryDTO.getSubCategoryName()!=null) {
			for(SubCategoryNameDTO subCategoryDTO : categoryDTO.getSubCategoryName()) {
				SubCategory subCategory = subCategoryRepo.findById(subCategoryDTO.getSubCategoryId()).get();
				subCategories.add(subCategory);
			}
		}
		category.setSubCategory(subCategories);
		
		try {
			categoryRepo.save(category);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return categoryDTO;
	}

	/*
	 * @Param categoryDTO
	 * 
	 * Method for updating the category. In this category is searched by category id which is sent in the DTO and then set the values from DTO and save it.
	 * 
	 */
	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
		Category categoryEntity = categoryRepo.findById(categoryDTO.getCategoryId()).get();
		
		categoryEntity.setCategoryName(categoryDTO.getCategoryName());
		List<SubCategory> subCategories = new ArrayList<>();
		if(categoryDTO.getSubCategoryName()!=null) {
			for(SubCategoryNameDTO subCategoryDTO : categoryDTO.getSubCategoryName()) {
				SubCategory subCategory = subCategoryRepo.findById(subCategoryDTO.getSubCategoryId()).get();
				subCategories.add(subCategory);
			}
		}
		categoryEntity.setSubCategory(subCategories);
		
		if(categoryEntity!=null) {
			try {
				categoryRepo.save(categoryEntity);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return categoryDTO;
	}

	/*
	 * @Param categoryId
	 * 
	 * Method for permanently delete the category
	 * 
	 */
	@Override
	public Category permDeleteCategory(Integer categoryId) {
		Category categoryEntity = categoryRepo.findById(categoryId).get();
		try {
			categoryRepo.delete(categoryEntity);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return categoryEntity;
	}

	/*
	 * @Param categoryId
	 * 
	 * Method for updating the isActive field to 0 which makes the category inactive
	 * 
	 */
	@Override
	public Category softDeleteCategory(Integer categoryId) {
		Category categoryEntity = categoryRepo.findById(categoryId).get();
		
		categoryEntity.setIsActive(0);
		try {
			categoryRepo.save(categoryEntity);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return categoryEntity;
	}

}
