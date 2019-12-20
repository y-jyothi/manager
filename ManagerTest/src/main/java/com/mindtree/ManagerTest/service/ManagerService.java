package com.mindtree.ManagerTest.service;

import java.util.List;
import java.util.Set;

import com.mindtree.ManagerTest.entity.Project;
import com.mindtree.ManagerTest.exceptions.serviceException.ServiceException;

public interface ManagerService {
public void insertManager(int mId,String managerName,int mobileNo,List<Project> projects) throws ServiceException;
public Set<Project> displayProjects(int mid)throws ServiceException;
public void updateProject(int pid,String pname)throws ServiceException;
public List<Project> sortProjects(int mid)throws ServiceException;
public void deleteProject(int pid) throws ServiceException;

}
