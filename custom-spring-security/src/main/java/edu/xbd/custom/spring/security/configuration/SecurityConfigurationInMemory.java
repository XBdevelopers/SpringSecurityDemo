package edu.xbd.custom.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.xbd.custom.spring.security.util.Constants;

//@EnableWebSecurity	//Uncomment the annotation to use
public class SecurityConfigurationInMemory extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("ekta")
			.password("1234")
			.roles(Constants.ROLE_USER)
			.and()
			.withUser("parul")
			.password("dolly")
			.roles(Constants.ROLE_ADMIN);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Bye");
		http.authorizeRequests()
			.antMatchers(Constants.REST_ENDPOINT_ADMIN).hasRole(Constants.ROLE_ADMIN)
			.antMatchers(Constants.REST_ENDPOINT_USER).hasAnyRole(Constants.ROLE_USER, Constants.ROLE_ADMIN)
			.antMatchers(Constants.REST_ENDPOINT_ROOT).permitAll()
			.and()
			.formLogin();
	}
	
	
}
