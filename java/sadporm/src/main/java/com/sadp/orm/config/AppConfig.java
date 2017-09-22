/**
 * 
 */
package com.sadp.orm.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author ntanwa
 *
 */
@Configuration
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("datasource.driver"));
		dataSource.setUrl(env.getProperty("datasource.url"));
		dataSource.setUsername(env.getProperty("datasource.user"));
		dataSource.setPassword(env.getProperty("datasource.password"));
		return dataSource;
	}

	@Bean(name = {"dataSource2"})
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource2() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.sadp.orm.dto");
		factory.setDataSource(dataSource());
		//factory.setDataSource(dataSource2());
		factory.afterPropertiesSet();
		factory.setJpaProperties(additionalProperties());

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("show_sql", env.getProperty("show_sql"));
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl"));
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		return properties;
	}
}
