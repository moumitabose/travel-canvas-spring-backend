package com.tourism.travel_canvas.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()  // Disable CSRF for simplicity
	            .authorizeRequests().anyRequest().permitAll();  // Allow all requests
	        return http.build();
	    }
	 
	 
//	 
//	 http.csrf().disable()
//     .authorizeRequests()
//     .antMatchers("/login").permitAll()  // Allow access to login endpoint
//     .anyRequest().authenticated()  // Secure other endpoints
//     .and()
//     .httpBasic();  // Use HTTP Basic authentication for simplicity
// return http.build();

}
