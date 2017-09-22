package com.sadp.hibernate.crieteria.example;
import java.util.List;

import javax.persistence.criteria.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CriteriaQueryExample3 {

   public static void main(String[] args) {

      Transaction transaction = null;
      try (Session session = new Configuration()
		.configure("hibernate.cfg.criteria.xml").buildSessionFactory()
		.openSession()) {
         transaction = session.beginTransaction();

         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
         Root<Employee> root = query.from(Employee.class);
         query.multiselect(root.get("name"),root.get("designation"));
         Query<Object[]> q=session.createQuery(query);
         List<Object[]> list=q.getResultList();
         for (Object[] objects : list) {
            System.out.println("Name : "+objects[0]+"\tDesignation : "+objects[1]);
            
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