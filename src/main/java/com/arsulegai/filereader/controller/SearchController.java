package com.arsulegai.filereader.controller;

import com.arsulegai.filereader.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
  @Autowired private SearchService searchService;

  @GetMapping(value = "/search")
  public boolean search(@RequestParam("q") @Validated String query) {
    return searchService.search(query);
  }
}
