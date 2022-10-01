package com.sist_monito_backend.services;

import com.sist_monito_backend.models.Client;

import java.util.List;

public interface IClientService {
   public List<Client> findAll();

   public Client findById(Long id);

   public Client save(Client client);

   public void delete(Long id);

}
