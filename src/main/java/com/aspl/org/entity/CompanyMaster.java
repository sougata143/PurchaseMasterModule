package com.aspl.org.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="companymaster")
public class CompanyMaster {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer companyID;
	@Column(name="companyname")
	private String companyName;
	private String regdOfficeAddr;
	private String factAddr;
	private String phNo;
	private String gstNo;
	private String panNo;
	private String cinNo;
	private String emailId;
	private String faxNo;
	private String companyDetails;
	private Integer status;
	
	
	
	
	public Integer getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRegdOfficeAddr() {
		return regdOfficeAddr;
	}
	public void setRegdOfficeAddr(String regdOfficeAddr) {
		this.regdOfficeAddr = regdOfficeAddr;
	}
	public String getFactAddr() {
		return factAddr;
	}
	public void setFactAddr(String factAddr) {
		this.factAddr = factAddr;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
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
	public String getCinNo() {
		return cinNo;
	}
	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	public String getCompanyDetails() {
		return companyDetails;
	}
	public void setCompanyDetails(String companyDetails) {
		this.companyDetails = companyDetails;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	

}
