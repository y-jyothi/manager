package com.mindtree.ManagerTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.ManagerTest.entity.Project;
import com.mindtree.ManagerTest.exceptions.daoExceptions.DaoException;
import com.mindtree.ManagerTest.exceptions.serviceException.ServiceException;
import com.mindtree.ManagerTest.service.ManagerService;
import com.mindtree.ManagerTest.service.serviceimpl.ManagerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner scan=new Scanner(System.in);
	static ManagerService ser=new ManagerServiceImpl();
    public static void main( String[] args ) {
    String ans="";
    {
       do {
    	   System.out.println("1.insert manager\n 2.display all projects\n 3.update the project\n 4.sort the projects\n 5.delete a project");
    	   System.out.println("enter valid choice");
    	   int choice=scan.nextInt();
    	   switch(choice)
    	   {
    	   case 1:insertManager();
    	   break;
    	   case 2:displayProjects();
    	   break;
    	   case 3:updateProject();
    	   break;
    	   case 4:sortProjects();
    	   break;
    	   case 5:deleteProject();
    	   break;
    	   default:System.out.println("invalid choice");
    	   break;
    	   
    	   }
    	   System.out.println("do u want to continue");
    	   ans=scan.next();
    	   
       }while(ans.equalsIgnoreCase("yes"));
    }
}
private static void deleteProject() {
	System.out.println("enter pid");
	int pid=scan.nextInt();
	try {
		ser.deleteProject(pid);
		System.out.println("deleted succssfully");
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
	System.out.println(e.getMessage());
	}
		
	}
private static void sortProjects() {
		System.out.println("enter mid");
		int mid=scan.nextInt();
		List<Project> projects=new ArrayList<Project>();
		try {
			projects=ser.sortProjects(mid);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}
		for (Project project : projects) {
			System.out.println(project);
		}
		
	}
private static void updateProject() {
		System.out.println("enter project id");
		int pid=scan.nextInt();
		System.out.println("enter project name");
		String pname=scan.next();
		try {
			ser.updateProject(pid, pname);
			System.out.println("updated project successfully");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}
		
		
	}
private static void displayProjects() {
	Set<Project> projects =new HashSet<Project>();
	System.out.println("enter mid");
	int mid=scan.nextInt();
	try {
		projects=ser.displayProjects(mid);
	} catch (ServiceException e) {
		System.out.println(e.getMessage());
	}
	for (Project project : projects) {
		System.out.println(project);
	}
		
	}
private static void insertManager() {
	System.out.println("enter mid");
	int mId=scan.nextInt();
	System.out.println("enter manager name");
	String managerName=scan.next();
	System.out.println("enter mobile number");
	int mobileNo=scan.nextInt();

	System.out.println("enter number of projects");
	int num=scan.nextInt();	
	List<Project> projects=new ArrayList<Project>();
	for(int i=0;i<num;i++)
	{
		System.out.println("enter project id");
		int projectId=scan.nextInt();
		System.out.println("enter project Name");
		String projectName=scan.next();
		System.out.println("enter noOfEmployees");
		int noOfEmployees=scan.nextInt();
		projects.add(new Project(projectId,projectName,noOfEmployees));
	}

	try {
		ser.insertManager(mId,managerName,mobileNo, projects);
		System.out.println("updated successfully");
	} catch (ServiceException e) {
		System.out.println(e.getMessage());

	}
	
		
		
	
	
	
}
}
