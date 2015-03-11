package org.gradle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.*;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class Websecurityconfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected
	  void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	    .inMemoryAuthentication()
	       .withUser("foo").password("bar").roles("USER");
	  }

	  @Override
	protected
	  void configure(HttpSecurity http) throws Exception {
	    BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
	    //entryPoint.realmName = "Spring Boot";
	    //http.exceptionHandling().authenticationEntryPoint(entryPoint);
	    http.requestMatchers().antMatchers("/moderators/*").anyRequest()
	    .and().httpBasic().and().anonymous().disable().csrf().disable();
	  }
	
}
