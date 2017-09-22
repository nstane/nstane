package com.sadp.hibernate.crieteria.example;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class CriteriaQueryExampleGroupBy {

   public static void main(String[] args) {

      Transaction transaction = null;
      try (Session session = new Configuration()
		.configure("hibernate.cfg.criteria.xml").buildSessionFactory()
		.openSession()) {
         transaction = session.beginTransaction();

         CriteriaBuilder builder = session.getCriteriaBuilder();

         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<Employee> root = criteriaQuery.from(Employee.class);
         criteriaQuery.multiselect(builder.count(root.get("name")), root.get("salary"),
               root.get("department"));
         criteriaQuery.groupBy(root.get("salary"), root.get("department"));
         criteriaQuery.having(builder.greaterThan(root.get("salary"), 30000));

         Query<Object[]> query = session.createQuery(criteriaQuery);
         List<Object[]> list = query.getResultList();
         for (Object[] objects : list) {
            long count = (Long) objects[0];
            int salary = (Integer) objects[1];
            Department department = (Department) objects[2];
            System.out.println("Number of Employee = " + count + "\t SALARY=" + salary
                  + "\t DEPT NAME=" + department.getName());
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