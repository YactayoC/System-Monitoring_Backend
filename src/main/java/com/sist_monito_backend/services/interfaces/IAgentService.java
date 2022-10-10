package com.sist_monito_backend.services.interfaces;

import com.sist_monito_backend.entities.Agent;

import java.util.List;
import java.util.Optional;

public interface IAgentService {
   List<Agent> findAll();

   Agent findById(Long id);

   Optional<Agent> findByEmail(String email);

   void save(Agent agent);

   void delete(Long id);
}
