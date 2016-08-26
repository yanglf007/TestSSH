package com.abc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save("Employee", employee);
	}

	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from Employee as e where e.eid=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, eid);
		return (Employee) query.list().get(0);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
	
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.update(employee);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Integer eid) {
		// TODO Auto-generated method stub
		System.out.println("Ö´ÐÐÉ¾³ýÓï¾ä");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		String hql = "  delete from Employee as e where e.eid =?";
		
		Query query = session.createQuery(hql);
		
		query.setInteger(0, eid);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

}
