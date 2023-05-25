package me.zmardil.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
    @Autowired
    private RouteValidator routeValidator;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, filterChain) -> {
            if(routeValidator.isSecured.test(exchange.getRequest())){
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) throw new RuntimeException("Missing Authorization headers");
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if(authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader.substring(7);
                }
                try {
//                    restTemplate.getForObject("lb://IDENTITY-SERVICE/api/v1/validate?token" + authHeader, String.class);
                    jwtUtil.validateToken(authHeader);
                } catch (Exception e) {
                    throw new RuntimeException("Un authorized access to application");
                }
            }
            return filterChain.filter(exchange);
        };
    }

    public static class Config {

    }

}
