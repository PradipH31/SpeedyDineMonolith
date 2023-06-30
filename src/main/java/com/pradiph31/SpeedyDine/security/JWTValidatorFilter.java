package com.pradiph31.SpeedyDine.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;

@Component
public class JWTValidatorFilter implements WebFilter {

	@Value("${application.security.jwt.secret-key}")
	private String secretKey;

	@Autowired
	private ServerWebExchangeMatcher speedyDineUserInfoRequestMatcher;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		return speedyDineUserInfoRequestMatcher.matches(exchange).flatMap(result -> {
			if (result.isMatch()) {
				return chain.filter(exchange);
			}
			String jwt = exchange.getRequest().getHeaders().getFirst("Authorization");
			if (jwt != null) {
				try {
					SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
					Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
					String username = String.valueOf(claims.get("username"));
					String authorities = (String) claims.get("authorities");
					Authentication auth = new UsernamePasswordAuthenticationToken(username, null,
							AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
					return chain.filter(exchange).contextWrite(ReactiveSecurityContextHolder.withAuthentication(auth));
				} catch (Exception e) {
					return handleInvalidCredentials(exchange.getResponse());
				}
			}
			return chain.filter(exchange);
		});
	}

	private Mono<Void> handleInvalidCredentials(ServerHttpResponse response) {
		response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
		response.setStatusCode(HttpStatus.BAD_REQUEST);
		return response.writeWith(Mono.just(response.bufferFactory().wrap("Invalid credentials provided".getBytes())));
	}
}
