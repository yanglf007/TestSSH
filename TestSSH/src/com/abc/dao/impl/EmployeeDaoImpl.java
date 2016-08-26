package com.abc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abc.dao.EmployeeDao;
import com.abc.entity.Employee;


public class EmployeeDaoImpl  implements EmployeeDao {

	private	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Employee findbyNameAndPassword(Employee employee) {
		String hql = "from Employee where username=? and password=?";
		System.out.println("Ö´ÐÐdao");
		
		Session session = sessionFactory.openSession();
	
		Query query = session.createQuery(hql);
		query.setString(0, employee.getUsername());
		query.setString(1, employee.getPassword());
		List<Employee> list = query.list();
		
		if(list.size()>0){
			return list.get(0);
		}
		
		
		return null;
	}

	@Override
	public int findCount() {
		Session session = sessionFactory.openSession();
		String hql = "from Employee";
		Query query = session.createQuery(hql);
		List<Employee> list = query.list();
		return list.size();
	}

	@Override
	public List<Employee> findAll(int begin, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from Employee ";
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		@SuppressWarnings("unchecked")
		List<Employee> list = query.list();
		return list;
	}

}
