package com.sist_monito_backend.controllers;

import com.sist_monito_backend.entities.User;
import com.sist_monito_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/user")
public class UserController {
   @Autowired
   private UserService userService;

   @GetMapping("/users")
   public List<User> getUsers(){
      return userService.findAll();
   }
}
