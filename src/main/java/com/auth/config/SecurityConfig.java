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
//		Disables CSRF protection.
		http.csrf(customizer -> customizer.disable());
//		Every request needs login.
		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//		Enables default login form of Spring Security
		http.formLogin(Customizer.withDefaults());
//		Enables Basic Authentication.
		http.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
}
