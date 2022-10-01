package com.sist_monito_backend.utils;

import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidateErrorsFields {
   public boolean validateErrors(BindingResult result, Map<String, Object> response) {
      if (result.hasErrors()) {
         List<String> errors = result.getFieldErrors()
                 .stream()
                 .map(err -> "The field" + err.getField() + " " + err.getDefaultMessage()).collect(Collectors.toList());

         response.put("message", errors);
         return true;
      }
      return false;
   }
}
