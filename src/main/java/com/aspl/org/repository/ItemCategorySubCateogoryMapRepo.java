package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.ItemCategorySubCategoryMap;

@Repository
public interface ItemCategorySubCateogoryMapRepo extends JpaRepository<ItemCategorySubCategoryMap, Integer> {

	public List<ItemCategorySubCategoryMap> findByCategoryId(String categoryId);
	public List<ItemCategorySubCategoryMap> findByItemId(String itemId);
	public List<ItemCategorySubCategoryMap> findBySubCategoryId(String subCategoryId);
	public List<ItemCategorySubCategoryMap> findByIsActive(Integer isActive);
	
}
