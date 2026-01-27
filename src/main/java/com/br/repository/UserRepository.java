package com.br.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
