package com.abc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abc.dao.DepartmentDao;
import com.abc.entity.Department;


public class DepartmentDaoImpl implements DepartmentDao {

	private	SessionFactory sessionFactory;
	


	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Department> findByPage(int begin,int pageSize) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		String hql = "from Department";
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		
		@SuppressWarnings("unchecked")
		List<Department>list = query.list();
		return list;
	}

	@Override
	public int findCount() {
		Session session = sessionFactory.openSession();
		String hql = "from Department";
		Query query = session.createQuery(hql);
		List <Department> list = query.list();
	
		
		return list.size();
	}

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save("Department",department);
	}

	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from Department as d where d.did=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, did);
		@SuppressWarnings("unchecked")
		List<Department> list = query.list();
		if(list.size()>0){
			return list.get(0);
		}else{
		return null;
		}
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql ="from Department";
		session.save("Department",department);
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from Department";
		Query  query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Department> list = query.list();

		return list;
	}
}
