package com.mindtree.ManagerTest.dao.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mindtree.ManagerTest.dao.ManagerDaoService;
import com.mindtree.ManagerTest.entity.Project;
import com.mindtree.ManagerTest.exceptions.daoExceptions.DaoException;
import com.mindtree.ManagerTest.utility.ManagerUtility;
import com.mysql.jdbc.PreparedStatement;

public class ManagerDaoImpl implements ManagerDaoService {

	public boolean insertManager(int mId, String managerName, int mobileNo, List<Project> projects)throws DaoException {
			String query = "insert into manager values(?,?,?)";
			String query1 = "insert into project values(?,?,?,?)";
			Connection con =null;
			PreparedStatement ps=null;

			
			try {
				con = ManagerUtility.connect();
				 ps = (PreparedStatement) con.prepareStatement(query);
				
				ps.setInt(1, mId);
				ps.setString(2,managerName );
				ps.setInt(3, mobileNo);
				int i=ps.executeUpdate();
//				PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query1);
				PreparedStatement pstmt=null;int j=0;
				//insertProject(projects);
				for (Project project : projects) {
					pstmt = (PreparedStatement) con.prepareStatement(query1);
					//Project projects1=new Project();
					int pid=project.getProjectId();
					String pname=project.getProjectName();
					int employees=project.getNoOfEmployees();
					int mid=mId;
					
					
					    pstmt.setInt(1, pid);
						pstmt.setString(2,pname);
						pstmt.setInt(3, employees);
						pstmt.setInt(4,mid);
						j=pstmt.executeUpdate();
												
	
				}
//			pstmt.executeUpdate();
				//ps.executeUpdate();
				if(i==1&&j==1)
					return true;

			} catch (SQLException e) {
				throw new DaoException("SQL Exception", e);
			}
			finally{
			     
			      try{
			         if(ps!=null)
			            con.close();
			      }catch(SQLException se){
			      }
			      try{
			         if(con!=null)
			            con.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
			}
			return false;
		
				
			

		}

	
	public Set<Project> displayProjects(int mid) throws DaoException {
		// TODO Auto-generated method stub
		Set<Project> projects=new HashSet<Project>();
		String query = "select * from project where mid='"+mid+"'";
		Connection con =null;
		PreparedStatement ps=null;

		try {
		 con = ManagerUtility.connect();
		 ps = (PreparedStatement) con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Project project=new Project();
				project.setProjectId(rs.getInt(1));
				project.setProjectName(rs.getString(2));
				project.setNoOfEmployees(rs.getInt(3));
				projects.add(project);

			}
		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}
		finally{
		     
		      try{
		         if(ps!=null)
		            con.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}

		return projects;
	}


	public boolean updateProject(int pid,String pname) throws DaoException {
		Connection con =null;
		PreparedStatement ps=null;

		String query = " update project set pname='"+pname+"' where pid='"+pid+"'";
		try {
			 con = ManagerUtility.connect();
			ps = (PreparedStatement) con.prepareStatement(query);
			
			int i=ps.executeUpdate();
			if(i==1)
				return true;

		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}
		finally{
		     
		      try{
		         if(ps!=null)
		            con.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		
return false;
	
		
	}


	public List<Project> sortProjects(int mid) throws DaoException {
		// TODO Auto-generated method stub
		List<Project> projects=new ArrayList<Project>();
		String query = " select * from project where mid ='"+mid+"'";
		Connection con =null;
		PreparedStatement ps=null;

		try {
			 con = ManagerUtility.connect();
			 ps = (PreparedStatement) con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Project project=new Project();
				project.setProjectId(rs.getInt(1));
				project.setProjectName(rs.getString(2));
				project.setNoOfEmployees(rs.getInt(3));
				projects.add(project);

			}
			

		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}
		finally{
		     
		      try{
		         if(ps!=null)
		            con.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		
		return projects;
	}


	public boolean deleteProject(int pid) throws DaoException {
		Connection con =null;
		PreparedStatement ps=null;

		String query = "delete from project where pid='"+pid+"'";
		try {
			con = ManagerUtility.connect();
			 ps = (PreparedStatement) con.prepareStatement(query);
			
			int i=ps.executeUpdate();
			if(i==1)
				return true;

		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}
		finally{
		     
		      try{
		         if(ps!=null)
		            con.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		return false;
	
	}


	public boolean midExists(int mid) throws DaoException {
		Connection con =null;
		PreparedStatement ps=null;

		String query="Select * from manager where mid='"+mid+"'";
		try {
			con = ManagerUtility.connect();
			ps = (PreparedStatement) con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
				

			}
		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}
		finally{
		     
		      try{
		         if(ps!=null)
		            con.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}

		
		
		return false;
	}

	
		
	

}
