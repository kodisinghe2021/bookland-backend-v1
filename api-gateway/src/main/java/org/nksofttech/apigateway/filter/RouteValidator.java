package org.nksofttech.apigateway.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

  @Value("${gateway.open-paths}")
  private List<String> openPathList;

  public Predicate<ServerHttpRequest> isSecured =
          new Predicate<ServerHttpRequest>() {
            @Override
            public boolean test(ServerHttpRequest request) {
              System.out.println("PATH::::::::::::::::::"+openPathList);
              return openPathList
                      .stream()
                      .noneMatch(new Predicate<String>() {
                        @Override
                        public boolean test(String uri) {
                          return request.getURI().getPath().contains(uri);
                        }
                      });
            }
          };
}
