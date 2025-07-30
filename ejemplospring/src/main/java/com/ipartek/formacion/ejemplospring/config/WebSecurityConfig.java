package com.ipartek.formacion.ejemplospring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	// AUTENTICACIÓN
	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery("""
	      		SELECT email, password, 1
	      		FROM usuarios
	      		WHERE email=?
	      		""")
	      .authoritiesByUsernameQuery("""
	      		SELECT email, CONCAT('ROLE_', rol)
	      		FROM usuarios
	      		WHERE email=?
	      		""")
	      ;
	}

	// AUTORIZACIÓN
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(requests -> requests
				.requestMatchers("/admin/**").hasRole("ADMINISTRADOR")
				.anyRequest().permitAll()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout(logout -> logout.permitAll());

		return http.build();
	}
}