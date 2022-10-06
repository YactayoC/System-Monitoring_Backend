package com.sist_monito_backend.repositories;

import com.sist_monito_backend.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
