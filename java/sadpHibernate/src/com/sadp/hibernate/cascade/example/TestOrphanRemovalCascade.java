package com.sadp.hibernate.cascade.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestOrphanRemovalCascade
{
   public static void main(String[] args)
   {

       
	   SessionFactory  sessionFactory = new Configuration()
		.configure("hibernate.cfg.cascade.xml").buildSessionFactory();
		
      setupTestData(sessionFactory.openSession());
      Session sessionOne = sessionFactory.openSession();
      org.hibernate.Transaction tx = sessionOne.beginTransaction();
     
      //Load the employee in another session
      EmployeeEntity employee = (EmployeeEntity) sessionOne.load(EmployeeEntity.class, 1);
      //Verify there are 3 accounts
      System.out.println("Step 1 : " + employee.getAccounts().size());
       
      //Remove an account from first position of collection
      employee.getAccounts().remove(employee.getAccounts().iterator().next());
       
      //Verify there are 2 accounts in collection
      System.out.println("Step 2 : " + employee.getAccounts().size());
       
      tx.commit();
      sessionOne.close();
       
      //In another session check the actual data in database
      Session sessionTwo = sessionFactory.openSession();
      sessionTwo.beginTransaction();
       
      EmployeeEntity employee1 = (EmployeeEntity) sessionTwo.load(EmployeeEntity.class, 1);
      //Verify there are 2 accounts now associated with Employee
      System.out.println("Step 3 : " + employee1.getAccounts().size());
       
      //Verify there are 2 accounts in Account table
      Query query = sessionTwo.createQuery("from Account a");
      @SuppressWarnings("unchecked")
      List<AccountEntity> accounts = query.list();
      System.out.println("Step 4 : " + accounts.size());
       
      sessionTwo.close();
       
 
   }  
    
   private static void setupTestData(Session session){
     
      session.beginTransaction();
       
      //Create Employee
      EmployeeEntity emp = new EmployeeEntity();
      emp.setEmployeeId(1);
      emp.setFirstName("Lokesh");
      emp.setLastName("Gupta");
      session.save(emp);
       
      //Create Account 1
      AccountEntity acc1 = new AccountEntity();
      acc1.setAccountId(1);
      acc1.setAccountNumber("11111111");
      acc1.setEmployee(emp);
      session.save(acc1);
       
      //Create Account 2
      AccountEntity acc2 = new AccountEntity();
      acc2.setAccountId(2);
      acc2.setAccountNumber("2222222");
      acc2.setEmployee(emp);
      session.save(acc2);
       
      //Create Account 3
      AccountEntity acc3 = new AccountEntity();
      acc3.setAccountId(3);
      acc3.setAccountNumber("33333333");
      acc3.setEmployee(emp);
      session.save(acc3);
             
      session.getTransaction().commit();
      session.close();
   }
}