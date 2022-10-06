package com.sist_monito_backend.controllers;

import com.sist_monito_backend.entities.Agent;
import com.sist_monito_backend.services.AgentService;
import com.sist_monito_backend.utils.ValidateErrorsFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ClientController {
//   ValidateErrorsFields validateErrorsFields = new ValidateErrorsFields();

   @Autowired
   private AgentService agentService;


   @GetMapping("/agents")
   public List<Agent> listAgents() {
      return agentService.findAll();
   }

   @PostMapping("/agents")
   public ResponseEntity<String> saveEmployees(@RequestBody Agent agent) {
      agentService.save(agent);
      return ResponseEntity.ok("Employees saved");
   }

   @GetMapping("/agents/{id}")
   public ResponseEntity<?> show(@PathVariable Long id) {
      Map<String, Object> response = new HashMap<>();
      Agent client;

      try {
         client = agentService.findById(id);

         if (client == null) {
            response.put("message", "Client ID: ".concat(id.toString().concat(" does not exist")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
         }

         return new ResponseEntity<>(client, HttpStatus.OK);
      } catch (DataAccessException e) {
         response.put("message", "Error when querying in the database");
         response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
         return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }
//
//   @PostMapping("/clients")
//   public ResponseEntity<?> create(@Valid @RequestBody Agent client, BindingResult result) {
//      Map<String, Object> response = new HashMap<>();
//      Agent clientNew;
//
//      if (validateErrorsFields.validateErrors(result, response))
//         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
//
//      try {
//         clientNew = agentService.save(client);
//         response.put("message", "Client created successfully");
//         response.put("client", clientNew);
//         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
//      } catch (DataAccessException e) {
//         response.put("message", "Error inserting into database");
//         response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//      }
//
//   }
//
//   @PutMapping("/clients/{id}")
//   public ResponseEntity<?> update(@Valid @RequestBody Agent client, BindingResult result, @PathVariable Long id) {
//      Map<String, Object> response = new HashMap<>();
//      Agent currentClient = agentService.findById(id);
//      Agent updatedClient;
//
//      if (validateErrorsFields.validateErrors(result, response))
//         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
//
//      try {
//         if (currentClient == null) {
//            response.put("message", "Error: cannot edit, client ID: ".concat(id.toString().concat(" does not exist")));
//            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//         }
//
////         currentClient.setFirstname(client.getFirstname());
////         currentClient.setLastname(client.getLastname());
//         currentClient.setEmail(client.getEmail());
//         updatedClient = agentService.save(currentClient);
//
//         response.put("message", "Client updated successfully");
//         response.put("client", updatedClient);
//         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
//      } catch (DataAccessException e) {
//         response.put("message", "Error updating client in the database");
//         response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//      }
//   }
//
//   @DeleteMapping("/clients/{id}")
//   @ResponseStatus(HttpStatus.NO_CONTENT)
//   public ResponseEntity<?> delete(@PathVariable Long id) {
//      Map<String, Object> response = new HashMap<>();
//
//      try {
//         agentService.delete(id);
//
//         response.put("message", "Client deleted successfully");
//         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//      } catch (DataAccessException e) {
//         response.put("message", "Error deleting client in the database");
//         response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//      }
//   }

}
