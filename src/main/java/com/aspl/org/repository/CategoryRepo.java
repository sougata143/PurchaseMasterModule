package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.Category;
import com.aspl.org.entity.SubCategory;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

	Category findByCategoryName(String categoryName);
	Category findBySubCategory(SubCategory subCategory);
	List<Category> findByIsActive(Integer isActive);
	
}
