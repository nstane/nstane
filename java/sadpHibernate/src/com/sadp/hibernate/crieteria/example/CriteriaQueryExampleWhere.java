package com.sadp.hibernate.crieteria.example;
import javax.persistence.criteria.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class CriteriaQueryExampleWhere {

   public static void main(String[] args) {

      Transaction transaction = null;
      try (Session session = new Configuration()
		.configure("hibernate.cfg.criteria.xml").buildSessionFactory()
		.openSession()) {
         transaction = session.beginTransaction();

         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Department> query = builder.createQuery(Department.class);
         Root<Department> root = query.from(Department.class);
         query.select(root).where(builder.equal(root.get("id"), 101l));
         Query<Department> q=session.createQuery(query);
         Department department=q.getSingleResult();
         System.out.println(department.getName());
         System.out.println(department.getEmployees());
         
         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }
}