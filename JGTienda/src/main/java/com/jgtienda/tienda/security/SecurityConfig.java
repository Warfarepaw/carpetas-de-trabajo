package com.jgtienda.tienda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jgtienda.tienda.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService usrS;
	
	@Autowired
	private BCryptPasswordEncoder bcPE;
	
	@Bean
	public BCryptPasswordEncoder passEncoder() 
	{
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		return bcpe;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder authorities) throws Exception
	{
		authorities.userDetailsService(usrS).passwordEncoder(bcPE).and();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
	}


}

//public class SecurityConfig{}
