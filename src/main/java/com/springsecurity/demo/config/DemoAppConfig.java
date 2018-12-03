package com.springsecurity.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.logging.Logger;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    // the data is stored in this variable from the persistence-mysql.properties file.
    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }


    // define a bean for our security datasource
    @Bean
    public DataSource securityDataSource() {
        // create connection pool
        // set the jdbc driver class
        // log the connection props
        // set database connection props
        // set connection pool props

        return null;
    }
}
