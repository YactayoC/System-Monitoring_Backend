package com.sist_monito_backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "agent")
public class Agent implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idAgent;

   private Long idUser;

   @NotEmpty(message = "Can not be empty")
   @Size(min = 4, max = 12, message = "The size must be between 4 and 12 characters")
   @Column(nullable = false)
   private String fullName;

   @NotEmpty(message = "Can not be empty")
   private String dni;

   @NotEmpty(message = "can not be empty")
   @Email(message = "It is not a valid email")
   @Column(nullable = false, unique = true)
   private String email;

   @OneToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "idUser")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private User user;
}
