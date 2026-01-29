package com.br.dto;

import com.br.domain.UserRole;
import java.time.LocalDateTime;

public class UserResponseDTO {

  private Long id;

  private String name;

  private String email;

  private UserRole role;

  private Boolean active;

  private LocalDateTime creatAt;

  public UserResponseDTO() {}

  public UserResponseDTO(
      Long id, String name, String email, UserRole role, Boolean active, LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.role = role;
    this.creatAt = createdAt;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public UserRole getRole() {
    return role;
  }

  public Boolean getActive() {
    return active;
  }

  public LocalDateTime getCreatAt() {
    return creatAt;
  }
}
