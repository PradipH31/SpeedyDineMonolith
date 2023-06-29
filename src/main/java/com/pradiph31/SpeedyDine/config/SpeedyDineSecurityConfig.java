package com.pradiph31.SpeedyDine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.pradiph31.SpeedyDine.security.JWTGeneratorFilter;
import com.pradiph31.SpeedyDine.security.JWTValidatorFilter;
import com.pradiph31.SpeedyDine.security.SpeedyDineAuthenticationManager;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SpeedyDineSecurityConfig {

	private final JWTValidatorFilter validatorFilter;
	private final JWTGeneratorFilter generatorFilter;
	private final SpeedyDineAuthenticationManager speedyDineAuthenticationManager;

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		return http
				.authorizeExchange(exchanges -> exchanges.pathMatchers("/sign-up", "/userinfo").permitAll()
						.anyExchange().authenticated())
				.csrf(csrf -> csrf.disable()).addFilterAt(validatorFilter, SecurityWebFiltersOrder.AUTHENTICATION)
				.addFilterAfter(generatorFilter, SecurityWebFiltersOrder.AUTHENTICATION)
				.httpBasic(Customizer.withDefaults()).authenticationManager(speedyDineAuthenticationManager).build();
	}

}
