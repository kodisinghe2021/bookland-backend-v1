package org.nksofttech.apigateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

  public AuthenticationFilter() {
    super(Config.class);
    System.out.println("Component executed");
  }

  @Autowired
  private RouteValidator routeValidator;

  @Override
  public GatewayFilter apply(Config config) {
    return (new GatewayFilter() {
      @Override
      public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (routeValidator.isSecured.test(exchange.getRequest())) {
          if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            throw new RuntimeException("missing authorization header");
          }
            String authheader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
          if (authheader != null && authheader.startsWith("Bearer ")) ;
          {
            authheader = authheader.substring(7);
            System.out.println("its working" + authheader);
          }
        }
        return chain.filter(exchange);
      }
    });
  }
  public static class Config{

  }
}
