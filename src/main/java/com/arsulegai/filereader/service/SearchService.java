package com.arsulegai.filereader.service;

import java.util.List;

public interface SearchService {

  /**
   * accepts the query parameter and return the result
   *
   * @param query the input parameter
   * @return result
   */
  List<String> search(String query);
}
