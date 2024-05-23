package hs.springboot.example.openfeign.themoviedb.integration.tmdb.decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class VaultErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    log.info("VaultErrorDecoder.decode() - {}",methodKey);
    switch (response.status()){
//      case 400:
//        return new BadRequestException(HttpStatus.valueOf(response.status()));
//      case 404:
//        return new NotFoundException(HttpStatus.valueOf(response.status()));
//      case 500:
//        return new InternalServerException(HttpStatus.valueOf(response.status()));
//      case 501:
//      case 502:
//      case 503:
//        return new RetryableException(response.status(),response.reason(), response.request().httpMethod(), null,response.request());
    }
    return new Default().decode(methodKey, response);
  }
}
