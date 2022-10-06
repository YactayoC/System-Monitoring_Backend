package com.sist_monito_backend.services;

import com.sist_monito_backend.repositories.AgentRepository;
import com.sist_monito_backend.entities.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgentService {
   @Autowired
   private AgentRepository agentRepository;

   @Transactional(readOnly = true)
   public List<Agent> findAll() {
      return agentRepository.findAll();
   }

   @Transactional(readOnly = true)
   public Agent findById(Long id) {
      return agentRepository.findById(id).orElse(null);
   }

   @Transactional()
   public Agent save(Agent client) {
      return agentRepository.save(client);
   }

   @Transactional
   public void delete(Long id) {
      agentRepository.deleteById(id);
   }
}
