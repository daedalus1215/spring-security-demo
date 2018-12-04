package com.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    // adda  reference to our security data source
    @Autowired
    private DataSource securityDatasource;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // use jdbc authentication
        auth.jdbcAuthentication().dataSource(securityDatasource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .anyRequest().authenticated() // need to comment this out because we do not want all roles access to every route
                .antMatchers("/").hasRole("EMPLOYEE") // need this if we comment out above, because there would be no authorization associated with the route, so it would be inaccessible.
                .antMatchers("/leaders/**").hasRole("MANAGER") // restricting path based on user role
                .antMatchers("/systems/**").hasRole("ADMIN") // restricting path based on user role
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage") // need a controller for this route
                .loginProcessingUrl("/authenticateTheUser") // no need for a controller for this
                .permitAll() // allows all users to see the login page.
                .and()
                .logout().permitAll() // allow everyone to log out if they desire to do so.
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied"); // we will setup our access denied page mapping.
    }

}
