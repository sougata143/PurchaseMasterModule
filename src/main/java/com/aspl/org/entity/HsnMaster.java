package com.aspl.org.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hsn_master")
public class HsnMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer hsnId;
	
	@Column(name="hsn_description")
	private String hsnDescription;
	
	@Column(name="chapter")
	private String chapter;
	
	@Column(name="heading")
	private String heading;
	
	@Column(name="sub_heading")
	private String subHeading;
	
	@Column(name="is_active")
	private Integer isActive;


	public Integer getHsnId() {
		return hsnId;
	}

	public void setHsnId(Integer hsnId) {
		this.hsnId = hsnId;
	}

	public String getHsnDescription() {
		return hsnDescription;
	}

	public void setHsnDescription(String hsnDescription) {
		this.hsnDescription = hsnDescription;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getSubHeading() {
		return subHeading;
	}

	public void setSubHeading(String subHeading) {
		this.subHeading = subHeading;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	
	
}
