package com.arsulegai.filereader.exception;

public enum ErrorCode {

  // @formatter:off
  Undefined(0, "Unknown Error");
  // @formatter:on

  private final int value;
  private final String reason;

  ErrorCode(int value, String reason) {
    this.value = value;
    this.reason = reason;
  }

  public int getValue() {
    return value;
  }

  public String getReason() {
    return reason;
  }
}
