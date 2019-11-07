package com.aspl.org.dto;



public class HsnMasterDTO {

	private Integer hsnId;
	private String hsnDescription;
	private String chapter;
	private String heading;
	private String subHeading;
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
