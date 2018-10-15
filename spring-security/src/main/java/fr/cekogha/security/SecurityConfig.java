package fr.cekogha.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception
	{

		// The users are in memory, configure in the java code
		// User n°1
		auth.inMemoryAuthentication().withUser("admin")
									.password("123")
									.roles("ROLE", "PROF"); 

		// User n°2
		auth.inMemoryAuthentication().withUser("prof1")
									.password("234")
									.roles("PROF"); 

		// User n°3
		auth.inMemoryAuthentication().withUser("std1")
									.password("321")
									.roles("STUDENT"); 

		// User n°4
		auth.inMemoryAuthentication().withUser("scho1")
									.password("432")
									.roles("SCHOOLING"); 


	}
	
	
	protected  void configure(HttpSecurity http) throws Exception
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
