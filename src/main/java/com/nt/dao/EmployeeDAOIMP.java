//EmployeeDAO.java
package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Emp;

@Repository("empDAO")
public class EmployeeDAOIMP implements IEmployeeDAO {
	 private static final String GET_EMPS_BY_DESGS="SELECT ENO,ENAME,JOB,SAL,DEPNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
     
	    @Autowired
	    private DataSource ds;//HAS-A PROPERTY
	    
	    @Override
	    public List<Emp>getEmployeeByDesgs(String desg1,String desg2,String desg3)throws Exception
	    {
	    	System.out.println("EmployeeDAOIMP.getEmployeeByDesgs()::ds class name::"+ds.getClass());
	    	List<Emp>list=null;
	    	//get pooled jdbc connection object
	    	try(Connection con=ds.getConnection();
	    			//create prepared statement object
	    			PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESGS))
	    	{
	    		//set values to query parameters
	    		ps.setString(1, desg1);
	    		ps.setString(2, desg2);
	    		ps.setString(3, desg3);
	           //execute Query
	    		try(ResultSet rs=ps.executeQuery())
	    		{
	    			// copy the records result set object to List<Employee> object
	    			list=new ArrayList();
	    			while(rs.next())
	    			{
	    				//copy each record of rs to employee object
	    				Emp e=new Emp();
	    				e.setEno(rs.getInt(1));
	    				e.setEname(rs.getString(2));
	    				e.setJob(rs.getString(3));
	    				e.setSal(rs.getDouble(4));
	    				e.setDepno(rs.getInt(5));
	    				list.add(e);
	    			}//while
	    		}//try2 with resource
	    	}//try1 with resource
	    	catch(Exception se)
	    	{
	    		se.printStackTrace();
	    		throw se;//exception propagation
	    	}
	    	return list;
	    }//method
}//end of the class
