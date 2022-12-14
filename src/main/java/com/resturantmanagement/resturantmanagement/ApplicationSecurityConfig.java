package com.resturantmanagement.resturantmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/").hasAnyAuthority("ADMIN")
		.antMatchers("/**/findAll/**").hasAnyAuthority("ADMIN","CREATOR","EDITOR","USER")
		.antMatchers("/**/create/**").hasAnyAuthority("ADMIN","CREATOR")	
		.antMatchers("/**/update/**").hasAnyAuthority("ADMIN","EDITOR")
		.antMatchers("/**/delete/**").hasAnyAuthority("ADMIN")
		.antMatchers(
				"/login", 
				"/resources/**", 
				"/css/**", 
				"/fonts/**", 
				"/img/**",
				"/assets/**").permitAll()
		.antMatchers(
				"/register", 
				"/resources/**", 
				"/css/**", 
				"/fonts/**", 
				"/img/**",
				"/assets/**").permitAll()
		.antMatchers("/user/addNew").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.failureUrl("/login-error")
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login").permitAll();
	}
	
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
	
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		
		provider.setPasswordEncoder(PasswordEncoder());
		
		return provider;
				
	}
	

}
