package com.aspl.org.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.aspl.org.dto.ItemMasterDTO;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.ResponseDetails;

@Service
public interface ItemMasterService {

	
	ResponseDetails itemMasterSave(ItemMasterDTO itemMaster);
	
	public ItemMasterDTO itemMasterUpdate(ItemMasterDTO currentItem);
    //void itemMasterUpdate(ItemMaster currentItem);

	ResponseDetails itemmasterupdate(ItemMasterDTO itemMaster1);
//	ItemMaster itemmasterupdate(ItemMaster itemMaster);
	
	List<ItemMasterDTO> getallitemlist();
	List<ItemMasterDTO> getallitemlistByDepartment(String department);

	
	//Optional<ItemMaster> findByItemCode(String itemCode);
	ItemMasterDTO findByItemCode(String itemCode);
	
	ItemMasterDTO findByItemId(Integer itemId);
	

	ItemMasterDTO findByItemName(String itemName);

	//int deleteItemById(Optional<ItemMaster> itemMaster);

	ResponseDetails deleteItemMasterById(int itemCode);
    void itemmasterdelete(ItemMasterDTO itemMaster);

	ItemMasterDTO softDeleteItem(Integer id);
	
	ItemMasterDTO prepareItemMasterDTO(ItemMaster itemMaster);
	ItemMaster prepraeItemMasterEntity(ItemMasterDTO itemMasterDTO);
	
	
}
