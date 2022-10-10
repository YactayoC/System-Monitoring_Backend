package com.sist_monito_backend.controllers;

import com.sist_monito_backend.entities.Agent;
import com.sist_monito_backend.entities.User;
import com.sist_monito_backend.services.interfaces.IAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RequestMapping("/api/auth")
@RestController
public class AuthController {
   @Autowired
   private IAgentService agentService;

   @PostMapping("/login")
   public ResponseEntity<?> loginAgent(@RequestBody User user) {
      Map<String, Object> response = new HashMap<>();
      Optional<Agent> agentLogin;

      try {
         agentLogin = agentService.findByEmail(user.getEmail());

         if (agentLogin.isEmpty()) {
            response.put("message", "User does not exist");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
         }

         response.put("agent", agentLogin);
         return new ResponseEntity<>(response, HttpStatus.OK);
      } catch (DataAccessException e) {
         response.put("message", "Error deleting client in the database");
         return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }
}
