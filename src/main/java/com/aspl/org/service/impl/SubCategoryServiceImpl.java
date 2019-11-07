package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.CategoryMappingDTO;
import com.aspl.org.dto.SubCategoryDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.SubCategory;
import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.SubCategoryRepo;
import com.aspl.org.service.SubCategoryService;


/*
 * @JavaDoc
 * 
 * Service for CRUD operations on subcategory table
 * 
 */
@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	SubCategoryRepo subCategoryRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ItemMasterDao itemDao;
	
	/*
	 * For fetching all the active subcategories ie the subcategories which isActive flag is 1
	 * 
	 * @Return List<SubCategoryDTO>
	 * 
	 */
	@Override
	public List<SubCategoryDTO> getAllSubCategory() {
		
		List<SubCategoryDTO> subCategoryDTOList = new ArrayList<>();
		try {
			List<SubCategory> subCategory = subCategoryRepo.findByIsActive(1);
			for(SubCategory sc : subCategory) {
				SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
				CategoryMappingDTO categoryDTO = new CategoryMappingDTO();
				
				subCategoryDTO.setSubCategoryId(sc.getSubCategoryId());
				subCategoryDTO.setSubCategoryName(sc.getSubCategoryName());
				
				Category category = new Category();
				if(sc.getCategory()!=null) {
					Optional<Category> categoryO = categoryRepo.findById(sc.getCategory().getCategoryId());
					if(categoryO.isPresent()) {
						category = categoryO.get();
					}
				}
				categoryDTO.setCategoryId(category.getCategoryId());
				categoryDTO.setCategoryName(category.getCategoryName());
				subCategoryDTO.setCategory(category.getCategoryId());
				
				/*
				 * List<ItemForCategoryMapDTO> itemNames = new ArrayList<>(); for(ItemMaster
				 * items : sc.getItemMaster()) { ItemForCategoryMapDTO itemDTO = new
				 * ItemForCategoryMapDTO(); itemDTO.setItemCode(items.getItemCode());
				 * itemDTO.setItemId(items.getId()); itemDTO.setItemName(items.getItemName());
				 * 
				 * itemNames.add(itemDTO); } subCategoryDTO.setItemName(itemNames);
				 */
				
				subCategoryDTOList.add(subCategoryDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return subCategoryDTOList;
	}

	/*
	 * For fetching all the subcategories by subcategory id
	 * 
	 * @Param subCategoryId
	 * 
	 * @Return SubCategoryDTO
	 * 
	 */
	@Override
	public SubCategoryDTO getSubCategoryBySubCategoryId(Integer subCategoryId) {
	
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
		try {
			SubCategory subCategory = subCategoryRepo.findById(subCategoryId).get();
			
			CategoryMappingDTO categoryDTO = new CategoryMappingDTO();
			
			subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
			subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
			
			Category category = categoryRepo.findById(subCategory.getCategory().getCategoryId()).get();
			categoryDTO.setCategoryId(category.getCategoryId());
			categoryDTO.setCategoryName(category.getCategoryName());
			subCategoryDTO.setCategory(category.getCategoryId());
			
			/*
			 * List<ItemForCategoryMapDTO> itemNames = new ArrayList<>(); for(ItemMaster
			 * items : subCategory.getItemMaster()) { ItemForCategoryMapDTO itemDTO = new
			 * ItemForCategoryMapDTO(); itemDTO.setItemCode(items.getItemCode());
			 * itemDTO.setItemId(items.getId()); itemDTO.setItemName(items.getItemName());
			 * itemNames.add(itemDTO); } subCategoryDTO.setItemName(itemNames);
			 */
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return subCategoryDTO;
	}

	/*
	 * @Param subCategoryName
	 * 
	 * Method for fetching subcategory by subcategory name
	 * 
	 * @Return SubCategoryDTO
	 */
	@Override
	public SubCategoryDTO getSubCategoryBySubCategoryName(String subCategoryName) {
		
		
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
		try {
			SubCategory subCategory = subCategoryRepo.findBySubCategoryName(subCategoryName);
			subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
			subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
			
			CategoryMappingDTO categoryDTO = new CategoryMappingDTO();
			
			subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
			subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
			
			Category category = categoryRepo.findById(subCategory.getCategory().getCategoryId()).get();
			categoryDTO.setCategoryId(category.getCategoryId());
			categoryDTO.setCategoryName(category.getCategoryName());
			subCategoryDTO.setCategory(category.getCategoryId());
			
			/*
			 * List<ItemForCategoryMapDTO> itemNames = new ArrayList<>(); for(ItemMaster
			 * items : subCategory.getItemMaster()) { ItemForCategoryMapDTO itemDTO = new
			 * ItemForCategoryMapDTO(); itemDTO.setItemCode(items.getItemCode());
			 * itemDTO.setItemId(items.getId()); itemDTO.setItemName(items.getItemName());
			 * itemNames.add(itemDTO); } subCategoryDTO.setItemName(itemNames);
			 */
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return subCategoryDTO;
	}

	
	/*
	 * @Param categoryId
	 * 
	 * Method for fetching subcategory by category id
	 * 
	 * @Return List<SubCategoryDTO>
	 */
	@Override
	public List<SubCategoryDTO> getSubCategoryByCategory(String categoryId) {
		
		List<SubCategory> subCategoryEntity = new ArrayList<>();
		if(categoryId!=null) {
			Optional<Category> catO = categoryRepo.findById(Integer.valueOf(categoryId));
			Category cat = new Category();
			if(catO.isPresent()) {
				cat = catO.get();
			}
			if(cat!=null) {
				subCategoryEntity = subCategoryRepo.findByCategory(cat);;
			}
		}
		List<SubCategoryDTO> subCategoryDTOList = new ArrayList<>();
		
		try {
			for(SubCategory subCategory : subCategoryEntity) {
				SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
				subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
				subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
				
				CategoryMappingDTO categoryDTO = new CategoryMappingDTO();
				
				subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
				subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
				
				Category category = categoryRepo.findById(subCategory.getCategory().getCategoryId()).get();
				categoryDTO.setCategoryId(category.getCategoryId());
				categoryDTO.setCategoryName(category.getCategoryName());
				subCategoryDTO.setCategory(category.getCategoryId());
				
				/*
				 * List<ItemForCategoryMapDTO> itemNames = new ArrayList<>(); for(ItemMaster
				 * items : subCategory.getItemMaster()) { ItemForCategoryMapDTO itemDTO = new
				 * ItemForCategoryMapDTO(); itemDTO.setItemCode(items.getItemCode());
				 * itemDTO.setItemId(items.getId()); itemDTO.setItemName(items.getItemName());
				 * itemNames.add(itemDTO); } subCategoryDTO.setItemName(itemNames);
				 */
				
				subCategoryDTOList.add(subCategoryDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return subCategoryDTOList;
	}

	/*
	 * @Param subCategoryDTO
	 * 
	 * Method for saving the subcategory
	 * 
	 */
	@Override
	public SubCategoryDTO saveSubCategory(SubCategoryDTO subCategoryDTO) {
		
		try {
			SubCategory subCategory = new SubCategory();
			Category category = new Category(); 
			if(subCategoryDTO.getCategory() != null) {
				Optional<Category> categoryO = categoryRepo.findById(subCategoryDTO.getCategory());
				if(categoryO.isPresent()) {
					category = categoryO.get();
				}
			}
			subCategory.setCategory(category);
			subCategory.setCategoryId(category.getCategoryId());
		
			/*
			 * List<ItemMaster> items = new ArrayList<>(); if(subCategoryDTO.getItemName()
			 * != null) { for(ItemForCategoryMapDTO item : subCategoryDTO.getItemName()) {
			 * ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO();
			 * 
			 * ItemMaster itemEntity = itemDao.findById(item.getItemId()).get();
			 * items.add(itemEntity); } } subCategory.setItemMaster(items);
			 */
			subCategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());
			subCategory.setIsActive(1);
			
			subCategoryRepo.save(subCategory);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return subCategoryDTO;
	}

	@Override
	public SubCategoryDTO updateSubCategory(SubCategoryDTO subCategoryDTO) {
		
		try {
			SubCategory subCategory = subCategoryRepo.findById(subCategoryDTO.getSubCategoryId()).get();
			
			Optional<Category> categoryO = categoryRepo.findById(subCategoryDTO.getCategory());
			if(categoryO.isPresent()) {
				subCategory.setCategory(categoryO.get());
				subCategory.setCategoryId(categoryO.get().getCategoryId());
			}
			
			/*List<ItemMaster> items = new ArrayList<>();
			for(ItemForCategoryMapDTO item : subCategoryDTO.getItemName()) {
				ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO();
				ItemMaster itemEntity = itemDao.findById(item.getItemId()).get();
				items.add(itemEntity);
			}
			subCategory.setItemMaster(items);*/
			subCategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());
			
			if(subCategory!=null) {
				subCategoryRepo.save(subCategory);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return subCategoryDTO;
	}

	/*
	 * @Param subCategoryId
	 * 
	 * Method for updating the isActive flag to 0 which will make the subcategory inactive
	 *  
	 */
	@Override
	public SubCategory softDeleteSubCategory(String subCategoryId) {
		
		SubCategory subCategory = new SubCategory(); 
		try {
			subCategory = subCategoryRepo.findById(Integer.valueOf(subCategoryId)).get();
			subCategory.setIsActive(0);
			subCategoryRepo.save(subCategory);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return subCategory;
	}

	
	/*
	 * @Param subCategoryId
	 * 
	 * Method for permanently delete the sub category
	 * 
	 */
	@Override
	public String permDeleteSubCategory(String subCategoryId) {
		
		try {
			subCategoryRepo.deleteById(Integer.valueOf(subCategoryId));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return subCategoryId;
	}

}
