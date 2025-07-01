package org.example.backendproject.board.searchlog.repository;

import org.example.backendproject.board.searchlog.domain.SearchLogDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchLogEsRepository extends ElasticsearchRepository<SearchLogDocument,String> {

  //엘라스틱서치 저장/검색 레포지토리

}
