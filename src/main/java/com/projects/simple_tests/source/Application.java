package com.projects.simple_tests.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  private static final Logger logger
      = LoggerFactory.getLogger(Application.class);

  private final Functions functions;

  public Application(Functions functions) {
    this.functions = functions;
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {

      logger.info("Let's test stuff");

      functions.encode();
      functions.decode();

    };
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


}