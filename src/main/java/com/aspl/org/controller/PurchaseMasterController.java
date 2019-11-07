package com.aspl.org.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.dto.CategoryDTO;
import com.aspl.org.dto.HsnMasterDTO;
import com.aspl.org.dto.ItemCategoryMappingDTO;
import com.aspl.org.dto.ItemMasterDTO;
import com.aspl.org.dto.LandedPriceDTO;
import com.aspl.org.dto.SubCategoryDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.ItemCategorySubCategoryMap;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.SubCategory;
import com.aspl.org.entity.UomMaster;
import com.aspl.org.service.CategoryService;
import com.aspl.org.service.HsnMasterService;
import com.aspl.org.service.ItemCategorySubCategoryMappingService;
import com.aspl.org.service.ItemMasterService;
import com.aspl.org.service.LandedPriceService;
import com.aspl.org.service.SubCategoryService;
import com.aspl.org.service.UomMasterService;

@RestController
@RequestMapping("purchasemaster/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseMasterController {
	
	public static final Logger logger = LoggerFactory.getLogger(PurchaseMasterController.class);
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	HsnMasterService hsnService;
	
	@Autowired
	ItemCategorySubCategoryMappingService categoryMappingService;	
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired 
	ItemMasterService itemMasterService;
	
	@Autowired LandedPriceService landedPriceService;
	
	@Autowired
	UomMasterService uomService;
	
	//  *********************************** For category ******************************************
	@GetMapping("getAllCategory")
	public List<CategoryDTO> getAllCategory() {
		return categoryService.getAllCategory();
	}
	
	@GetMapping("getCategoryById/{categoryId}")
	public CategoryDTO getCategoryById(@PathVariable("categoryId") Integer categoryId) {
		return categoryService.getCategoryByCategoryId(categoryId);
	}
	
	@GetMapping("getCategoryBySubCategory/{subCategoryId}")
	public CategoryDTO getCategoryBySubCategory(@PathVariable("subCategoryId") Integer subCategoryId) {
		return categoryService.getCategoryBySubCategory(String.valueOf(subCategoryId));
	}
	
	@GetMapping("getCategoryByName/{categoryName}")
	public CategoryDTO getCategoryByName(@PathVariable("categoryName") String categoryName) {
		return categoryService.getCategoryByName(categoryName);
	}
	
	@PostMapping("saveCategory")
	public CategoryDTO saveCategory(@RequestBody CategoryDTO category) {
		return categoryService.saveCategory(category);
	}
	
	@PutMapping("updateCategory")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO category) {
		return categoryService.updateCategory(category);
	}
	
	@DeleteMapping("permDeleteCategory/{categoryId}")
	public Category deleteCategory(@PathVariable("categoryId") Integer categoryId) {
		return categoryService.permDeleteCategory(categoryId);
	}
	
	@PutMapping("softDeleteCategory/{categoryId}")
	public Category softDeleteCategory(@PathVariable("categoryId") Integer categoryId) {
		return categoryService.softDeleteCategory(categoryId);
	}
	
	//*********************************** For HSN Master ******************************************
	
	@GetMapping("getAllHsnMaster")
//	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
	public List<HsnMasterDTO> getAllHsnMaster(){
		return hsnService.getAllHsnMaster();
	}
	
	@GetMapping("getHsnMasterByHsnId/{hsnId}")
	public HsnMasterDTO getHsnMasterById(@PathVariable("hsnId") Integer hsnId) {
		return hsnService.getHsnMasterById(hsnId);
	}
	
	@GetMapping("getHsnMasterByItemId/{itemId}")
	public HsnMasterDTO getHsnMasterByItemId(@PathVariable("itemId") Integer itemId) {
		return hsnService.getHsnMasterByItemId(itemId);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("saveHsnMaster")
	public HsnMasterDTO saveHsnMaster(@RequestBody HsnMasterDTO hsnMasterDTO) {
		return hsnService.saveHsnMaster(hsnMasterDTO);
	}
	
	@PutMapping("updateHsnMaster")
	public HsnMasterDTO updateHsnMaster(@RequestBody HsnMasterDTO hsnMasterDTO) {
		return hsnService.updateHsnMaster(hsnMasterDTO);
	}
	
	@PutMapping("softDeleteHsnMaster/{hsnId}")
	public void softDeleteHsnMaster(@PathVariable("hsnId") Integer hsnId) {
		hsnService.softDeleteHsnMaster(hsnId);
	}
	
	@DeleteMapping("permDeleteHsnMapping/{hsnId}")
	public void permDeleteHsnMaster(@PathVariable("hsnId") Integer hsnId) {
		hsnService.permDeleteHsnMaster(hsnId);
	}
	
	//*********************************** For item category map ******************************************
	
	@GetMapping("getAllItemCatMap")
	public List<ItemCategoryMappingDTO> getAllItemCategoryMap(){
		List<ItemCategoryMappingDTO> itemCategorySubCtaegory = categoryMappingService.getAllItemCategorySubcategoryMapping();
		return itemCategorySubCtaegory;
	}
	
	@PostMapping("mapItemCategorySubcategory")
	public ItemCategoryMappingDTO mapItemCategorySubcategory(@RequestBody ItemCategoryMappingDTO itemCategoryMappingDTO) {
		return categoryMappingService.saveItemCategorySubcategory(itemCategoryMappingDTO);
	}
	
	@PutMapping("updateItemCategoryMapping")
	public ItemCategoryMappingDTO updateItemCategoryMapping(@RequestBody ItemCategoryMappingDTO itemCategoryMappingDTO) {
		return categoryMappingService.updateItemCategorySubcategory(itemCategoryMappingDTO);
	}
	
	@GetMapping("getMappingByItemCode/{itemCode}")
	public List<ItemCategoryMappingDTO> getMappingByItemCode(@PathVariable("itemCode") String itemCode) {
		return categoryMappingService.getItemCategoryMappingByItemId(itemCode);
	}
	
	@GetMapping("getMappingByCategory/{categoryId}")
	public List<ItemCategoryMappingDTO> getMappingByCategory(@PathVariable("categoryId") Integer categoryId) {
		return categoryMappingService.getItemCategoryMappingByCategory(categoryId);
	}
	
	@GetMapping("getMappingBySubCategory/{subCategoryId}")
	public List<ItemCategoryMappingDTO> getMappingBySubCategory(@PathVariable("subCategoryId") Integer subCategoryId) {
		return categoryMappingService.getItemCategoryMappingSubCategory(subCategoryId);
	}
	
	@PutMapping("softDeleteItemCategoryMapping/{mapingId}")
	public ItemCategorySubCategoryMap softDeleteItemCategoryMapping(@PathVariable("mapingId") Integer mapingId) {
		return categoryMappingService.softDeleteItemCategoryMapping(mapingId);
	}
	
	@DeleteMapping("permDeleteItemCategoryMapping/{mappingId}")
	public void permDeleteItemCategoryMapping(@PathVariable("mappingId") Integer mappingId) {
		categoryMappingService.permDeleteItemCategoryMapping(mappingId);
	}
	
	//*********************************** For Item Master ******************************************
	
	@PostMapping("/itemmstsave")
	public ResponseDetails itemmaster(@RequestBody ItemMasterDTO itemMaster){
		return itemMasterService.itemMasterSave(itemMaster);
	}
	
	@PutMapping("/updateItem")
	public ResponseDetails updateItemMaster(@RequestBody ItemMasterDTO itemMaster){
		return itemMasterService.itemmasterupdate(itemMaster);
	}
	
	@GetMapping("/getByCode/{itemCode}")
	public ItemMasterDTO getByCode(@PathVariable String itemCode) {
	  return itemMasterService.findByItemCode(itemCode);
	}
	
	@GetMapping("/getItemByDepartment/{department}")
	public List<ItemMasterDTO> getByItemByDepartment(@PathVariable String department) {
	  return itemMasterService.getallitemlistByDepartment(department);
	}
	  
	@GetMapping("/getItemItemId/{itemId}")
	public ItemMasterDTO getItemByItemId(@PathVariable("itemId") Integer itemId) {
	  return itemMasterService.findByItemId(itemId);
	}
	 
	@GetMapping("/getByName/{itemName}")
	public ItemMasterDTO getByName(@PathVariable String itemName) {
	  return itemMasterService.findByItemName(itemName);
	}
	  
	@GetMapping("/getItemById/{itemId}")
	public ItemMasterDTO getByName(@PathVariable Integer itemId) {
	  return itemMasterService.findByItemId(itemId);
	}
	  
	@GetMapping(path="/getallitemlist")
	public List<ItemMasterDTO> getallitemlist() {
		return  itemMasterService.getallitemlist();
	}
	
	@PutMapping("/itemMasterUpdateByCode/{itemCode}")
	public ItemMasterDTO updateItemById( @RequestBody ItemMasterDTO itemMaster) {
		itemMasterService.itemMasterUpdate(itemMaster);
		return itemMaster;
	}
	
	@DeleteMapping("/deleteItemById/{itemCode}")
	public String deleteUser(@PathVariable("itemCode") String itemCode) {
		logger.info("Fetching & Deleting User with id {}", itemCode);
			
		ItemMasterDTO itemMaster = itemMasterService.findByItemCode(itemCode);
		if (itemMaster == null) {
			logger.error("Unable to delete. User with id {} not found.", itemCode);
			return "Unable to delete. User with id " + itemCode + " not found.";
		}
		itemMasterService.deleteItemMasterById(itemMaster.getId());
		//("itemMaster: "+itemMaster.toString());
		return "delete. User with itemCode " + itemCode;
	}
	
	@PutMapping("softDeleteItem/{id}")
	public ItemMasterDTO softDeleteItem(@PathVariable("id") Integer Id) {
		return itemMasterService.softDeleteItem(Id);
	}
	
	// *********************************** For Landed Price ******************************************
	@PostMapping("/landedPriceSave")
	public ResponseDetails landedprice(@RequestBody LandedPriceDTO landedPrice){
		
		landedPriceService.landedPriceSave(landedPrice);
		
		return new ResponseDetails(new Date(), "'"+landedPrice+"' added.", null);
	}
	
	
	  @GetMapping("/getLandedPriceByItemId/{itemId}")
	  public List<LandedPriceDTO> getByCode(@PathVariable Integer itemId) {
		  return landedPriceService.getLandedPriceForItem(itemId);
		  
	  }
	  
	  @GetMapping("/getLandedPriceByCategoryId/{categoryId}")
	  public List<LandedPriceDTO> getLandedPriceByCategoryId(@PathVariable("categoryId") Integer categoryId) {
		  return landedPriceService.getLandedPriceByCategoryId(categoryId);
		  
	  }
	  
	  @GetMapping("/getLandedPriceBySubCategoryId/{subCategoryId}")
	  public List<LandedPriceDTO> getLandedPriceBySubCategoryId(@PathVariable("subCategoryId") Integer subCategoryId) {
		  return landedPriceService.getLandedPriceBySubCategoryId(subCategoryId);
		  
	  }
	  
	@GetMapping(path="/getAllLandedPrice", produces = "application/json")
	public List<LandedPriceDTO> getalllandedpricelist() {
		//("getallitemlist");
		return  landedPriceService.getallitemlist();
	}
	
	
	@PutMapping("/landedPriceUpdateByCode")
	public LandedPriceDTO updateItemById( @RequestBody LandedPriceDTO landedPrice) {

		landedPriceService.landedPriceUpdate(landedPrice);
		return landedPrice;
	}
	

	@DeleteMapping("/permDeleteLandedPriceById/{lanedPriceId}")
	public String deleteUser(@PathVariable("lanedPriceId") Integer lanedPriceId) {
			landedPriceService.permDeleteLandedPriceById(lanedPriceId);
			//("itemMaster: "+itemMaster.toString());
			return "delete. User with itemCode " + lanedPriceId;
		}
	
	@GetMapping("getLandedPriceByPriceId/{landedPriceId}")
	public LandedPriceDTO getLandedPriceByPriceId(@PathVariable("landedPriceId") Integer landedPriceId) {
		return landedPriceService.getLandedPriceById(landedPriceId);
	}
	
	
	//*********************************** For UOM Master ******************************************
	
	@GetMapping("getAllUomMaster")
	public List<UomMaster> getAllActiveUomMaster(){
		return uomService.getAllUomMaster();
	}
	
	@PostMapping("saveUomMaster")
	public UomMaster saveUomMaster(@RequestBody UomMaster uomMaster) {
		return uomService.saveUom(uomMaster);
	}
	
	@PutMapping("updateUomMaster")
	public UomMaster updateUomMaster(@RequestBody UomMaster uomMaster) {
		return uomService.updateUomMaster(uomMaster);
	}
	
	@DeleteMapping("permDeleteUomMaster/{uomId}")
	public void permDeleteUomMaster(@PathVariable("uomId") Integer uomId) {
		uomService.permDeleteUom(uomId);
	}
	
	@PutMapping("softDeleteUomMaster/{uomId}")
	public UomMaster softDeleteUomMaster(@PathVariable("uomId") Integer uomId) {
		return uomService.softDeleteUom(uomId);
	}
	
	@GetMapping("getUomMasterById/{uomId}")
	public UomMaster getUomMasterById(@PathVariable("uomId") Integer uomId) {
		return uomService.getUomByUomId(uomId);
	}
	
	@GetMapping("getUomMasterByUomCode/{uomCode}")
	public UomMaster getUomMasterByUomCode(@PathVariable("uomCode") String uomCode) {
		return uomService.getUomByUomCode(uomCode);
	}
	
	
	//*********************************** For sub-category ******************************************
	
	@GetMapping("getAllSubCategory")
	public List<SubCategoryDTO> getAllSubCategory(){
		return subCategoryService.getAllSubCategory();
	}
	
	@GetMapping("getSubCategoryById/{subCategoryID}")
	public SubCategoryDTO getAllSubCategoryBySubCategoryId(@PathVariable("subCategoryID") String subCategoryID){
		return subCategoryService.getSubCategoryBySubCategoryId(Integer.valueOf(subCategoryID));
	}
	
	@GetMapping("getSubCategoryBySubCategoryName/{subCategoryName}")
	public SubCategoryDTO getAllSubCategoryBySubCategoryName(@PathVariable("subCategoryName") String subCategoryName){
		return subCategoryService.getSubCategoryBySubCategoryName(subCategoryName);
	}
	
	@GetMapping("getSubCategoryByCategory/{categoryID}")
	public List<SubCategoryDTO> getAllSubCategoryByCategory(@PathVariable("categoryID") String subCategoryID){
		return subCategoryService.getSubCategoryByCategory(subCategoryID);
	}
	
	@PostMapping("saveSubCategory")
	public SubCategoryDTO saveSubCategory(@RequestBody SubCategoryDTO subCategoryDTO) {
		return subCategoryService.saveSubCategory(subCategoryDTO);
	}
	
	@PutMapping("updateSubCategory")
	public SubCategoryDTO updateSubCategory(@RequestBody SubCategoryDTO subCategoryDTO) {
		return subCategoryService.updateSubCategory(subCategoryDTO);
	}
	
	@PutMapping("softDeleteSubCategory")
	public SubCategory sofDeleteSubCategory(@RequestBody String subCategoryId) {
		return subCategoryService.softDeleteSubCategory(subCategoryId);
	}
	
	@DeleteMapping("permDeleteSubCategory/{subCategoryId}")
	public String permDeleteSubCategory(@PathVariable("subCategoryId") String subCategoryId) {
		return subCategoryService.permDeleteSubCategory(subCategoryId);
	}
	
}
