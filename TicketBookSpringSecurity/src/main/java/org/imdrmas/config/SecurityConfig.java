package org.imdrmas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
       
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.csrf().disable().authorizeRequests().antMatchers("/api/tickets/**")
	      	 .hasAnyRole("admin","user").and().authorizeRequests().antMatchers("/api/admin/**")
		     .hasAnyRole("admin").and().formLogin();
	
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("drmas").password("pass123").roles("user");
		auth.inMemoryAuthentication().withUser("issam").password("pass123").roles("user", "admin");
		
		
	}
}