package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.CategoryMappingDTO;
import com.aspl.org.dto.ItemCategoryMappingDTO;
import com.aspl.org.dto.ItemForCategoryMapDTO;
import com.aspl.org.dto.SubCategoryForMappingDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.ItemCategorySubCategoryMap;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.SubCategory;
import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.ItemCategorySubCateogoryMapRepo;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.SubCategoryRepo;
import com.aspl.org.service.ItemCategorySubCategoryMappingService;



/*
 * Service Class For Mapping Item Category and SubCategory
 */
@Service
public class ItemCategoryMappingServiceImpl implements ItemCategorySubCategoryMappingService{
	
	@Autowired
	ItemCategorySubCateogoryMapRepo itemCategorySubCateogoryMapRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	SubCategoryRepo subCategoryRepo;
	
	@Autowired 
	ItemMasterDao itemDao;

	/*
	 * @Param itemCategoryMappingDTO
	 * 
	 * Method for saving item category subcategory mapping
	 * 
	 */
	@Override
	public ItemCategoryMappingDTO saveItemCategorySubcategory(ItemCategoryMappingDTO itemCategoryMappingDTO) {
		
		
		ItemCategorySubCategoryMap itemCategorySubCategoryMap = new ItemCategorySubCategoryMap();
		
		itemCategorySubCategoryMap.setCategoryId(String.valueOf(itemCategoryMappingDTO.getCategory().getCategoryId()));
		itemCategorySubCategoryMap.setItemCode(itemCategoryMappingDTO.getItemDTO().getItemCode());
		itemCategorySubCategoryMap.setSubCategoryId(String.valueOf(itemCategoryMappingDTO.getSubCategory().getSubCategoryId()));
		itemCategorySubCategoryMap.setIsActive(1);
		try {
			itemCategorySubCateogoryMapRepo.save(itemCategorySubCategoryMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return itemCategoryMappingDTO;
	}

	
	/*
	 * Method for fetching all active item category sub category mapping 
	 */
	@Override
	public List<ItemCategoryMappingDTO> getAllItemCategorySubcategoryMapping() {
		
		
		List<ItemCategoryMappingDTO> emptyItemCategoryMappingDTOs = new ArrayList<>();
		List<ItemCategorySubCategoryMap> itemCategorySubCategoryMap = itemCategorySubCateogoryMapRepo.findByIsActive(1);
		
		try {
			for(ItemCategorySubCategoryMap icsm : itemCategorySubCategoryMap) {
				ItemCategoryMappingDTO ItemCategoryMappingDTO = new ItemCategoryMappingDTO();
				
				CategoryMappingDTO categoryMappingDTO = new CategoryMappingDTO();
				SubCategoryForMappingDTO subCategoryForMappingDTO = new SubCategoryForMappingDTO();
				ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO(); 
				
				Category categoryEntity = categoryRepo.findById(Integer.valueOf(icsm.getCategoryId())).get();
				categoryMappingDTO.setCategoryId(categoryEntity.getCategoryId());
				categoryMappingDTO.setCategoryName(categoryEntity.getCategoryName());
				
				SubCategory subCategory = subCategoryRepo.findById(Integer.valueOf(icsm.getSubCategoryId())).get();
				subCategoryForMappingDTO.setSubCategoryId(subCategory.getSubCategoryId());
				subCategoryForMappingDTO.setSubCategoryName(subCategory.getSubCategoryName());
				
				ItemMaster itemEntity = itemDao.findById(Integer.valueOf(icsm.getItemId())).get();
				itemDTO.setItemCode(itemEntity.getItemCode());
				itemDTO.setItemId(itemEntity.getId());
				itemDTO.setItemName(itemEntity.getItemName());

				ItemCategoryMappingDTO.setCategory(categoryMappingDTO);
				ItemCategoryMappingDTO.setItemDTO(itemDTO);
				ItemCategoryMappingDTO.setSubCategory(subCategoryForMappingDTO);
				ItemCategoryMappingDTO.setItemCategoryMappingId(icsm.getItemCategoryMappingId());
				
				emptyItemCategoryMappingDTOs.add(ItemCategoryMappingDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return emptyItemCategoryMappingDTOs;
	}

	/*
	 * @Param itemId
	 * 
	 * Method for fetching item category sub category mapping by item
	 */
	@Override
	public List<ItemCategoryMappingDTO> getItemCategoryMappingByItemId(String itemId) {
		ItemCategoryMappingDTO itemCategoryMappingDTO = new ItemCategoryMappingDTO();
		List<ItemCategorySubCategoryMap> itemCategoryMap = itemCategorySubCateogoryMapRepo.findByItemId(String.valueOf(itemId));
		CategoryMappingDTO categoryMappingDTO = new CategoryMappingDTO();
		ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO();
		SubCategoryForMappingDTO subCategoryForMappingDTO = new SubCategoryForMappingDTO();
		List<ItemCategoryMappingDTO> itemCategoryMappingDTOs = new ArrayList<>();
		
		try {
			for(ItemCategorySubCategoryMap icm : itemCategoryMap) {
				ItemMaster item = itemDao.findById(Integer.valueOf(icm.getItemId())).get();
				if(item!=null) {
					itemDTO.setItemCode(item.getItemCode());
					itemDTO.setItemId(item.getId());
					itemDTO.setItemName(item.getItemName());
				}
				
				Category category = categoryRepo.findById(Integer.valueOf(icm.getCategoryId())).get();
				categoryMappingDTO.setCategoryId(category.getCategoryId());
				categoryMappingDTO.setCategoryName(category.getCategoryName());
				
				SubCategory subcategory = subCategoryRepo.findById(Integer.valueOf(icm.getSubCategoryId())).get();
				subCategoryForMappingDTO.setSubCategoryId(subcategory.getSubCategoryId());
				subCategoryForMappingDTO.setSubCategoryName(subcategory.getSubCategoryName());
				
				itemCategoryMappingDTO.setCategory(categoryMappingDTO);
				itemCategoryMappingDTO.setItemCategoryMappingId(icm.getItemCategoryMappingId());
				itemCategoryMappingDTO.setItemDTO(itemDTO);
				itemCategoryMappingDTO.setSubCategory(subCategoryForMappingDTO);
				
				itemCategoryMappingDTOs.add(itemCategoryMappingDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return itemCategoryMappingDTOs;
	}

	/*
	 * @Param categoryId
	 * 
	 * Method for fetching item category sub category by category
	 */
	@Override
	public List<ItemCategoryMappingDTO> getItemCategoryMappingByCategory(Integer categoryId) {
		
		ItemCategoryMappingDTO itemCategoryMappingDTO = new ItemCategoryMappingDTO();
		List<ItemCategorySubCategoryMap> itemCategoryMap = itemCategorySubCateogoryMapRepo.findByCategoryId(String.valueOf(categoryId));
		CategoryMappingDTO categoryMappingDTO = new CategoryMappingDTO();
		ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO();
		SubCategoryForMappingDTO subCategoryForMappingDTO = new SubCategoryForMappingDTO(); 
		
		List<ItemCategoryMappingDTO> itemCategoryMappingDTOs = new ArrayList<>();
		
		try {
			for(ItemCategorySubCategoryMap icm : itemCategoryMap) {
				ItemMaster item = itemDao.findById(Integer.valueOf(icm.getItemId())).get();
				if(item!=null) {
					itemDTO.setItemCode(item.getItemCode());
					itemDTO.setItemId(item.getId());
					itemDTO.setItemName(item.getItemName());
				}
				
				Category category = categoryRepo.findById(Integer.valueOf(icm.getCategoryId())).get();
				categoryMappingDTO.setCategoryId(category.getCategoryId());
				categoryMappingDTO.setCategoryName(category.getCategoryName());
				
				SubCategory subcategory = subCategoryRepo.findById(Integer.valueOf(icm.getSubCategoryId())).get();
				subCategoryForMappingDTO.setSubCategoryId(subcategory.getSubCategoryId());
				subCategoryForMappingDTO.setSubCategoryName(subcategory.getSubCategoryName());
				
				itemCategoryMappingDTO.setCategory(categoryMappingDTO);
				itemCategoryMappingDTO.setItemCategoryMappingId(icm.getItemCategoryMappingId());
				itemCategoryMappingDTO.setItemDTO(itemDTO);
				itemCategoryMappingDTO.setSubCategory(subCategoryForMappingDTO);
				
				itemCategoryMappingDTOs.add(itemCategoryMappingDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return itemCategoryMappingDTOs;
	}

	/*
	 * @Param subCategory
	 * 
	 * Method for fetching item category sub category mapping by subcategory
	 * 
	 */
	@Override
	public List<ItemCategoryMappingDTO> getItemCategoryMappingSubCategory(Integer subCategory) {
		
		ItemCategoryMappingDTO itemCategoryMappingDTO = new ItemCategoryMappingDTO();
		List<ItemCategorySubCategoryMap> itemCategoryMap = itemCategorySubCateogoryMapRepo.findBySubCategoryId(String.valueOf(subCategory));
		CategoryMappingDTO categoryMappingDTO = new CategoryMappingDTO();
		ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO();
		SubCategoryForMappingDTO subCategoryForMappingDTO = new SubCategoryForMappingDTO(); 
		
		List<ItemCategoryMappingDTO> itemCategoryMappingDTOs = new ArrayList<>();
		
		try {
			for(ItemCategorySubCategoryMap icm : itemCategoryMap) {
				ItemMaster item = itemDao.findById(Integer.valueOf(icm.getItemId())).get();
				if(item!=null) {
					itemDTO.setItemCode(item.getItemCode());
					itemDTO.setItemId(item.getId());
					itemDTO.setItemName(item.getItemName());
				}
				
				Category category = categoryRepo.findById(Integer.valueOf(icm.getCategoryId())).get();
				categoryMappingDTO.setCategoryId(category.getCategoryId());
				categoryMappingDTO.setCategoryName(category.getCategoryName());
				
				SubCategory subcategory = subCategoryRepo.findById(Integer.valueOf(icm.getSubCategoryId())).get();
				subCategoryForMappingDTO.setSubCategoryId(subcategory.getSubCategoryId());
				subCategoryForMappingDTO.setSubCategoryName(subcategory.getSubCategoryName());
				
				itemCategoryMappingDTO.setCategory(categoryMappingDTO);
				itemCategoryMappingDTO.setItemCategoryMappingId(icm.getItemCategoryMappingId());
				itemCategoryMappingDTO.setItemDTO(itemDTO);
				itemCategoryMappingDTO.setSubCategory(subCategoryForMappingDTO);
				
				itemCategoryMappingDTOs.add(itemCategoryMappingDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return itemCategoryMappingDTOs;
	}

	/*
	 * @Param itemCategoryMappingDTO
	 * 
	 * Method for updating item Category subcategory mapping
	 */
	@Override
	public ItemCategoryMappingDTO updateItemCategorySubcategory(ItemCategoryMappingDTO itemCategoryMappingDTO) {
		ItemCategorySubCategoryMap itemCategorySubCategoryMap = itemCategorySubCateogoryMapRepo.findById(itemCategoryMappingDTO.getItemCategoryMappingId()).get();
		
		itemCategorySubCategoryMap.setCategoryId(String.valueOf(itemCategoryMappingDTO.getCategory().getCategoryId()));
		itemCategorySubCategoryMap.setItemCode(itemCategoryMappingDTO.getItemDTO().getItemCode());
		itemCategorySubCategoryMap.setSubCategoryId(String.valueOf(itemCategoryMappingDTO.getSubCategory().getSubCategoryId()));
		
		try {
			itemCategorySubCateogoryMapRepo.save(itemCategorySubCategoryMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return itemCategoryMappingDTO;
	}


	/*
	 * @Param categoryMappingId
	 * 
	 * Method for disabling item category sub category mapping by mapping id, ie updating the mapping entity's isActive field to 0. 
	 * 
	 */
	@Override
	public ItemCategorySubCategoryMap softDeleteItemCategoryMapping(Integer categoryMappingId) {
		
		ItemCategorySubCategoryMap itemMap = itemCategorySubCateogoryMapRepo.findById(categoryMappingId).get();
		itemMap.setIsActive(0);
		itemCategorySubCateogoryMapRepo.save(itemMap);
		return null;
	}


	/*
	 * @Param categoryMappingId
	 * 
	 * Method for permanently delete an item category mapping entity
	 * 
	 */
	@Override
	public void permDeleteItemCategoryMapping(Integer categoryMappingId) {
	
		itemCategorySubCateogoryMapRepo.deleteById(categoryMappingId);
	}  

}
