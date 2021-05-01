package com.graphql.sample.boot;

import graphql.kickstart.servlet.core.GraphQLServletListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class GraphQLToolsSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(GraphQLToolsSampleApplication.class, args);
  }

  @Bean
  public GraphQLServletListener listener() {
    return new GraphQLServletListener() {
      @Override
      public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("Start request");
        return new RequestCallback() {
          @Override
          public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
            log.info("Success");
          }

          @Override
          public void onError(HttpServletRequest request, HttpServletResponse response,
              Throwable throwable) {
            RequestCallback.super.onError(request, response, throwable);
          }

          @Override
          public void onFinally(HttpServletRequest request, HttpServletResponse response) {
            log.info("Finally");
          }
        };
      }
    };
  }
}
