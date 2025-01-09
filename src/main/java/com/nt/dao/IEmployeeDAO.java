//IEmployeeDAO.java
package com.nt.dao;

import java.util.List;

import com.nt.model.Emp;

public interface IEmployeeDAO {
    public List<Emp>getEmployeeByDesgs(String desg1,String desg2,String desg3)throws Exception;

}
