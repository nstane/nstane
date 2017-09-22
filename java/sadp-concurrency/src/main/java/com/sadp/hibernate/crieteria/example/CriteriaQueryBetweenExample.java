package com.sadp.hibernate.crieteria.example;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
//https://docs.oracle.com/cd/E19798-01/821-1841/gjivi/index.html
public class CriteriaQueryBetweenExample {

	public static void main(String[] args) {

		Transaction transaction = null;
		try (Session session = new Configuration()
				.configure("hibernate.cfg.criteria.xml").buildSessionFactory()
				.openSession()) {
			transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = builder.createQuery(Employee.class);
			Root<Employee> root = cq.from(Employee.class);
			cq.select(root).where(builder.between(root.get("salary"), 10000, 12000));
			Query<Employee> q = session.createQuery(cq);
			List<Employee> employees = q.getResultList();
			for (Employee employee : employees) {
				System.out.println(employee.getName()+"\t"+employee.getSalary());
			}
			
			
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}
}