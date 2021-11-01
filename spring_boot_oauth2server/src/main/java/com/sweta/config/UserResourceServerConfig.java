package com.sweta.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class UserResourceServerConfig extends ResourceServerConfigurerAdapter {
	
//Adding this file one can have both oauth2 authorization server and  resource server in a single project
private static final String RESOURCE_ID = "inventory"; //stored in security.oauth_client_details under resource_ids column
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		
		resources.resourceId(RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		

		http
		.anonymous().disable()
		.authorizeRequests().antMatchers("/student/add").hasAnyAuthority("Admin","Student")
		.antMatchers("/student/*", "/student/getById/*") 
		.hasAuthority("Admin") // Only Admin can access
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
		
	}
}
