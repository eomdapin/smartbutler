package com.fms.smartbutler.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
//	@Autowired
//	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("test@test.com").password("{noop}1111").roles("USER")
//			.and()
//			.withUser("admin1").password("{noop}1111").roles("ADMIN");
//	}
	
	@Configuration
    @Order(1)
    public static class App1ConfigurationAdapter {
	
		@Bean
		protected SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
			http
				.securityMatcher("/admin/**")
				.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests((requests) -> requests
//					.requestMatchers("/css/**","/img/**","/admin/login","/admin/logout").permitAll()
					.requestMatchers("/**").permitAll()
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
					.requestMatchers("/**").permitAll()
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
				.passwordParameter("password")
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
   	
    @Bean
    protected static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
