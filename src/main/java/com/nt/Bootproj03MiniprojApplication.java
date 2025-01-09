package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.Employeecontroller;
import com.nt.model.Emp;

@SpringBootApplication
public class Bootproj03MiniprojApplication {

	public static void main(String[] args) {
		 ApplicationContext ctx=SpringApplication.run(Bootproj03MiniprojApplication.class, args);
		 Employeecontroller controller=ctx.getBean(Employeecontroller.class);
		 try
		 {
			 List<Emp>list=controller.showallEmployeeByDesgs("clerk", "manager", "salesboy");
			 list.forEach(emp->{
				 System.out.println(emp);
			 });
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 System.err.println("internal problem---->try again::"+e.getMessage());
		 }
		 ((ConfigurableApplicationContext) ctx).close();
	}

}
