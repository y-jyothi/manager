package com.mindtree.ManagerTest.entity;

public class Project {
	private int projectId;
	private String projectName;
	private int noOfEmployees;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", noOfEmployees=" + noOfEmployees
				+ "]";
	}
	public Project(int projectId, String projectName, int noOfEmployees) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.noOfEmployees = noOfEmployees;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
