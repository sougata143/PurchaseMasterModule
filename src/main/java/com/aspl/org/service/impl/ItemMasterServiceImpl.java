package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.CategoryMappingDTO;
import com.aspl.org.dto.ItemMasterDTO;
import com.aspl.org.dto.SubCategoryForMappingDTO;
import com.aspl.org.dto.VendorForItemDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.ItemCategorySubCategoryMap;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.StoreDetails;
import com.aspl.org.entity.SubCategory;
import com.aspl.org.entity.UomMaster;
import com.aspl.org.entity.VendorMaster;
import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.ItemCategorySubCateogoryMapRepo;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.LandedPriceDao;
import com.aspl.org.repository.StoreDetailsDao;
import com.aspl.org.repository.SubCategoryRepo;
import com.aspl.org.repository.UomMasterRepo;
import com.aspl.org.repository.VendorMasterDao;
import com.aspl.org.service.ItemMasterService;


/*
 * Service for operations on item master (mainly CRUD operations)
 */
@Service
@Transactional
public class ItemMasterServiceImpl implements ItemMasterService {

	
	@Autowired 
	ItemMasterDao itemMasterDao;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	SubCategoryRepo subCategoryRepo;
	
	@Autowired
	ItemCategorySubCateogoryMapRepo categoryMapRepo;
	
	@Autowired
	VendorMasterDao vendorDao;
	
	@Autowired
	StoreDetailsDao storeDao;
	
	@Autowired
	UomMasterRepo uomRepo;
	
	@Autowired
	LandedPriceDao landedPriceDao;
	

	/*
	 * @Override public ItemMaster itemmasterupdate(Optional<ItemMaster>
	 * itemMaster1) {
	 * 
	 * return itemMasterDao.save(itemMaster1); }
	 */

	/*
	 * @Param itemMasterDTO
	 * 
	 * Method for update item master
	 * 
	 * @Return ItemMasterDTO
	 * 
	 */
	@Override
	public ResponseDetails itemmasterupdate(ItemMasterDTO itemMasterDTO) {
		ItemMaster saveSuccess = new ItemMaster();
		try {
			if(itemMasterDTO.getId()!=null) {
				ItemMaster itemEntity = new ItemMaster();
				Optional<ItemMaster> itemEntityO = itemMasterDao.findById(itemMasterDTO.getId());
				if(itemEntityO.isPresent()) {
					itemEntity = itemEntityO.get();
				}
				
				itemEntity.setItemCode(itemMasterDTO.getItemCode());
				
				itemEntity.setBaseUom(itemMasterDTO.getBaseUom());
				itemEntity.setCategory(itemMasterDTO.getCategory());
				itemEntity.setConversionPurchase(itemMasterDTO.getConversionPurchase());
				itemEntity.setCustMetalGrade(itemMasterDTO.getCustMetalGrade());
				itemEntity.setDespatching(itemMasterDTO.getDespatching());
				itemEntity.setExciseClassification(itemMasterDTO.getExciseClassification());
				itemEntity.setHeat_treatment(itemMasterDTO.getHeat_treatment());
				itemEntity.setIsActive(itemMasterDTO.getIsActive());
				itemEntity.setIsLocked(itemMasterDTO.getIsActive());
				itemEntity.setIssueUom(itemMasterDTO.getIssueUom());
				
				itemEntity.setItemName(itemMasterDTO.getItemName());
				itemEntity.setMaximum(itemMasterDTO.getMaximum());
				itemEntity.setMinimum(itemMasterDTO.getMinimum());
				itemEntity.setMouldProcess(itemMasterDTO.getMouldProcess());
				itemEntity.setPurchaseType(itemMasterDTO.getPurchaseType());
				itemEntity.setPurchaseUom(itemMasterDTO.getPurchaseUom());
				itemEntity.setRemarks(itemMasterDTO.getRemarks());
				itemEntity.setReorder(itemMasterDTO.getReorder());
				itemEntity.setSupply_condition(itemMasterDTO.getSupply_condition());
				itemEntity.setBOM(itemMasterDTO.getBom());
				
				itemEntity.setBarCode(itemMasterDTO.getBarCode());
//				itemEntity.setSapCode(itemMasterDTO.getSapCode());
				itemEntity.setHsCode(itemMasterDTO.getHsCode());
				itemEntity.setWeightInKgs(itemMasterDTO.getWeightInKgs());
				itemEntity.setProdBatchSizeMax(itemMasterDTO.getProdBatchSizeMax());
				itemEntity.setProdBatchSizeMin(itemMasterDTO.getProdBatchSizeMin());
				itemEntity.setSupply_condition(itemMasterDTO.getSupply_condition());
//				itemEntity.setProdnMetalGrade(itemMasterDTO.getProdnMetalGrade());
				itemEntity.setCasting_wt(itemMasterDTO.getCasting_wt());
				itemEntity.setMachined_wt(itemMasterDTO.getMachined_wt());
				
				itemEntity.setBoughtOutWt(itemMasterDTO.getBoughtOutWt());
				itemEntity.setUpdatedPrice(itemMasterDTO.getUpdatedPrice());
				itemEntity.setCoreMakingProcess(itemMasterDTO.getCoreMakingProcess());
				
				if(itemMasterDTO.getVendorCode().getVendorId()!=null) {
					itemEntity.setVendorCode(String.valueOf(itemMasterDTO.getVendorCode().getVendorId()));
				}
				
				Category category = new Category();
				SubCategory subCategory = new SubCategory();
				
				if(itemMasterDTO.getCategoryId()!=null && itemMasterDTO.getCategoryId().getCategoryId()!=null) {
					Optional<Category> categoryO = categoryRepo.findById(itemMasterDTO.getCategoryId().getCategoryId());
					if(categoryO.isPresent()) {
						category = categoryO.get();
						
						itemEntity.setCategoryId(category);
					}
				}
				if(itemMasterDTO.getSubCategoryId()!=null && itemMasterDTO.getSubCategoryId().getSubCategoryId()!=null) {
					Optional<SubCategory> subCategoryO = subCategoryRepo.findById(itemMasterDTO.getSubCategoryId().getSubCategoryId());
					if(subCategoryO.isPresent()) {
						subCategory = subCategoryO.get();
						
						itemEntity.setSubCategoryId(subCategory);
					}
				}
				
				
				itemEntity.setCategoryId2(itemMasterDTO.getCategoryId().getCategoryId());
				itemEntity.setSubCategoryId2(itemMasterDTO.getSubCategoryId().getSubCategoryId());
				
				saveSuccess = itemMasterDao.save(itemEntity);
						
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseDetails(new Date(), "'"+saveSuccess.getItemName()+"' updated.", saveSuccess.toString(), 200);
	}
	
	/*
	 * @Param itemMaster
	 * 
	 *  Method for delete item master
	 *  
	 */
	@Override
	public void itemmasterdelete(ItemMasterDTO itemMaster) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Method for fetching all the items
	 */
	@Override
	public List<ItemMasterDTO> getallitemlist() {
		List<ItemMasterDTO> itemMasterDTOs = new ArrayList<>();
		try {
			List<ItemMaster> itemEntity = itemMasterDao.findByIsActive(1); //For fetching active items
			for(ItemMaster item : itemEntity) {
				
				ItemMasterDTO itemDTO = new ItemMasterDTO();
				
				itemDTO = prepareItemMasterDTO(item);
				
				itemMasterDTOs.add(itemDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return itemMasterDTOs;
	}

	/*
	 * @Param itemName
	 * 
	 * Method for fetching item by item name
	 * 
	 * @Return ItemMasterDTO
	 * 
	 */
	@Override
	public ItemMasterDTO findByItemName(String itemName) {
		
		//int item_code=Integer.parseInt(itemName);
		ItemMasterDTO itemDTO = new ItemMasterDTO();
		try {
			List<ItemMaster> items = itemMasterDao.findByItemName(itemName);
			ItemMaster item = new ItemMaster();
			if(!items.isEmpty()) {
				item = items.get(0);
			}

			
			if(item!=null) {
				itemDTO = prepareItemMasterDTO(item);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		  
		
		return itemDTO;

	}
	
	
	/*
	 * @Override public Optional<ItemMaster> findByItemCode(String itemCode) {
	 * ("itemCode: "+itemCode); //int
	 * item_code=Integer.parseInt(itemCode); //Optional<ItemMaster>
	 * itemMaster=itemMasterDao.findByItemCode(itemCode); Optional<ItemMaster>
	 * itemMaster=itemMasterDao.findByItemCode(itemCode); //ItemMaster
	 * itemMaster=itemMasterDao.findById(item_code); return itemMaster;
	 * 
	 * }
	 */
	
	/*
	 * @Param itemCode
	 * 
	 * Method for fetching item by item code
	 * 
	 * @Return ItemMasterDTO
	 * 
	 */
	  @Override
	  public ItemMasterDTO findByItemCode(String itemCode) {

	  ItemMasterDTO itemDTO = new ItemMasterDTO();
	  try {
		  List<ItemMaster> items = itemMasterDao.findByItemCode(itemCode);
		  ItemMaster item = new ItemMaster();
		  if(!items.isEmpty()) {
			  item = items.get(0);
		  }

		  
		  	itemDTO = prepareItemMasterDTO(item);
			
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  
	  return itemDTO;
	  
	  }
	

	  /*
	   * @Param itemMasterDTO
	   * 
	   * Method for saving item master
	   * 
	   * @Return ItemMasterDTO
	   */
	@Override
	public ResponseDetails itemMasterSave(ItemMasterDTO itemMasterDTO) {
		ItemMaster saveSuccees = new ItemMaster();
		try {
			ItemMaster itemEntity = new ItemMaster(); 
			
			//item code auto generation start
			/*String itemCode = "";
			String categoryFirst = "";
			
			if(itemMasterDTO.getCategoryId()!=null) {
				if(itemMasterDTO.getCategoryId().getCategoryName()!=null) {
					categoryFirst = itemMasterDTO.getCategoryId().getCategoryName().substring(0, 1);
				}
			}
			
			Long count = itemMasterDao.count();
			if(itemMasterDTO.getCategoryId()!=null) {
				if(itemMasterDTO.getCategoryId()!=null) {
					itemCode = categoryFirst+"-000"+(count+1);
				}
			}else {
				itemCode = "NA";
			}
			//item code auto generation end
			 
			 */
//			itemEntity.setItemCode(itemCode);
			itemEntity.setItemCode(itemMasterDTO.getItemCode());
			
			itemEntity.setBaseUom(itemMasterDTO.getBaseUom());
			itemEntity.setCategory(itemMasterDTO.getCategory());
			itemEntity.setConversionPurchase(itemMasterDTO.getConversionPurchase());
			itemEntity.setCustMetalGrade(itemMasterDTO.getCustMetalGrade());
			itemEntity.setDespatching(itemMasterDTO.getDespatching());
			itemEntity.setExciseClassification(itemMasterDTO.getExciseClassification());
			itemEntity.setHeat_treatment(itemMasterDTO.getHeat_treatment());
			itemEntity.setIsActive(itemMasterDTO.getIsActive());
			itemEntity.setIsLocked(itemMasterDTO.getIsActive());
			itemEntity.setIssueUom(itemMasterDTO.getIssueUom());
			itemEntity.setDepartment("purchase");
			
			itemEntity.setItemName(itemMasterDTO.getItemName());
			
			if(itemMasterDTO.getMaximum()!=null)
				itemEntity.setMaximum(itemMasterDTO.getMaximum());
			else
				itemEntity.setMaximum(0.0);
			
			if(itemMasterDTO.getMinimum()!=null)
				itemEntity.setMinimum(itemMasterDTO.getMinimum());
			else
				itemEntity.setMinimum(0.0);
			
			itemEntity.setMouldProcess(itemMasterDTO.getMouldProcess());
			itemEntity.setPurchaseType(itemMasterDTO.getPurchaseType());
			itemEntity.setPurchaseUom(itemMasterDTO.getPurchaseUom());
			itemEntity.setRemarks(itemMasterDTO.getRemarks());
			
			if(itemMasterDTO.getReorder()!=null)
				itemEntity.setReorder(itemMasterDTO.getReorder());
			else
				itemEntity.setReorder(0.0);
			
			itemEntity.setSupply_condition(itemMasterDTO.getSupply_condition());
			itemEntity.setBOM(itemMasterDTO.getBom());
			
			itemEntity.setBarCode(itemMasterDTO.getBarCode());
//			itemEntity.setSapCode(itemMasterDTO.getSapCode());
			itemEntity.setHsCode(itemMasterDTO.getHsCode());
			
			if(itemMasterDTO.getWeightInKgs()!=null)
				itemEntity.setWeightInKgs(itemMasterDTO.getWeightInKgs());
			else
				itemEntity.setWeightInKgs(0.0);
			
			if(itemMasterDTO.getProdBatchSizeMax()!=null)
				itemEntity.setProdBatchSizeMax(itemMasterDTO.getProdBatchSizeMax());
			else
				itemEntity.setProdBatchSizeMax(0.0);
			
			if(itemMasterDTO.getProdBatchSizeMin()!=null)
				itemEntity.setProdBatchSizeMin(itemMasterDTO.getProdBatchSizeMin());
			else
				itemEntity.setProdBatchSizeMin(0.0);
			
			itemEntity.setSupply_condition(itemMasterDTO.getSupply_condition());
//			itemEntity.setProdnMetalGrade(itemMasterDTO.getProdnMetalGrade());
			if(itemMasterDTO.getCasting_wt()!=null)
				itemEntity.setCasting_wt(itemMasterDTO.getCasting_wt());
			else
				itemEntity.setCasting_wt(0.0);
			
			if(itemMasterDTO.getMachined_wt()!=null)
				itemEntity.setMachined_wt(itemMasterDTO.getMachined_wt());
			else
				itemEntity.setMachined_wt(0.0);
			
			if(itemMasterDTO.getBoughtOutWt()!=null)
				itemEntity.setBoughtOutWt(itemMasterDTO.getBoughtOutWt());
			else
				itemEntity.setBoughtOutWt(0.0);
			
			if(itemMasterDTO.getUpdatedPrice()!=null)
				itemEntity.setUpdatedPrice(itemMasterDTO.getUpdatedPrice());
			else
				itemEntity.setUpdatedPrice(0.0);
			
			itemEntity.setCoreMakingProcess(itemMasterDTO.getCoreMakingProcess());
			
			if(itemMasterDTO.getVendorCode().getVendorId()!=null) {
				itemEntity.setVendorCode(String.valueOf(itemMasterDTO.getVendorCode().getVendorId()));
			}
			
			Category category = new Category();
			SubCategory subCategory = new SubCategory();
			
			if(itemMasterDTO.getCategoryId()!=null && itemMasterDTO.getCategoryId().getCategoryId()!=null) {
				Optional<Category> categoryO = categoryRepo.findById(itemMasterDTO.getCategoryId().getCategoryId());
				if(categoryO.isPresent()) {
					category = categoryO.get();
					
					itemEntity.setCategoryId(category);
				}
			}
			if(itemMasterDTO.getSubCategoryId()!=null && itemMasterDTO.getSubCategoryId().getSubCategoryId()!=null) {
				Optional<SubCategory> subCategoryO = subCategoryRepo.findById(itemMasterDTO.getSubCategoryId().getSubCategoryId());
				if(subCategoryO.isPresent()) {
					subCategory = subCategoryO.get();
					
					itemEntity.setSubCategoryId(subCategory);
				}
			}
			
			
			itemEntity.setCategoryId2(itemMasterDTO.getCategoryId().getCategoryId());
			itemEntity.setSubCategoryId2(itemMasterDTO.getSubCategoryId().getSubCategoryId());
			
			List<ItemMaster> itemByNameList = itemMasterDao.findByItemName(itemMasterDTO.getItemName());
			
			List<ItemMaster> itemMasterByIdList = itemMasterDao.findByItemCode(itemMasterDTO.getItemCode());
			
			if(itemByNameList.isEmpty() || itemMasterByIdList.isEmpty()) {
				
				if(itemByNameList.isEmpty()) {
					saveSuccees=itemMasterDao.save(itemEntity);
				}
				
				
			}
	
			if(saveSuccees!=null) {
				ItemCategorySubCategoryMap categoryItemMap = new ItemCategorySubCategoryMap();
				categoryItemMap.setCategoryId(String.valueOf(itemMasterDTO.getCategoryId().getCategoryId()));
				categoryItemMap.setIsActive(1);
				categoryItemMap.setItemCode(String.valueOf(saveSuccees.getId()));
				
				if(itemMasterDTO.getSubCategoryId().getSubCategoryId()!=null)
					categoryItemMap.setSubCategoryId(String.valueOf(itemMasterDTO.getSubCategoryId().getSubCategoryId()));
				
				categoryMapRepo.save(categoryItemMap);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(saveSuccees!=null) {
			return new ResponseDetails(new Date(), "'"+itemMasterDTO.getItemName()+"' added.", itemMasterDTO.toString(), 200);
		}else {
			return new ResponseDetails(new Date(),"Sorry '"+itemMasterDTO.getItemName()+"' already exit.", null);
		}
		
	}
	
	/*
	 * @Param itemMasterDTO
	 * 
	 * Method for update item master
	 * 
	 * @Return ItemMasterDTO
	 */
	@Override
	public ItemMasterDTO itemMasterUpdate(ItemMasterDTO itemMasterDTO) {

		try {
			ItemMaster itemEntity = itemMasterDao.findById(itemMasterDTO.getId()).get(); 
			
			itemEntity.setBaseUom(itemMasterDTO.getBaseUom());
			itemEntity.setCategory(itemMasterDTO.getCategory());
			itemEntity.setConversionPurchase(itemMasterDTO.getConversionPurchase());
			itemEntity.setCustMetalGrade(itemMasterDTO.getCustMetalGrade());
			itemEntity.setDespatching(itemMasterDTO.getDespatching());
			itemEntity.setExciseClassification(itemMasterDTO.getExciseClassification());
			itemEntity.setHeat_treatment(itemMasterDTO.getHeat_treatment());
			itemEntity.setIsActive(1);
			itemEntity.setIsLocked(itemMasterDTO.getIsActive());
			itemEntity.setIssueUom(itemMasterDTO.getIssueUom());
			itemEntity.setItemCode(itemMasterDTO.getItemCode());
			itemEntity.setItemName(itemMasterDTO.getItemName());
			
			if(itemMasterDTO.getMaximum()!=null)
				itemEntity.setMaximum(itemMasterDTO.getMaximum());
			else
				itemEntity.setMaximum(0.0);
			
			if(itemMasterDTO.getMinimum()!=null)
				itemEntity.setMinimum(itemMasterDTO.getMinimum());
			else
				itemEntity.setMinimum(0.0);
			
			itemEntity.setMouldProcess(itemMasterDTO.getMouldProcess());
			itemEntity.setPurchaseType(itemMasterDTO.getPurchaseType());
			itemEntity.setPurchaseUom(itemMasterDTO.getPurchaseUom());
			itemEntity.setRemarks(itemMasterDTO.getRemarks());
			
			if(itemMasterDTO.getReorder()!=null)
				itemEntity.setReorder(itemMasterDTO.getReorder());
			else
				itemEntity.setReorder(0.0);
			itemEntity.setSupply_condition(itemMasterDTO.getSupply_condition());

			itemMasterDao.save(itemEntity);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return itemMasterDTO;
	}

	/*
	 * @Param itemCode
	 * 
	 * Method for delete item 
	 * 
	 */
	@Override
	public ResponseDetails deleteItemMasterById(int itemCode) {
		itemMasterDao.deleteById(itemCode);
		return new ResponseDetails(new Date(), "Deleted" , null);
	}

	
	/*
	 * @Param id
	 * 
	 * Method for soft delete item
	 * 
	 * @Return ItemMaster
	 * 
	 */
	@Override
	public ItemMasterDTO softDeleteItem(Integer id) {
	
		ItemMaster item = itemMasterDao.findById(id).get();
		item.setIsActive(0);
		ItemMaster itemEntity = itemMasterDao.save(item);
		ItemMasterDTO itemDTO = prepareItemMasterDTO(itemEntity);
		return itemDTO;
	}

	@Override
	public ItemMasterDTO prepareItemMasterDTO(ItemMaster item) {
	
		ItemMasterDTO itemDTO = new ItemMasterDTO();
		
		itemDTO.setId(item.getId());
		itemDTO.setBaseUom(item.getBaseUom());
		itemDTO.setCategory(item.getCategory());
		itemDTO.setConversionPurchase(item.getConversionPurchase());
		itemDTO.setCustMetalGrade(item.getCustMetalGrade());
		itemDTO.setDespatching(item.getDespatching());
		itemDTO.setExciseClassification(item.getExciseClassification());
		itemDTO.setHeat_treatment(item.getHeat_treatment());
		itemDTO.setIsActive(1);
		itemDTO.setIsLocked(item.getIsActive());
		itemDTO.setIssueUom(item.getIssueUom());
		itemDTO.setItemCode(item.getItemCode());
		itemDTO.setItemName(item.getItemName());
		if(item.getMaximum()!=null)
			itemDTO.setMaximum(item.getMaximum());
		else
			itemDTO.setMaximum(0.0);
		if(item.getMinimum()!=null)
			itemDTO.setMinimum(item.getMinimum());
		else
			itemDTO.setMinimum(0.0);
		itemDTO.setMouldProcess(item.getMouldProcess());
		itemDTO.setPurchaseType(item.getPurchaseType());
		itemDTO.setPurchaseUom(item.getPurchaseUom());
		itemDTO.setRemarks(item.getRemarks());
		if(item.getReorder()!=null)
			itemDTO.setReorder(item.getReorder());
		itemDTO.setSupply_condition(item.getSupply_condition());
		
		itemDTO.setHsCode(item.getHsCode());
		itemDTO.setBarCode(item.getBarCode());
		itemDTO.setProdBatchSizeMax(item.getProdBatchSizeMax());
		itemDTO.setProdBatchSizeMin(item.getProdBatchSizeMin());
		if(item.getCasting_wt()!=null)
			itemDTO.setCasting_wt(item.getCasting_wt());
		else
			itemDTO.setCasting_wt(0.0);
		if(item.getMachined_wt()!=null)
			itemDTO.setMachined_wt(item.getMachined_wt());
		else
			itemDTO.setMachined_wt(0.0);
		
		UomMaster baseUom = new UomMaster();
		UomMaster purchaseUom = new UomMaster();
		UomMaster issueUom = new UomMaster();
		
		if(item.getBaseUom()!=null && !item.getBaseUom().isEmpty() && !item.getBaseUom().equals("null")) {
			Optional<UomMaster> uomO = uomRepo.findById(Integer.valueOf(item.getBaseUom()));
			if(uomO.isPresent()) {
				UomMaster uom = uomO.get();
				baseUom.setUomDescription(uom.getUomDescription());
				baseUom.setUomId(uom.getUomId());
			}
		}
		
		if(item.getPurchaseUom()!=null && !item.getPurchaseUom().isEmpty() && !item.getPurchaseUom().equals("null")) {
			Optional<UomMaster> uomO = uomRepo.findById(Integer.valueOf(item.getPurchaseUom()));
			if(uomO.isPresent()) {
				UomMaster uom = uomO.get();
				purchaseUom.setUomDescription(uom.getUomDescription());
				purchaseUom.setUomId(uom.getUomId());
			}
		}
		
		if(item.getIssueUom()!=null && !item.getIssueUom().isEmpty() && !item.getIssueUom().equals("null")) {
			Optional<UomMaster> uomO = uomRepo.findById(Integer.valueOf(item.getIssueUom()));
			if(uomO.isPresent()) {
				UomMaster uom = uomO.get();
				issueUom.setUomDescription(uom.getUomDescription());
				issueUom.setUomId(uom.getUomId());
			}
		}
		
		itemDTO.setPurchaseUomDTO(purchaseUom);
		itemDTO.setBaseUomDTO(baseUom);
		itemDTO.setIssueUomDTO(issueUom);
		
		if(item.getBoughtOutWt()!=null)
			itemDTO.setBoughtOutWt(item.getBoughtOutWt());
		else
			itemDTO.setBoughtOutWt(0.0);
		if(item.getUpdatedPrice()!=null)
			itemDTO.setUpdatedPrice(item.getUpdatedPrice());
		else
			itemDTO.setUpdatedPrice(0.0);
		itemDTO.setCoreMakingProcess(item.getCoreMakingProcess());

		VendorForItemDTO vendorDTO = new VendorForItemDTO();
		if(item.getVendorCode()!=null && !item.getVendorCode().isEmpty()) {
			Optional<VendorMaster> vendorO = vendorDao.findById(Integer.valueOf(item.getVendorCode()));
			if(vendorO.isPresent()) {
				VendorMaster vendor = vendorO.get();
				vendorDTO.setVendorCode(vendor.getVendorCode());
				vendorDTO.setVendorId(vendor.getId());
				vendorDTO.setVendorName(vendor.getVendorName());
			}
		}
		itemDTO.setVendorCode(vendorDTO);
		itemDTO.setWeightInKgs(item.getWeightInKgs());
		
		itemDTO.setBom(item.getBOM());
		
		List<StoreDetails> storeList = storeDao.findByItemId(item.getId());
		Double availStock = 0.0;
		String unit = null;
		if(!storeList.isEmpty()) {
			for(StoreDetails sd : storeList) {
				availStock = availStock + sd.getQuantity();
				unit = sd.getUnit();
			}
		}
		itemDTO.setAvailStock(availStock);
		itemDTO.setUnit(unit);
		
		CategoryMappingDTO category = new CategoryMappingDTO();
		SubCategoryForMappingDTO subCategory = new SubCategoryForMappingDTO();
		
		List<ItemCategorySubCategoryMap> list = categoryMapRepo.findByItemId(String.valueOf(item.getId()));
		ItemCategorySubCategoryMap categoryMap = new ItemCategorySubCategoryMap();
		if(!list.isEmpty()) {
			categoryMap = list.get(0);
		}
		
		try {
			SubCategory subCategoryEntity = new SubCategory();
			
			if(categoryMap.getSubCategoryId()!=null) {
				Optional<SubCategory> subCategoryO = subCategoryRepo.findById(Integer.valueOf(categoryMap.getSubCategoryId()));
				if(subCategoryO.isPresent()) {
					subCategoryEntity = subCategoryO.get();
				}
			}
			
			 
			subCategory.setSubCategoryId(subCategoryEntity.getSubCategoryId());
			subCategory.setSubCategoryName(subCategoryEntity.getSubCategoryName());
			itemDTO.setSubCategoryId(subCategory);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Category categoryEntity = new Category();
			
			if(categoryMap.getCategoryId()!=null) {
				Optional<Category> categoryO = categoryRepo.findById(Integer.valueOf(categoryMap.getCategoryId()));
				if(categoryO.isPresent()) {
					categoryEntity = categoryO.get();
				}
			}
			
			category.setCategoryId(categoryEntity.getCategoryId());
			category.setCategoryName(categoryEntity.getCategoryName());
			itemDTO.setCategoryId(category);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return itemDTO;
	}

	@Override
	public ItemMaster prepraeItemMasterEntity(ItemMasterDTO itemMasterDTO) {
		
		ItemMaster itemEntity = new ItemMaster();
		
		if(itemMasterDTO.getId()!=null) {
			Optional<ItemMaster> itemEntityO = itemMasterDao.findById(itemMasterDTO.getId());
			if(itemEntityO.isPresent()) {
				itemEntity = itemEntityO.get();
			}
		}
		
		itemEntity.setBaseUom(itemMasterDTO.getBaseUom());
		itemEntity.setCategory(itemMasterDTO.getCategory());
		itemEntity.setConversionPurchase(itemMasterDTO.getConversionPurchase());
		itemEntity.setCustMetalGrade(itemMasterDTO.getCustMetalGrade());
		itemEntity.setDespatching(itemMasterDTO.getDespatching());
		itemEntity.setExciseClassification(itemMasterDTO.getExciseClassification());
		itemEntity.setHeat_treatment(itemMasterDTO.getHeat_treatment());
		itemEntity.setIsActive(1);
		itemEntity.setIsLocked(itemMasterDTO.getIsActive());
		itemEntity.setIssueUom(itemMasterDTO.getIssueUom());
		itemEntity.setItemCode(itemMasterDTO.getItemCode());
		itemEntity.setItemName(itemMasterDTO.getItemName());
		itemEntity.setMaximum(itemMasterDTO.getMaximum());
		itemEntity.setMinimum(itemMasterDTO.getMinimum());
		itemEntity.setMouldProcess(itemMasterDTO.getMouldProcess());
		itemEntity.setPurchaseType(itemMasterDTO.getPurchaseType());
		itemEntity.setPurchaseUom(itemMasterDTO.getPurchaseUom());
		itemEntity.setRemarks(itemMasterDTO.getRemarks());
		itemEntity.setReorder(itemMasterDTO.getReorder());
		itemEntity.setSupply_condition(itemMasterDTO.getSupply_condition());
		
		itemEntity.setUpdatedPrice(itemMasterDTO.getUpdatedPrice());
		itemEntity.setBoughtOutWt(itemMasterDTO.getBoughtOutWt());
		itemEntity.setCasting_wt(itemMasterDTO.getCasting_wt());
		itemEntity.setMachined_wt(itemMasterDTO.getMachined_wt());
		itemEntity.setMouldProcess(itemMasterDTO.getMouldProcess());
		
		return itemEntity;
	}

	@Override
	public ItemMasterDTO findByItemId(Integer itemId) {
		
		Optional<ItemMaster> itemEntityO = itemMasterDao.findById(itemId);
		ItemMaster item = new ItemMaster();
		if(itemEntityO.isPresent()) {
			item = itemEntityO.get();
		}
		ItemMasterDTO itemDTo = prepareItemMasterDTO(item);
		return itemDTo;
	}

	@Override
	public List<ItemMasterDTO> getallitemlistByDepartment(String department) {
		List<ItemMasterDTO> itemMasterDTOs = new ArrayList<>();
		try {
			List<ItemMaster> itemEntity = itemMasterDao.findByDepartmentAndIsActive(department, 1); //For fetching active items departmnetwise
			for(ItemMaster item : itemEntity) {
				
				ItemMasterDTO itemDTO = new ItemMasterDTO();
				
				itemDTO = prepareItemMasterDTO(item);
				
				itemMasterDTOs.add(itemDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return itemMasterDTOs;
	}


	/*
	 * public void deleteUserById(Long id){ userRepository.delete(id); }
	 */
}
