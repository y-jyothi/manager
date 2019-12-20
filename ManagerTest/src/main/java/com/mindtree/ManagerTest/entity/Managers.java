package com.mindtree.ManagerTest.entity;

import java.util.List;

public class Managers {
	private int mId;
	private String managerName;
	private int mobileNo;
	private List<Project> projects;
	public Managers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	@Override
	public String toString() {
		return "Managers [mId=" + mId + ", managerName=" + managerName + ", mobileNo=" + mobileNo + ", projects="
				+ projects + "]";
	}
	public Managers(int mId, String managerName, int mobileNo, List<Project> projects) {
		super();
		this.mId = mId;
		this.managerName = managerName;
		this.mobileNo = mobileNo;
		this.projects = projects;
	}

}
