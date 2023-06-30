package com.pradiph31.SpeedyDine.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import reactor.core.publisher.Mono;

@Component
public class JWTGeneratorFilter implements WebFilter {

	@Value("${application.security.jwt.secret-key}")
	private String secretKey;

	@Value("${application.security.jwt.expiration}")
	private Long expiryDuration;

	@Autowired
	private ServerWebExchangeMatcher speedyDineUserInfoRequestMatcher;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		return speedyDineUserInfoRequestMatcher.matches(exchange).flatMap(result -> {
			if (!result.isMatch()) {
				return chain.filter(exchange);
			}
			return exchange.getPrincipal().cast(Authentication.class).flatMap(authentication -> {
				SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
				Set<String> authoritiesSet = new HashSet<>();
				for (GrantedAuthority authority : authentication.getAuthorities()) {
					authoritiesSet.add(authority.getAuthority());
				}
				String authorities = String.join(",", authoritiesSet);
				String jwt = Jwts.builder().setIssuer("Pradip Hamal").setSubject("JWT Token")
						.claim("username", authentication.getName()).claim("authorities", authorities)
						.setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + expiryDuration))
						.signWith(key).compact();
				exchange.getResponse().getHeaders().set("Authorization", jwt);
				return Mono.empty();
			}).then(chain.filter(exchange));
		});
	}

}
