package com.globallogic;

import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiceServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DiceServiceApplication.class, args);
  }

  @Bean
  public Random getRandom() {
    return new Random();
  }
}
