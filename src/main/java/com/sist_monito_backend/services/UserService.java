package com.sist_monito_backend.services;


import com.sist_monito_backend.entities.User;
import com.sist_monito_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;

   @Transactional(readOnly = true)
   public List<User> findAll() {
      return userRepository.findAll();
   }

   @Transactional(readOnly = true)
   public User findById(Long id) {
      return userRepository.findById(id).orElse(null);
   }

   @Transactional()
   public void save(User client) {
      userRepository.save(client);
   }

   @Transactional
   public void delete(Long id) {
      userRepository.deleteById(id);
   }
}
