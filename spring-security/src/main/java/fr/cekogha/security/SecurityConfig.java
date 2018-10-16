package fr.cekogha.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception
	{
		// The users are in memory, configure in the java code
		// User n°1 : Admin
		auth.inMemoryAuthentication().withUser("admin")
		.password("{noop}123").roles("ADMIN", "PROF"); 
		
		// User n°2 : Prof
		auth.inMemoryAuthentication()
		.withUser("prof1").password("234").roles("PROF"); 

		// User n°3 : Student
		auth.inMemoryAuthentication()
		.withUser("std1").password("321").roles("STUDENT"); 

		// User n°4 : Schooling
		auth.inMemoryAuthentication()
		.withUser("scho1").password("432").roles("SCHOOLING"); 

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll();
		
	}
		
}
