package com.nt.service;

import java.util.List;

import com.nt.model.Emp;

public interface IEmployeeservice {
    public List<Emp>fetchEmployeeByDesgs(String desg1,String desg2,String desg3)throws Exception;

}
