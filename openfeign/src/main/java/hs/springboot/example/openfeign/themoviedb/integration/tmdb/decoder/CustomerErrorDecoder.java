package hs.springboot.example.openfeign.themoviedb.integration.tmdb.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import hs.springboot.example.openfeign.themoviedb.infra.dto.element.ErrorCode;
import hs.springboot.example.openfeign.themoviedb.infra.dto.element.TreatCode;
import hs.springboot.example.openfeign.themoviedb.infra.exception.BusinessException;
import hs.springboot.example.openfeign.themoviedb.infra.utility.ObjectUtil;
import hs.springboot.example.openfeign.themoviedb.integration.tmdb.ExceptionResponse;
import java.io.IOException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class CustomerErrorDecoder implements ErrorDecoder {
  private final String RESPONSE_CODE_400 = "INVALID_ARGUMENT";
  private final String RESPONSE_CODE_409 = "ALREADY_EXISTS";
  @Override
  public Exception decode(String methodKey, Response response) {
    final HttpStatus responseStatus = HttpStatus.resolve(response.status());
    log.info("[Caller] {}", methodKey);
    log.info("[ResponseStatus] {}", responseStatus);

    ObjectUtil.logObjectToJson(response);
    if(response.body() == null) return new Default().decode(methodKey, response);

    //Response Code 확인위해 Response의 body ExceptionResponse 객체로 변환
    ExceptionResponse exceptionResponse = null;
    try (InputStream bodyData = response.body().asInputStream()) {
      ObjectMapper mapper = new ObjectMapper();
      exceptionResponse = mapper.readValue(bodyData, ExceptionResponse.class);
      log.info("[ResponseMessage] {} [ResponseCode] {}"
              ,exceptionResponse.getCode()
              ,exceptionResponse.getMessage());
      return new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR, TreatCode.BLANK,
              exceptionResponse.getCode() +":"+ exceptionResponse.getMessage());
    } catch (IOException e) {
      log.error("Read conflict response body exception. {}", e.toString());
      return new Exception(e.getMessage());
    }

    //CONFLICT Error일때
    /*
    if(HttpStatus.CONFLICT.equals(responseStatus)){
      //Response Code == ALREADY_EXISTS 일때 ResponseStatusException 발생
      if(RESPONSE_CODE_409.equals(exceptionResponse.getCode())){
        return new ResponseStatusException(HttpStatus.CONFLICT, response.reason());
      }
    }




    */
//    return new Default().decode(methodKey, response);
  }
}
