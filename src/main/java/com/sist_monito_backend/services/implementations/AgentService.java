package com.sist_monito_backend.services.implementations;

import com.sist_monito_backend.repositories.AgentRepository;
import com.sist_monito_backend.entities.Agent;
import com.sist_monito_backend.services.interfaces.IAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService implements IAgentService {
   @Autowired
   private AgentRepository agentRepository;

   @Transactional(readOnly = true)
   @Override
   public List<Agent> findAll() {
      return agentRepository.findAll();
   }

   @Transactional(readOnly = true)
   @Override
   public Agent findById(Long id) {
      return agentRepository.findById(id).orElse(null);
   }

   @Override
   public Optional<Agent> findByEmail(String email) {
      return agentRepository.findByEmail(email);
   }


   @Transactional()
   @Override
   public void save(Agent agent) {
      agentRepository.save(agent);
   }

   @Transactional
   @Override
   public void delete(Long id) {
      agentRepository.deleteById(id);
   }
}
