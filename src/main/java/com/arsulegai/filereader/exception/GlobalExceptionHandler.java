package com.arsulegai.filereader.exception;

import com.arsulegai.filereader.model.ResponseModel;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(BaseException.class)
  private ResponseEntity<ResponseModel> handleTransactionException(
      HttpServletRequest request, Throwable cause) {
    log.error("request {}", request.getRequestURL());
    log.error(String.valueOf(cause));

    int code = 0;
    String message = "";
    if (cause instanceof BaseException) {
      code = ((BaseException) cause).getCode().getValue();
      message = cause.getMessage();
    }
    ResponseModel responseModel =
        ResponseModel.builder()
            .errorInfo(ResponseModel.ErrorInfo.builder().errorCode(code).message(message).build())
            .build();
    return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
