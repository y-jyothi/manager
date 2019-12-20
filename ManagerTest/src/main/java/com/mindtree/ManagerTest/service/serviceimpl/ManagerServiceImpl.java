package com.mindtree.ManagerTest.service.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mindtree.ManagerTest.dao.ManagerDaoService;
import com.mindtree.ManagerTest.dao.daoimpl.ManagerDaoImpl;
import com.mindtree.ManagerTest.entity.Project;
import com.mindtree.ManagerTest.exceptions.daoExceptions.DaoException;
import com.mindtree.ManagerTest.exceptions.serviceException.NoManagerFound;
import com.mindtree.ManagerTest.exceptions.serviceException.NoProjectFound;
import com.mindtree.ManagerTest.exceptions.serviceException.ServiceException;
import com.mindtree.ManagerTest.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	static ManagerDaoService dao=new ManagerDaoImpl();

	public void insertManager(int mId, String managerName, int mobileNo, List<Project> projects)throws ServiceException {
		// TODO Auto-generated method stub
		try {
			dao.insertManager(mId, managerName, mobileNo, projects);
			for (Project project : projects) {
				System.out.println(project);
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("Dao Exception", e);
		}
		
	}

	public Set<Project> displayProjects(int mid) throws ServiceException{
		// TODO Auto-generated method stub
		Set<Project> projects=new HashSet<Project>();
		try {
			boolean midExists=dao.midExists(mid);
			if(midExists==true)
			{
			projects=dao.displayProjects(mid);
			}
			else
				throw new NoManagerFound("no such manager found");
			if(projects.isEmpty())
				throw new NoProjectFound("no project found");
		
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("Dao Exception", e);
		}
		return projects;
	}

	public void updateProject(int pid,String pname) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			boolean pidexists=dao.updateProject(pid,pname);
			if(pidexists==false)
				throw new NoProjectFound("no project found");
		} catch (DaoException e) {
			throw new ServiceException("Dao Exception", e);
		}
		
		
	}

	public List<Project> sortProjects(int mid) throws ServiceException {
		List<Project> projects=new ArrayList<Project>();
		try {
			projects=dao.sortProjects(mid);
			if(projects.isEmpty())
				throw new NoProjectFound("no projects found");
			Collections.sort(projects,new sortByEmployees());
		} catch (DaoException e) {
			throw new ServiceException("Dao Exception", e);
		}
	
		return projects;
	}
	public class sortByEmployees implements Comparator<Project>
	{

		public int compare(Project arg0, Project arg1) {
				return arg1.getNoOfEmployees()-arg0.getNoOfEmployees();
		}
		
	}
	public void deleteProject(int pid) throws ServiceException {
		// TODO Auto-generated method stubboolean
		//boolean pidexists=false;
		try {
			boolean pidexists=dao.deleteProject(pid);
			if(pidexists==false)
				throw new NoProjectFound("no project found");
		} catch (DaoException e) {
			throw new ServiceException("Dao Exception", e);		
			}
		
		
	}

}
