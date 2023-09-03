package hs.springboot.example.openfeign.themoviedb.integration.tmdb;

import java.util.ArrayList;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ExceptionResponse {
  String message;
  String code;
  ArrayList<Object> details;
  String vault_error_code;
  String tracing_id;
}
