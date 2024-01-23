package com.arsulegai.filereader.service.impl;

import static org.elasticsearch.index.query.QueryBuilders.regexpQuery;

import com.arsulegai.filereader.model.AppFileUnwrapped;
import com.arsulegai.filereader.service.SearchService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

/** Serves the needs of the controllers and other scheduling logic of the reader service. */
@Service
@Slf4j
public class SearchServiceImpl implements SearchService {

  @Autowired private ElasticsearchRestTemplate elasticsearchTemplate;

  @Override
  public List<String> search(String query) {
    // TODO: perform input validation
    Query nativeSearchQuery =
        new NativeSearchQueryBuilder()
            .withFilter(regexpQuery("content", ".*" + query + ".*"))
            .build();
    SearchHits<AppFileUnwrapped> foundAppFiles =
        elasticsearchTemplate.search(nativeSearchQuery, AppFileUnwrapped.class);
    // find the file path with some information of the file
    List<String> files =
        foundAppFiles.stream()
            .map(searchHit -> searchHit.getContent().getAppFile().getPath())
            .collect(Collectors.toList());
    return files;
  }
}
