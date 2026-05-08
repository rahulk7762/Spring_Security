package com.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////		Disables CSRF protection.
//		http.csrf(customizer -> customizer.disable());
////		Every request needs login.
//		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
////		Enables default login form of Spring Security
////		http.formLogin(Customizer.withDefaults());
////		Enables Basic Authentication.
//		http.httpBasic(Customizer.withDefaults());
////		Stateless Authentication
//		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		return http.build();

		
		
		return http.csrf(Customizer -> Customizer.disable())
				.authorizeHttpRequests(request -> request.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).build();

	}
	
	
	
	
	// this is only when when we are not dealing witht the Database
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//
//	    UserDetails user1 = User
//	            .withDefaultPasswordEncoder()
//	            .username("rahul")
//	            .password("Rahul@098")
//	            .roles("USER")
//	            .build();
//	    
//	    UserDetails user2 = User
//	            .withDefaultPasswordEncoder()
//	            .username("rohit")
//	            .password("Rohit@098")
//	            .roles("USER")
//	            .build();
//
//
//	    return new InMemoryUserDetailsManager(user1,user2);
//	}

}
