package com.PetGo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http
		.csrf().disable()
		.authorizeHttpRequests((requests)-> requests

				.requestMatchers(
						HttpMethod.POST,"/consulta/", "/especialidade/", "/pet/", "/proprietario/", "/tipo/", "/veterinario/")
				.permitAll()
				.requestMatchers(
						HttpMethod.GET,"/consulta/", "/especialidade/", "/pet/", "/proprietario/", "/tipo/", "/veterinario/")
				.permitAll()
				.requestMatchers(
						HttpMethod.DELETE,"/consulta/{id}", "/especialidade/{id}", "/pet/{id}", "/proprietario/{id}", "/tipo/{id}", "/veterinario/{id}")
				.permitAll()
				.requestMatchers(
						HttpMethod.PUT,"/consulta/**", "/especialidade/**", "/pet/**", "/proprietario/**", "/tipo/**", "/veterinario/**")
				.permitAll()				
				.anyRequest()
				.authenticated()	

				)
		.httpBasic();
		return http.build();

	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService(){
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("Pedro")
				.password("senai")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);

	}
}
