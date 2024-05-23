package hs.springboot.example.openfeign.themoviedb.infra.advice;



import static hs.springboot.example.openfeign.themoviedb.infra.dto.element.ErrorCode.INTERNAL_SERVER_ERROR;

import hs.springboot.example.openfeign.themoviedb.infra.dto.CommonErrorResponse;
import hs.springboot.example.openfeign.themoviedb.infra.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = BusinessException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CommonErrorResponse handleBadRequestBusinessException(
          BusinessException exception, HttpServletRequest request) {
    return CommonErrorResponse.createErrorResponse(exception, request);
  }

//  @ExceptionHandler(MethodArgumentNotValidException.class)
//  public ResponseEntity<CommonErrorResponse> handleArgNotValidException(
//          MethodArgumentNotValidException exception,
//          HttpServletRequest request) {
//    return new ResponseEntity<>(
//            CommonErrorResponse.createErrorResponse(exception, request, INVALID_ARGUMENT),
//            exception.get);
//  }
//
  @ExceptionHandler(Exception.class)
  public ResponseEntity<CommonErrorResponse> handleException(Exception exception,
          HttpServletRequest request) {
    return new ResponseEntity<>(
            CommonErrorResponse.createErrorResponse(exception, request, INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
