package com.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // add our users for in memory authentication
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test1").roles("EMPLOYEE"));

        auth.inMemoryAuthentication()
                .withUser(users.username("mary").password("test12").roles("MANAGER", "EMPLOYEE"));

        auth.inMemoryAuthentication()
                .withUser(users.username("suzanne").password("test123").roles("ADMIN", "EMPLOYEE", "MANAGER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .anyRequest().authenticated() // need to comment this out because we do not want all roles access to every route
                .antMatchers("/").hasRole("EMPLOYEE") // need this if we comment out above, because there would be no authorization associated with the route, so it would be inaccessible.
                .antMatchers("/leaders/**").hasRole("MANAGER") // restricting path based on user role
//                .antMatchers("/systems/**").hasRole("ADMIN") // restricting path based on user role
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage") // need a controller for this route
                .loginProcessingUrl("/authenticateTheUser") // no need for a controller for this
                .permitAll() // allows all users to see the login page.
                .and()
                .logout().permitAll(); // allow everyone to log out if they desire to do so.
    }
}
