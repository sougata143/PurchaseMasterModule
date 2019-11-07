package com.aspl.org.dto;

import java.util.Date;
import java.util.List;


import com.aspl.org.entity.ContactsDetails;
import com.fasterxml.jackson.annotation.JsonFormat;

public class VendorMasterDTO {

	private Integer id;
	private String vendorCode;
	private String vendorName;
	private String branch_office;
	private String hoCode;
	private String hoName;
	private String address1;
	private String address2;
	 
	private String city;
	private String state;
	private Integer stateCode;
	private String country;
	private String ledgerName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validationDate;
	private Integer pin;
	private String branchName;
	private String ifscCode;
	
	List<ContactsDetails> contactsDetails;
	/* private ContactsDetailsDTO contactsDetailsDTO; */
	private String gstNo;
	private String panNo;
	private String staxRegnNo;
	private String cexciseRegnNo;
	private String eccNo;
	private String rnge;
	private String division;
	private String commissionerate;
	private String impExpCode;
	private String binNo;
	private String ecgcNo;
	
	private Integer status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date ecgcDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date ecgcValidityDate;

	private String regnCumCode;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date regnCumCodeDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date regnCumValidityDate;
	private String regnCumCouncilName;

	private PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO;
	
	private DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO;
	
	private ReminderTermsMasterForVendorDTO ReminderTermsMasterForVendorDTO;
	
	private PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO;
	
	private ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO;
	
	private JurisdictionMasterForVendorDTO jurisdictionMasterForVendor;
	
	private String bankName;
	private String accountNo;
	private String insuranceType;
	private String amount;

	private Integer isisoSupplier;
	private Integer isbLocked;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getBranch_office() {
		return branch_office;
	}
	public void setBranch_office(String branch_office) {
		this.branch_office = branch_office;
	}
	public String getHoCode() {
		return hoCode;
	}
	public void setHoCode(String hoCode) {
		this.hoCode = hoCode;
	}
	public String getHoName() {
		return hoName;
	}
	public void setHoName(String hoName) {
		this.hoName = hoName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getStateCode() {
		return stateCode;
	}
	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLedgerName() {
		return ledgerName;
	}
	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}
	public Date getValidationDate() {
		return validationDate;
	}
	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public List<ContactsDetails> getContactsDetails() {
		return contactsDetails;
	}
	public void setContactsDetails(List<ContactsDetails> contactsDetails) {
		this.contactsDetails = contactsDetails;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getStaxRegnNo() {
		return staxRegnNo;
	}
	public void setStaxRegnNo(String staxRegnNo) {
		this.staxRegnNo = staxRegnNo;
	}
	public String getCexciseRegnNo() {
		return cexciseRegnNo;
	}
	public void setCexciseRegnNo(String cexciseRegnNo) {
		this.cexciseRegnNo = cexciseRegnNo;
	}
	public String getEccNo() {
		return eccNo;
	}
	public void setEccNo(String eccNo) {
		this.eccNo = eccNo;
	}
	public String getRnge() {
		return rnge;
	}
	public void setRnge(String rnge) {
		this.rnge = rnge;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getCommissionerate() {
		return commissionerate;
	}
	public void setCommissionerate(String commissionerate) {
		this.commissionerate = commissionerate;
	}
	public String getImpExpCode() {
		return impExpCode;
	}
	public void setImpExpCode(String impExpCode) {
		this.impExpCode = impExpCode;
	}
	public String getBinNo() {
		return binNo;
	}
	public void setBinNo(String binNo) {
		this.binNo = binNo;
	}
	public String getEcgcNo() {
		return ecgcNo;
	}
	public void setEcgcNo(String ecgcNo) {
		this.ecgcNo = ecgcNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getEcgcDate() {
		return ecgcDate;
	}
	public void setEcgcDate(Date ecgcDate) {
		this.ecgcDate = ecgcDate;
	}
	public Date getEcgcValidityDate() {
		return ecgcValidityDate;
	}
	public void setEcgcValidityDate(Date ecgcValidityDate) {
		this.ecgcValidityDate = ecgcValidityDate;
	}
	public String getRegnCumCode() {
		return regnCumCode;
	}
	public void setRegnCumCode(String regnCumCode) {
		this.regnCumCode = regnCumCode;
	}
	public Date getRegnCumCodeDate() {
		return regnCumCodeDate;
	}
	public void setRegnCumCodeDate(Date regnCumCodeDate) {
		this.regnCumCodeDate = regnCumCodeDate;
	}
	public Date getRegnCumValidityDate() {
		return regnCumValidityDate;
	}
	public void setRegnCumValidityDate(Date regnCumValidityDate) {
		this.regnCumValidityDate = regnCumValidityDate;
	}
	public String getRegnCumCouncilName() {
		return regnCumCouncilName;
	}
	public void setRegnCumCouncilName(String regnCumCouncilName) {
		this.regnCumCouncilName = regnCumCouncilName;
	}
	public PaymentTermsMasterforVendorDTO getPaymentTermsMasterforVendorDTO() {
		return paymentTermsMasterforVendorDTO;
	}
	public void setPaymentTermsMasterforVendorDTO(PaymentTermsMasterforVendorDTO paymentTermsMasterforVendorDTO) {
		this.paymentTermsMasterforVendorDTO = paymentTermsMasterforVendorDTO;
	}
	public DeliveryTermsMasterforVendorDTO getDeliveryTermsMasterforVendorDTO() {
		return deliveryTermsMasterforVendorDTO;
	}
	public void setDeliveryTermsMasterforVendorDTO(DeliveryTermsMasterforVendorDTO deliveryTermsMasterforVendorDTO) {
		this.deliveryTermsMasterforVendorDTO = deliveryTermsMasterforVendorDTO;
	}
	public ReminderTermsMasterForVendorDTO getReminderTermsMasterForVendorDTO() {
		return ReminderTermsMasterForVendorDTO;
	}
	public void setReminderTermsMasterForVendorDTO(ReminderTermsMasterForVendorDTO reminderTermsMasterForVendorDTO) {
		ReminderTermsMasterForVendorDTO = reminderTermsMasterForVendorDTO;
	}
	public PaymentMethodMasterforVendorDTO getPaymentMethodMasterforVendorDTO() {
		return paymentMethodMasterforVendorDTO;
	}
	public void setPaymentMethodMasterforVendorDTO(PaymentMethodMasterforVendorDTO paymentMethodMasterforVendorDTO) {
		this.paymentMethodMasterforVendorDTO = paymentMethodMasterforVendorDTO;
	}
	public ShippingMethodMasterforVendorDTO getShippingMethodMasterforVendorDTO() {
		return shippingMethodMasterforVendorDTO;
	}
	public void setShippingMethodMasterforVendorDTO(ShippingMethodMasterforVendorDTO shippingMethodMasterforVendorDTO) {
		this.shippingMethodMasterforVendorDTO = shippingMethodMasterforVendorDTO;
	}
	public JurisdictionMasterForVendorDTO getJurisdictionMasterForVendor() {
		return jurisdictionMasterForVendor;
	}
	public void setJurisdictionMasterForVendor(JurisdictionMasterForVendorDTO jurisdictionMasterForVendor) {
		this.jurisdictionMasterForVendor = jurisdictionMasterForVendor;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Integer getIsisoSupplier() {
		return isisoSupplier;
	}
	public void setIsisoSupplier(Integer isisoSupplier) {
		this.isisoSupplier = isisoSupplier;
	}
	public Integer getIsbLocked() {
		return isbLocked;
	}
	public void setIsbLocked(Integer isbLocked) {
		this.isbLocked = isbLocked;
	}
	
	
	
}
