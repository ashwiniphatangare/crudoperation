package com.hibernate.crudoperation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.crudoperation.model.Employee;
import com.hibernate.crudoperation.util.EmployeeUtil;

public class EmployeeDao {
	public void saveEmployee(Employee employee) {
		Transaction trans = null;
		try {
			Session session = EmployeeUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(employee);
			trans.commit();
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

	}
	public void UpdateEmployee(String ename,int eid) {
		Transaction trans = null;
		try {
			Session session = EmployeeUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
		Query q=session.createQuery("update Employee set ename=:ename where eid=:eid");
		q.setParameter("ename", ename);
		q.setParameter("eid", eid);
		int i=q.executeUpdate();
		if(i>0) {
			System.out.println("update succesfully");
		}
		trans.commit();
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

		
	}
	public void DeleteEmployee(int eid) {
		Transaction trans = null;
		try {
			Session session = EmployeeUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
		Query q=session.createQuery("delete from Employee where eid=:eid");
		
		q.setParameter("eid", eid);
		int i=q.executeUpdate();
		if(i>0) {
			System.out.println("delete succesfully");
		}
		trans.commit();//save session i.e session.save(q);
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	public void getAllEmployee() {
		Transaction trans = null;
		
			Session session = EmployeeUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Query q=session.createQuery("from Employee");
			
			 List <Employee> li=q.list();
		        for(Employee e:li) {
		        	System.out.println("Employee id:"+e.getEid()+""+"employee name:"+e.getEname());
		        }
		       
		        System.out.println("display record");
			trans.commit();//save session i.e session.save(q);
	}
	public void SearchByIdEmployee(int eid) {
		Transaction trans = null;
		
			Session session = EmployeeUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
		Query q=session.createQuery(" from Employee where eid=:eid");
		
		q.setParameter("eid", eid);
		 List <Employee> li=q.list();
	        for(Employee e:li) {
	        	System.out.println("Employee id:"+e.getEid()+""+"employee name:"+e.getEname());
	        }
	       
	        System.out.println("search record");
		trans.commit();//save session i.e session.save(q);
		
	}
}
