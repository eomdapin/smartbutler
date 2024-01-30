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
public class AdminSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf((csrf) -> csrf.disable())
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/**").permitAll()
				.anyRequest().authenticated()
			);
		http
			.formLogin((form) -> form
			.loginPage("/admin/login")
			.permitAll()
			);
		http
		.formLogin(formLogin->
			formLogin
				.loginPage("/admin/login")
				.defaultSuccessUrl("/",true)
				.failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
				.loginProcessingUrl("/admin/login")
		);
		http
		.logout(logout->
			logout
				.logoutUrl("/admin/logout")
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
	
//	   @Configuration
//	    @Order(1)
//	    public static class App1ConfigurationAdapter {
//
//	        @Bean
//	        public SecurityFilterChain filterChainApp1(HttpSecurity http) throws Exception {
//	            http
//	            	.csrf((csrf)->csrf.disable())
//	                .authorizeHttpRequests((authorizeRequest) ->
//	                	authorizeRequest
//	                		.requestMatchers("/").permitAll()
//	                		.anyRequest().authenticated());
//	            
//	            http
//				.formLogin(formLogin->
//					formLogin
//						.loginPage("/signin")
//						.defaultSuccessUrl("/success",true)
//						.failureUrl("/login?error=true")
//						.usernameParameter("username")
//						.passwordParameter("password")
//						.loginProcessingUrl("/signin")
//				);
//			
//				http
//					.logout(logout->
//						logout
//							.logoutUrl("/logout")
//							.logoutSuccessUrl("/signout")
//							.invalidateHttpSession(true)
//							);
//					
//				return http.build();
//	        }
//	        
//	        @Bean
//	        public UserDetailsService userDetailsServiceApp1() {
//	             UserDetails user = User.withUsername("admin")
//	                 .password("")
//	                 .roles("ADMIN")
//	                 .build();
//	             return new InMemoryUserDetailsManager(user);
//	        }
//	    }
//	   
//	   @Configuration
//	    @Order(2)
//	    public static class App2ConfigurationAdapter {
//
//	        @Bean
//	        public SecurityFilterChain filterChainApp2(HttpSecurity http) throws Exception {
//	        	http
//            	.csrf((csrf)->csrf.disable())
//                .authorizeHttpRequests((authorizeRequest) ->
//                	authorizeRequest
//                		.requestMatchers("/").permitAll()
//                		.anyRequest().authenticated());
//            
//	            http
//				.formLogin(formLogin->
//					formLogin
//						.loginPage("/signin")
//						.defaultSuccessUrl("/success",true)
//						.failureUrl("/login?error=true")
//						.usernameParameter("username")
//						.passwordParameter("password")
//						.loginProcessingUrl("/signin")
//				);
//			
//				http
//					.logout(logout->
//						logout
//							.logoutUrl("/logout")
//							.logoutSuccessUrl("/signout")
//							.invalidateHttpSession(true)
//							);
//					
//				return http.build();
//        }
//	        
//	        @Bean
//	        public UserDetailsService userDetailsServiceApp1() {
//	             UserDetails user = User.withUsername("user")
//	                 .password("")
//	                 .roles("USER")
//	                 .build();
//	             return new InMemoryUserDetailsManager(user);
//	        }
//	    }
	
	

}
