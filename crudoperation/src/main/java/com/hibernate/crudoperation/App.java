package com.hibernate.crudoperation;

import org.hibernate.mapping.List;

import com.hibernate.crudoperation.dao.EmployeeDao;
import com.hibernate.crudoperation.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeeDao ad=new EmployeeDao();
        //for insert
//        Employee employee=new Employee(1,"radhika",40000);
//        ad.saveEmployee(employee);
//        System.out.println("record inserted succesfully");
        //for update
       // ad.UpdateEmployee("sang", 1);
        //for delete
       // ad.DeleteEmployee(1);
        //for showing record
//        <dependency>
//		<groupId>org.springframework.boot</groupId>
//		<artifactId>spring-boot-starter-validation</artifactId>
//	</dependency>
      // ad.getAllEmployee();//all emp
     ad.SearchByIdEmployee(3);//for search
    }
}
