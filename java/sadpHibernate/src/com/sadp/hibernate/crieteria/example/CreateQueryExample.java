package com.sadp.hibernate.crieteria.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

//https://docs.oracle.com/cd/E19798-01/821-1841/gjivi/index.html
public class CreateQueryExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Transaction transaction = null;
		try (Session session = new Configuration()
				.configure("hibernate.cfg.criteria.xml").buildSessionFactory()
				.openSession()) {
			transaction = session.beginTransaction();

			Query<Employee> q = session.createQuery("from Employee");

			List<Employee> employees = q.getResultList();
			for (Employee employee : employees) {
				// System.out.println(employee);

				employee.setName(employee.getName().replace(".. updated..", ""));
				System.out.println(employee.getName());
			}
			transaction.commit();
			System.out.println(" transaction completed.....");
			transaction = session.beginTransaction();
			Query<Department> q1 = session
					.createQuery("from Department where name = 'Information Technology'");
			Department dept = q1.getSingleResult();
			Employee emp = new Employee();
			emp.setName("TEST.. ");
			dept.getEmployees().add(emp);
			dept.setName("IT");
			emp.setDepartment(dept);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}
}