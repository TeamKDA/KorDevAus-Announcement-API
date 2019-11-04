package org.koreandevelopersaustralia.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${admin.id}")
	private char[] adminId;
	@Value("${admin.pw}")
	private char[] adminPw;

	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
				.withUser(String.valueOf(adminId)).password(String.valueOf(adminPw)).roles("USER", "ADMIN");
//		.withUser("kdateam").password("ghwngksrnrdlsroqkfwk").roles("USER", "ADMIN");
	}

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

		http.cors().and().httpBasic().and().authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				.antMatchers("/", "/api/swag*").permitAll().antMatchers("/api/**", "/webjars/**").hasRole("USER")
				.antMatchers("/**").hasRole("ADMIN").and().csrf().disable().headers().frameOptions().disable();
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**");
//			}
//		};
//	}
}
