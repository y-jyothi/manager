package com.mindtree.ManagerTest.dao;

import java.util.List;
import java.util.Set;

import com.mindtree.ManagerTest.entity.Project;
import com.mindtree.ManagerTest.exceptions.daoExceptions.DaoException;

public interface ManagerDaoService {
	public boolean insertManager(int mId,String managerName,int mobileNo,List<Project> projects)throws DaoException;
	public Set<Project> displayProjects(int mid) throws DaoException;
	public boolean updateProject(int pid,String pname)throws DaoException;
	public List<Project> sortProjects(int mid) throws DaoException;
	public boolean deleteProject(int pid) throws DaoException;
	public boolean midExists(int  mid)throws DaoException;
	
	

}
