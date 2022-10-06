package com.bt.microservices.blogservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	 {
	     auth.inMemoryAuthentication()
	     .withUser("admin")
	     .password("{noop}password")
	     .roles("ADMIN");
	 }
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception
	 {
	     http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/v1/admin/allUserPosts").hasRole("ADMIN").and().csrf().disable().formLogin().disable();
	 }
}
