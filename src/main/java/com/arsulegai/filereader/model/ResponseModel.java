package com.arsulegai.filereader.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseModel {
  private Object payload;
  private ErrorInfo errorInfo;

  @Data
  @Builder
  public static class ErrorInfo {
    private int errorCode;
    private String message;
  }
}
