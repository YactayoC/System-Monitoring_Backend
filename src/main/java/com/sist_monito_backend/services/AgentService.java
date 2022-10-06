package com.sist_monito_backend.services;

import com.sist_monito_backend.repositories.IClientRepository;
import com.sist_monito_backend.entities.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService implements IClientService {
   @Autowired
   private IClientRepository clientRepository;

   @Override
   @Transactional(readOnly = true)
   public List<Agent> findAll() {
      return (List<Agent>) clientRepository.findAll();
   }

   @Override
   @Transactional(readOnly = true)
   public Agent findById(Long id) {
      return clientRepository.findById(id).orElse(null);
   }

   @Override
   @Transactional()
   public Agent save(Agent client) {
      return clientRepository.save(client);
   }

   @Override
   @Transactional
   public void delete(Long id) {
      clientRepository.deleteById(id);
   }
}
