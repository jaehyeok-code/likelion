package org.example.backendproject.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class TestController {

  @GetMapping
  public ResponseEntity<ErrorResponse> test() {
    throw new RuntimeException("테스트 중 입니다.");
  }
//  @GetMapping("/test")
//  public void test(){
//    throw new RuntimeException("<UNK> <UNK>");
//  }
}
