package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.ItemMaster;


@Repository
public interface ItemMasterDao extends JpaRepository<ItemMaster, Integer> {
//public interface ItemMasterDao extends CrudRepository<ItemMaster, String> {
	List<ItemMaster> findByItemName(String itemName);
	
	List<ItemMaster> findByItemCode(String itemCode);
	List<ItemMaster> findByIsActive(Integer isActive);
	Long countByCategoryId2(Integer category);
	List<ItemMaster> findByDepartmentAndIsActive(String department, Integer isActive);
	//Optional<ItemMaster> findByItemCode(String itemCode);

	//Optional<ItemMaster> load(Class<ItemMaster> class1, int item_code);

	//Optional<ItemMaster> findById(String itemCode);
	//ItemMaster findById(int item_code);

}
