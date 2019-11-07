package com.aspl.org.dto;

import java.io.Serializable;

import com.aspl.org.entity.UomMaster;

public class ItemMasterDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String itemCode;
	private String itemName;
	private String category;
	private CategoryMappingDTO categoryId;
	private SubCategoryForMappingDTO subCategoryId;
	
	private String remarks;
	private String despatching;
	private Double weightInKgs;
	private String exciseClassification;
	
	private String sapCode;
	private String hsCode;
	private String barCode;
	private String binNo;
	private Double quantity;
	private Double rate;
	private String baseUom;
	private String issueUom;
	private String conversionSales;
	private Double reorder;
	private Double maximum;
	private Double minimum;
	private String grade;
	private String leadtime;
	private String type;
	private String purchaseUom;
	private String conversionPurchase;
	private String purchaseType;
	private String recycle_time;
	private Double recycleQty;
	private String scrap;
	private String custMetalGrade;
	private String prodnMetalGrade;
	private Double prodBatchSizeMin;
	private Double prodBatchSizeMax;
	private String mouldProcess;
	private String heat_treatment;
	private String supply_condition;
	private Double casting_wt;
	private Double machined_wt;
	private Integer isActive;
	private Integer isLocked;
	private Integer bom;
	
	private Double availStock;
	private Double boughtOutWt;
	private Double updatedPrice;
	private String coreMakingProcess;
	
	private String department; // For distinguishing between purchase and sales
	
	private VendorForItemDTO vendorCode;
	
	private UomMaster baseUomDTO;
	private UomMaster purchaseUomDTO;
	private UomMaster issueUomDTO;
	
	private String unit;
	private HsnMasterDTO hsnMaster;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public CategoryMappingDTO getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(CategoryMappingDTO categoryId) {
		this.categoryId = categoryId;
	}
	public SubCategoryForMappingDTO getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(SubCategoryForMappingDTO subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDespatching() {
		return despatching;
	}
	public void setDespatching(String despatching) {
		this.despatching = despatching;
	}
	public Double getWeightInKgs() {
		return weightInKgs;
	}
	public void setWeightInKgs(Double weightInKgs) {
		this.weightInKgs = weightInKgs;
	}
	public String getExciseClassification() {
		return exciseClassification;
	}
	public void setExciseClassification(String exciseClassification) {
		this.exciseClassification = exciseClassification;
	}
	public String getSapCode() {
		return sapCode;
	}
	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
	}
	public String getHsCode() {
		return hsCode;
	}
	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getBinNo() {
		return binNo;
	}
	public void setBinNo(String binNo) {
		this.binNo = binNo;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public String getBaseUom() {
		return baseUom;
	}
	public void setBaseUom(String baseUom) {
		this.baseUom = baseUom;
	}
	public String getIssueUom() {
		return issueUom;
	}
	public void setIssueUom(String issueUom) {
		this.issueUom = issueUom;
	}
	public String getConversionSales() {
		return conversionSales;
	}
	public void setConversionSales(String conversionSales) {
		this.conversionSales = conversionSales;
	}
	public Double getReorder() {
		return reorder;
	}
	public void setReorder(Double reorder) {
		this.reorder = reorder;
	}
	public Double getMaximum() {
		return maximum;
	}
	public void setMaximum(Double maximum) {
		this.maximum = maximum;
	}
	public Double getMinimum() {
		return minimum;
	}
	public void setMinimum(Double minimum) {
		this.minimum = minimum;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getLeadtime() {
		return leadtime;
	}
	public void setLeadtime(String leadtime) {
		this.leadtime = leadtime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPurchaseUom() {
		return purchaseUom;
	}
	public void setPurchaseUom(String purchaseUom) {
		this.purchaseUom = purchaseUom;
	}
	public String getConversionPurchase() {
		return conversionPurchase;
	}
	public void setConversionPurchase(String conversionPurchase) {
		this.conversionPurchase = conversionPurchase;
	}
	public String getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	public String getRecycle_time() {
		return recycle_time;
	}
	public void setRecycle_time(String recycle_time) {
		this.recycle_time = recycle_time;
	}
	public Double getRecycleQty() {
		return recycleQty;
	}
	public void setRecycleQty(Double recycleQty) {
		this.recycleQty = recycleQty;
	}
	public String getScrap() {
		return scrap;
	}
	public void setScrap(String scrap) {
		this.scrap = scrap;
	}
	public String getCustMetalGrade() {
		return custMetalGrade;
	}
	public void setCustMetalGrade(String custMetalGrade) {
		this.custMetalGrade = custMetalGrade;
	}
	public String getProdnMetalGrade() {
		return prodnMetalGrade;
	}
	public void setProdnMetalGrade(String prodnMetalGrade) {
		this.prodnMetalGrade = prodnMetalGrade;
	}
	public Double getProdBatchSizeMin() {
		return prodBatchSizeMin;
	}
	public void setProdBatchSizeMin(Double prodBatchSizeMin) {
		this.prodBatchSizeMin = prodBatchSizeMin;
	}
	public Double getProdBatchSizeMax() {
		return prodBatchSizeMax;
	}
	public void setProdBatchSizeMax(Double prodBatchSizeMax) {
		this.prodBatchSizeMax = prodBatchSizeMax;
	}
	public String getMouldProcess() {
		return mouldProcess;
	}
	public void setMouldProcess(String mouldProcess) {
		this.mouldProcess = mouldProcess;
	}
	public String getHeat_treatment() {
		return heat_treatment;
	}
	public void setHeat_treatment(String heat_treatment) {
		this.heat_treatment = heat_treatment;
	}
	public String getSupply_condition() {
		return supply_condition;
	}
	public void setSupply_condition(String supply_condition) {
		this.supply_condition = supply_condition;
	}
	public Double getCasting_wt() {
		return casting_wt;
	}
	public void setCasting_wt(Double casting_wt) {
		this.casting_wt = casting_wt;
	}
	public Double getMachined_wt() {
		return machined_wt;
	}
	public void setMachined_wt(Double machined_wt) {
		this.machined_wt = machined_wt;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Integer getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(Integer isLocked) {
		this.isLocked = isLocked;
	}
	public Integer getBom() {
		return bom;
	}
	public void setBom(Integer bom) {
		this.bom = bom;
	}
	public Double getAvailStock() {
		return availStock;
	}
	public void setAvailStock(Double availStock) {
		this.availStock = availStock;
	}
	public Double getBoughtOutWt() {
		return boughtOutWt;
	}
	public void setBoughtOutWt(Double boughtOutWt) {
		this.boughtOutWt = boughtOutWt;
	}
	public Double getUpdatedPrice() {
		return updatedPrice;
	}
	public void setUpdatedPrice(Double updatedPrice) {
		this.updatedPrice = updatedPrice;
	}
	public String getCoreMakingProcess() {
		return coreMakingProcess;
	}
	public void setCoreMakingProcess(String coreMakingProcess) {
		this.coreMakingProcess = coreMakingProcess;
	}
	public VendorForItemDTO getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(VendorForItemDTO vendorCode) {
		this.vendorCode = vendorCode;
	}
	public UomMaster getBaseUomDTO() {
		return baseUomDTO;
	}
	public void setBaseUomDTO(UomMaster baseUomDTO) {
		this.baseUomDTO = baseUomDTO;
	}
	public UomMaster getPurchaseUomDTO() {
		return purchaseUomDTO;
	}
	public void setPurchaseUomDTO(UomMaster purchaseUomDTO) {
		this.purchaseUomDTO = purchaseUomDTO;
	}
	public UomMaster getIssueUomDTO() {
		return issueUomDTO;
	}
	public void setIssueUomDTO(UomMaster issueUomDTO) {
		this.issueUomDTO = issueUomDTO;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public HsnMasterDTO getHsnMaster() {
		return hsnMaster;
	}
	public void setHsnMaster(HsnMasterDTO hsnMaster) {
		this.hsnMaster = hsnMaster;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	

}
