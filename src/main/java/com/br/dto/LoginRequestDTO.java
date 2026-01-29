package com.br.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class LoginRequestDTO {

  @NotNull(message = "Email é obrigatorio")
  @Email(message = "Email invalido")
  private String email;

  @NotNull(message = "Senha é obrigatorio")
  private String password;

  public LoginRequestDTO() {}

  public LoginRequestDTO(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
