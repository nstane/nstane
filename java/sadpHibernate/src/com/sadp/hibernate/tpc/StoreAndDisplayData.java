package com.sadp.hibernate.tpc;  
  
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


  
public class StoreAndDisplayData {  
public static void main(String[] args) {  
	Configuration configuration = new Configuration().configure();
	//AnnotationConfiguration cfg=new AnnotationConfiguration();  
    Session session=configuration.configure("hibernate.cfg.tpc.xml").buildSessionFactory().openSession();  
      
    Transaction t=session.beginTransaction();  
      
    Employee e1=new Employee();  
    e1.setName("sonoo");  
      
    Regular_Employee e2=new Regular_Employee();  
    e2.setName("Vivek Kumar");  
    e2.setSalary(50000);  
    e2.setBonus(5);  
      
    Contract_Employee e3=new Contract_Employee();  
    e3.setName("Arjun Kumar");  
    e3.setPay_per_hour(1000);  
    e3.setContract_duration("15 hours");  
      
    session.persist(e1);  
    session.persist(e2);  
    session.persist(e3);  
      
    t.commit();  
    //reference https://www.boraji.com/hibernate-5-criteria-query-example
    CriteriaQuery<Contract_Employee> criteriaQuery =session.getCriteriaBuilder().createQuery(Contract_Employee.class);
   Root<Contract_Employee> root = criteriaQuery.from(Contract_Employee.class);
   criteriaQuery.select(root);
   Query<Contract_Employee> query=session.createQuery(criteriaQuery);
  System.out.println("... Contract_Employee.......");
   for(Employee emp:query.getResultList()){
	   System.out.println(emp);
   }
    session.close();  
    System.out.println("success");  
}  
}  