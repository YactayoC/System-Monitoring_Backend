package com.sist_monito_backend.repositories;

import com.sist_monito_backend.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface IClientRepository extends CrudRepository<Client, Long> {

}
