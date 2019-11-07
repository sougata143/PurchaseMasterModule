package com.aspl.org.entity;

	import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


	@Entity
	@Table(name="Item_Master")
	//@JsonIgnoreProperties(value= {"password"})
	public class ItemMaster implements Serializable{
		
		private static final long serialVersionUID = 1L;
		 //generating item id 
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		@Column(name = "Item_Code", nullable = false)
		private String itemCode;
		@Column(name = "Item_Name", length = 45, nullable = false)
		private String itemName;
		@Column(name = "Category",length = 45, nullable = false, columnDefinition = "varchar(255) default ''" )
		private String category;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="category_id",insertable=false,updatable=false)
		private Category categoryId;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="sub_category_id",insertable=false,updatable=false)
		private SubCategory subCategoryId;
		
		@Column(name="category_id")
		private Integer categoryId2;
		
		@Column(name="sub_category_id")
		private Integer subCategoryId2;
		
		private String remarks;
		private String despatching;
		private Double weightInKgs;
		private String exciseClassification;
	/*
	 * private String chepter; private String heading; private String subHeading;
	 */
//		private String sapCode;
		private String hsCode;
		private String barCode;
//		private String binNo;
//		private Double quantity;
//		private Double rate;
		@Column(columnDefinition = "varchar(255) default ''")
		private String baseUom;
		private String issueUom;
		private String conversionSales;
		private Double reorder;
		private Double maximum;
		private Double minimum;
//		private String grade;
//		private String leadtime;
//		private String type;
		private String purchaseUom;
		private String conversionPurchase;
		private String purchaseType;
//		private String recycle_time;
//		private Double recycleQty;
//		private String scrap;
		private String custMetalGrade;
//		private String prodnMetalGrade;
		private Double prodBatchSizeMin;
		private Double prodBatchSizeMax;
		private String mouldProcess;
		private String heat_treatment;
		private String supply_condition;
		private Double casting_wt;
		private Double machined_wt;
		@Column(name="is_active",columnDefinition="smallint(11) default 1")
		private Integer isActive;
		@Column(name="is_locked",columnDefinition="smallint(11) default 0")
		private Integer isLocked;
		
		@Column(name="bom", columnDefinition = "smallint(11) default 1")
		private Integer BOM;
		private String vendorCode;
		private Double boughtOutWt;
		private Double updatedPrice;
		private String coreMakingProcess;
		
		private String department; // For distinguishing between purchase and sales
		
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

		public Category getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Category categoryId) {
			this.categoryId = categoryId;
		}

		public SubCategory getSubCategoryId() {
			return subCategoryId;
		}

		public void setSubCategoryId(SubCategory subCategoryId) {
			this.subCategoryId = subCategoryId;
		}

		public Integer getCategoryId2() {
			return categoryId2;
		}

		public void setCategoryId2(Integer categoryId2) {
			this.categoryId2 = categoryId2;
		}

		public Integer getSubCategoryId2() {
			return subCategoryId2;
		}

		public void setSubCategoryId2(Integer subCategoryId2) {
			this.subCategoryId2 = subCategoryId2;
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

		public String getCustMetalGrade() {
			return custMetalGrade;
		}

		public void setCustMetalGrade(String custMetalGrade) {
			this.custMetalGrade = custMetalGrade;
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

		public Integer getBOM() {
			return BOM;
		}

		public void setBOM(Integer bOM) {
			BOM = bOM;
		}

		public String getVendorCode() {
			return vendorCode;
		}

		public void setVendorCode(String vendorCode) {
			this.vendorCode = vendorCode;
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

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		
		
}
