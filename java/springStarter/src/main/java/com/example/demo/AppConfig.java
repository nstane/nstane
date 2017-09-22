/**
 * 
 */
package com.example.demo;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

/**
 * @author ntanwa
 *
 */
@Component
public class AppConfig {

	
	@Autowired
	private Environment env;

	@Bean  
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	    return hemf.getSessionFactory();  
	} 
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("datasource.driver"));
		dataSource.setUrl(env.getProperty("datasource.url"));
		dataSource.setUsername(env.getProperty("datasource.user"));
		dataSource.setPassword(env.getProperty("datasource.password"));
		return dataSource;
	}
	
	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("show_sql", env.getProperty("show_sql"));
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl"));
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		return properties;
	}
}
