package com.sadp.mapping;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;



public class App {
	public static void main(String[] args) {
		Session session=new Configuration().configure("hibernate.cfg.mapping.xml").buildSessionFactory().openSession();
		
		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("7052");
		stock.setStockName("PADINI");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();
		System.out.println("transaction completed!!!");
		session.beginTransaction();

		//Stock dupStock = new Stock();

		//dupStock.setStockCode("7052");
		//dupStock.setStockName("PADINI");

		StockDetail dupStockDetail = new StockDetail();
		dupStockDetail.setCompName("PADINI Holding Malaysia1");
		dupStockDetail.setCompDesc("one stop shopping1");
		dupStockDetail.setRemark("vinci vinci1");
		dupStockDetail.setListedDate(new Date());

		//dupStock.setStockDetail(dupStockDetail);
		dupStockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

		System.out.println("Done");
	}
}