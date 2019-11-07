package com.aspl.org.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transporter")
public class Transporter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer transporterId;
	
	private String transporterName;
	private String lrNo;
	private String vehicleNo;
	private String Address;
	
	public Integer getTransporterId() {
		return transporterId;
	}
	public void setTransporterId(Integer transporterId) {
		this.transporterId = transporterId;
	}
	public String getTransporterName() {
		return transporterName;
	}
	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}
	public String getLrNo() {
		return lrNo;
	}
	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}
