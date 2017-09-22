/**
 * 
 */
package com.sadp.hibernate.mapping2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author ntanwa
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = new Configuration().configure("hibernate.cfg.mapping2.xml").buildSessionFactory()
				.openSession();
		/*Transaction trn = session.beginTransaction();
		trn.begin();*/
		session.save(new Student("Narender"));
		//session.flush();
		//trn.commit();
		System.out.println(session.createQuery("from Student").getSingleResult());
		session.close();
	}

}
