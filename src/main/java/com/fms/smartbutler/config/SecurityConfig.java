package com.fms.smartbutler.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author 전종배 assisted by 엄다빈(팀장)
 * @since 2024-01-25 to 2024-01-31
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService usersService, UserDetailsService adminService, UserDetailsService companyService) throws Exception {
		auth.userDetailsService(adminService);
		auth.userDetailsService(usersService);
		auth.userDetailsService(companyService);
		
		auth.inMemoryAuthentication()
		.withUser("mail@mail.com").password("{noop}1111").roles("USER");
	}
	
	@Configuration
    @Order(1)
    public static class App1ConfigurationAdapter {
	
		@Bean
		protected SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
			http
				.securityMatcher("/admin/**")
				.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/css/**","/img/**","/admin/login","/admin/logout").permitAll()
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
				);
			http
			.formLogin(formLogin->
				formLogin
					.loginPage("/admin/login")
					.loginProcessingUrl("/admin/login")
					.defaultSuccessUrl("/",true)
					.failureUrl("/login?error=true")
					.usernameParameter("username")
					.passwordParameter("password")
			);
			http
			.logout(logout->
				logout
					.logoutUrl("/admin/logout")
					.invalidateHttpSession(true)
					);
	
			return http.build();
		}
		
	}
	
	@Configuration
	@Order(2)
	public static class App2ConfigurationAdapter {

		@Bean
		protected SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
			http
			.securityMatcher("/user/**")
			.csrf((csrf) -> csrf.disable())
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/css/**","/img/**","/user/login","/user/logout").permitAll()
				.requestMatchers("/user/**").hasRole("USER")
				.anyRequest().authenticated()
			);
			
		http
		.formLogin(formLogin->
			formLogin
				.loginPage("/user/login")
				.defaultSuccessUrl("/",true)
				.loginProcessingUrl("/user/login")
				.failureUrl("/login?error=true")
				.usernameParameter("email")
				.passwordParameter("pw")
		);
		
		http
		.logout(logout->
			logout
				.logoutUrl("/user/logout")
				.invalidateHttpSession(true)
				);

		return http.build();
	}
		
}
	
	@Configuration
	@Order(3)
	public static class App3ConfigurationAdapter {
	
		@Bean
		protected SecurityFilterChain securityFilterChain3(HttpSecurity http) throws Exception {
			http
				.securityMatcher("/worker/**")
				.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/css/**","/img/**","/worker/login","/worker/logout").permitAll()
					.requestMatchers("/worker/**").hasRole("WORKER")
					.anyRequest().authenticated()
				);
			http
			.formLogin(formLogin->
				formLogin
					.loginPage("/worker/login")
					.loginProcessingUrl("/worker/login")
					.defaultSuccessUrl("/",true)
					.failureUrl("/login?error=true")
					.usernameParameter("company-name")
					.passwordParameter("password")
			);
			http
			.logout(logout->
				logout
					.logoutUrl("/worker/logout")
					.invalidateHttpSession(true)
					);
	
			return http.build();
		}
		
	}
}

