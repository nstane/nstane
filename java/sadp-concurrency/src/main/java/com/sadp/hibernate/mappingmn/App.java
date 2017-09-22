package com.sadp.hibernate.mappingmn;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		System.out.println("Hibernate one to many (Annotation)");
		Session session = new Configuration()
				.configure("hibernate.cfg.mapping1m.xml").buildSessionFactory()
				.openSession();

		session.beginTransaction();
		Stock stock = new Stock();
        stock.setStockCode("7052");
        stock.setStockName("PADINI");

        Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
        Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY");

        Set<Category> categories = new HashSet<Category>();
        categories.add(category1);
        categories.add(category2);

        stock.setCategories(categories);

        session.save(stock);

	session.getTransaction().commit();
	System.out.println("Done");
	}
}