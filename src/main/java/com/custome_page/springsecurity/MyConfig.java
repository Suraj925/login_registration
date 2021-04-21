package com.custome_page.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter{
 
	
	  @Bean 
	  public UserDetailsService getUserDetailsService() { return new
	  UserDetailServiceimpl(); }
	  
	  @Bean
     public BCryptPasswordEncoder passwordEncoder() { return new
	  BCryptPasswordEncoder(); }
	  
	  @Bean 
	  public DaoAuthenticationProvider authenticationProvider() {
	  DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
	  daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
	  daoAuthenticationProvider.setPasswordEncoder(passwordEncoder()); 
	  return daoAuthenticationProvider; }
	 
	
	
	//configuration method
	
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	  { auth.authenticationProvider(authenticationProvider()); }
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		  http.authorizeRequests().antMatchers("/user/**").hasRole("NORMAL")
		  
		 
		 
		  .antMatchers("/**").permitAll().and().formLogin()
					
					/* this is for Custome Login Page inform to SpringSecurity that i m using our own login page instead of spring login
					  page /loginPage is url where u hit for getting your own custom login page inside controller */
					  .loginPage("/loginPage")
					  
		 
		  .and().csrf().disable();
		  
		
		 
	}
	
	
	
	
	
}