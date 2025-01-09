package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Emp;

@Service("empservice")
public class Empsevice implements IEmployeeservice {
	@Autowired
     private IEmployeeDAO dao;
     
     public List<Emp>fetchEmployeeByDesgs(String desg1,String desg2,String desg3)throws Exception
     {
    	 List<Emp>list=dao.getEmployeeByDesgs(desg1, desg2, desg3);
    	 return list;
     }
}
