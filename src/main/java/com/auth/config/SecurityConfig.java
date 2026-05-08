package com.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetails userDetailsServie;
	
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
	
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		return provider;
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
