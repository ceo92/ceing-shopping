package ceing.ceing;

import ceing.ceing.exception.DuplicateLoginIdException;
import ceing.ceing.exception.PasswordMismatchException;
import lombok.Data;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {



  @Data //이건 api 방식일 때 유용할듯?
  static class ErrorPage{
    private String code;
    private String message;
  }

}
