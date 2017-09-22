package com.sadp.hibernate.crieteria.example;
import java.util.List;

import javax.persistence.criteria.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class CriteriaQueryExampleJoin {

   public static void main(String[] args) {

      Transaction transaction = null;
      try (Session session = new Configuration()
		.configure("hibernate.cfg.criteria.xml").buildSessionFactory()
		.openSession()) {
         transaction = session.beginTransaction();

         CriteriaBuilder builder = session.getCriteriaBuilder();

         // Using FROM and JOIN
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<Employee> empRoot = criteriaQuery.from(Employee.class);
         Root<Department> deptRoot = criteriaQuery.from(Department.class);
         criteriaQuery.multiselect(empRoot, deptRoot);
         criteriaQuery.where(builder.equal(empRoot.get("department"), deptRoot.get("id")));

         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         for (Object[] objects : list) {
            Employee employee=(Employee)objects[0];
            Department department=(Department)objects[1];
            System.out.println("EMP NAME="+employee.getName()+"\t DEPT NAME="+department.getName());
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