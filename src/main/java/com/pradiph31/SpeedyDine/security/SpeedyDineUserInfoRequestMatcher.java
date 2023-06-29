package com.pradiph31.SpeedyDine.security;

import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class SpeedyDineUserInfoRequestMatcher implements ServerWebExchangeMatcher {

	@Override
	public Mono<MatchResult> matches(ServerWebExchange exchange) {
		if (exchange.getRequest().getPath().toString().equals("/userinfo")) {
			return MatchResult.match();
		} else {
			return MatchResult.notMatch();
		}
	}

}
