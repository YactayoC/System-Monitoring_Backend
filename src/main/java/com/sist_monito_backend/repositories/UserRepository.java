package com.sist_monito_backend.repositories;

import com.sist_monito_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
