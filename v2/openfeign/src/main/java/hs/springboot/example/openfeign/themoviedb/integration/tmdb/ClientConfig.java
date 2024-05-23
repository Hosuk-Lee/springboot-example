package hs.springboot.example.openfeign.themoviedb.integration.tmdb;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import hs.springboot.example.openfeign.themoviedb.integration.tmdb.decoder.CustomerErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ClientConfig {
//  @Value("${vault.access_token}")
//  private String vaultToken;

  @Bean
  public RequestInterceptor requestInterceptor() {
    return requestTemplate -> {
      requestTemplate.header("Content-Type", "application/json");
      requestTemplate.header("Accept", "application/json");
//      requestTemplate.header("X-Auth-Token", vaultToken);
      requestTemplate.query("api_key", "9eab0cb41794f03056996633ed1f951b");
    };
  }

  @Bean
  public ErrorDecoder errorDecoder(){
    return new CustomerErrorDecoder();
  }

  @Bean
  Logger.Level loggerLevel() {
    return Logger.Level.FULL;
  }
}
