
package com.winon.health.report.entity;

/**
 * 住院档案
 */
public class HospitalFiles {
	private String residentID;
	private String patientID;
	private String hospitalID;
	private String areaID;
	private String bedID;
	private String inDate;
	private String outDate;
	
	public String getResidentID() {
		return residentID;
	}
	public void setResidentID(String residentID) {
		this.residentID = residentID;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getHospitalID() {
		return hospitalID;
	}
	public void setHospitalID(String hospitalID) {
		this.hospitalID = hospitalID;
	}
	public String getAreaID() {
		return areaID;
	}
	public void setAreaID(String areaID) {
		this.areaID = areaID;
	}
	public String getBedID() {
		return bedID;
	}
	public void setBedID(String bedID) {
		this.bedID = bedID;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	
}
