package org.example.backendproject.board.searchlog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLogMessage {

  // 카프카로 주고받는 메세지 포맷(DTO

  private String keyword; // 검색한 키워드
  private String userId;  // 검색한 유저 ID
  private String searchedAt;  // 검색한 시간


}
