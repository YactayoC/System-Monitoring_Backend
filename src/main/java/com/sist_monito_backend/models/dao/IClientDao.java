package com.sist_monito_backend.models.dao;

import com.sist_monito_backend.models.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface IClientDao extends CrudRepository<Client, Long> {

}
