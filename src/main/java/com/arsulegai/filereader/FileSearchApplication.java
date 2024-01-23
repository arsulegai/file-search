package com.arsulegai.filereader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FileSearchApplication {
  public static void main(String[] args) {
    SpringApplication.run(FileSearchApplication.class, args);
  }
}
