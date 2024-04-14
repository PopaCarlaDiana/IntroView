package com.example.polihack2.security.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class SignupRequest {
  private String username;
  private String password;
  private Set<String> roles;
}

/*
{
  username: "blabla",
  password: "123123123",
  roles: [MANAGER,CUSTOMER]
}
 */