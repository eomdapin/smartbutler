package com.fms.smartbutler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf((csrf) -> csrf.disable())
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/admin/login","/css/**","/img/**","/admin/logout","/admin/signout").permitAll()
				.anyRequest().authenticated()
			);
		http
			.formLogin((form) -> form
			.loginPage("/admin/login")
			.permitAll()
			);
		http
			.logout((logout) ->
				logout
					.logoutUrl("/admin/logout")
					.logoutSuccessUrl("/admin/signout")
					.invalidateHttpSession(true)
					);
		
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("admin")
				.password("")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

}
