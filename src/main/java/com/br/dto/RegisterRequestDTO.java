package com.br.dto;

import com.br.domain.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterRequestDTO {

  @NotBlank(message = "Nome é obrigatorio")
  @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
  private String name;

  @NotBlank(message = "Email é obrigatorio")
  @Email(message = "Email invalido")
  private String email;

  @NotBlank(message = "Senha é obrigatorio")
  @Size(min = 6, message = "Senha deve ter no minimo 6 caracteres")
  private String password;

  @NotNull(message = "Cargo é obrigatorio")
  private UserRole role;

  public RegisterRequestDTO() {}

  public RegisterRequestDTO(String name, String email, String password, UserRole role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }
}
