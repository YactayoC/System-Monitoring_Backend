package com.sist_monito_backend.models.services;

import com.sist_monito_backend.models.entity.Client;

import java.util.List;

public interface IClientService {
   public List<Client> findAll();

}
