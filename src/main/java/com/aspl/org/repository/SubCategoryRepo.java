package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.Category;
import com.aspl.org.entity.SubCategory;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer> {

	SubCategory findBySubCategoryName(String subCategoryName);
	List<SubCategory> findByCategory(Category category);
	List<SubCategory> findByIsActive(Integer isActive);
	
}
