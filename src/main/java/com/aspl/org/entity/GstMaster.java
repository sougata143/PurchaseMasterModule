package com.aspl.org.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gst_master")
public class GstMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer gstId;
	
	private Double gstValue;
	private String gstType;
	
	public Integer getGstId() {
		return gstId;
	}
	public void setGstId(Integer gstId) {
		this.gstId = gstId;
	}
	public Double getGstValue() {
		return gstValue;
	}
	public void setGstValue(Double gstValue) {
		this.gstValue = gstValue;
	}
	public String getGstType() {
		return gstType;
	}
	public void setGstType(String gstType) {
		this.gstType = gstType;
	}
	
	
	
}
