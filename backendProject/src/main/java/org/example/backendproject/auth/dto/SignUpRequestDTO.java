package org.example.backendproject.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDTO {

  private String userid;
  private String username;
  private String password;
  private String email;
  private String phone;
  private String address;

}
