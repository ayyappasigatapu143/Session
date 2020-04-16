package com.info.beans.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Preconditions;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@EntityScan(basePackages = { "com.info.beans.model" })
@ComponentScan(basePackages = {"com"})
public class EmployeeConfig {

	@Autowired
	private Environment env;

	public EmployeeConfig() {
		super();
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSouce =new DriverManagerDataSource();
		dataSouce
				.setDriverClassName(Preconditions.checkNotNull(env.getProperty("spring.datasource.driver-class-name")));
		dataSouce.setUrl(Preconditions.checkNotNull(env.getProperty("spring.datasource.url")));
		dataSouce.setUsername("root");
		dataSouce.setPassword("root");
		return dataSouce;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan(new String[] { "com.info.beans.model" });

		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(adapter);
		emf.setJpaProperties(getJpaProperties());
		return emf;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties getJpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		return properties;
	}
}