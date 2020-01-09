package com.hellokoding.account.config;
 
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hellokoding.account.service.TopoServiceImpl;
import com.hellokoding.account.service.UserService;
import com.hellokoding.account.service.UserServiceImpl;
 
@Configuration
@ComponentScan("com.hellokoding.account.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:application.properties")
public class ApplicationContextConfig {
	
 // The Environment class serves as the property holder
 // and stores all the properties loaded by the @PropertySource
 @Autowired
 private Environment env;
 
 
 
 @Bean
 public ResourceBundleMessageSource messageSource() {
     ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
     // Load property in message/validator.properties
     messageSource.setBasename("validation");
     
     return messageSource;
 }
 
 
 @Bean(name = "viewResolver")
 public InternalResourceViewResolver getViewResolver() {
     InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
     viewResolver.setPrefix("/WEB-INF/views/");
     viewResolver.setSuffix(".jsp");
     return viewResolver;
 }
 
 @Bean(name = "dataSource")
 public DataSource getDataSource() {
     DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
     dataSource.setDriverClassName(env.getProperty("jdbc.database-driver"));
     dataSource.setUrl(env.getProperty("jdbc.url"));
     dataSource.setUsername(env.getProperty("jdbc.username"));
     dataSource.setPassword(env.getProperty("jdbc.password"));
 
     return dataSource;
 }
 
 @Autowired
 @Bean(name = "sessionFactory")
 public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
     Properties properties = new Properties();
    
     // See: ds-hibernate-cfg.properties
     properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
     properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
     properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
      
 
     LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
     factoryBean.setPackagesToScan(new String[] { "com.hellokoding.account.*" });
     factoryBean.setDataSource(dataSource);
     factoryBean.setHibernateProperties(properties);
     factoryBean.afterPropertiesSet();
     //
     SessionFactory sf = factoryBean.getObject();
     return sf;
 }
 
 @Autowired
 @Bean(name = "transactionManager")
 public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
     HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
 
     return transactionManager;
 }
 
 @Bean(name = "userService")
 public UserService getUserService() {
     return new UserServiceImpl();
 }
 
 
 @Bean(name = "topoService")
 public TopoServiceImpl getTopoService() {
     return new TopoServiceImpl();
 }
 
}