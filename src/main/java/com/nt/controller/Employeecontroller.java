package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Emp;
import com.nt.service.IEmployeeservice;

@Controller("Empcontroller")
public class Employeecontroller {
	@Autowired
    private IEmployeeservice service;
	
    public List<Emp>showallEmployeeByDesgs(String desg1,String desg2,String desg3)throws Exception
    {
    	List<Emp>list=service.fetchEmployeeByDesgs(desg1, desg2, desg3);
    	return list;
    }

}
