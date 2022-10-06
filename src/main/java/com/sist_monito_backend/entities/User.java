package com.sist_monito_backend.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

   @Id
   @Column(name = "id_user")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idUser;

   @NotEmpty(message = "can not be empty")
   @Email(message = "It is not a valid email")
   @Column(nullable = false, unique = true)
   private String email;

   @NotEmpty(message = "can not be empty")
   @Size(min = 6, max = 12, message = "The size must be between 6 and 12 characters")
   @Column(nullable = false)
   private String password;

   @Column(name = "created_at")
   @Temporal(TemporalType.DATE)
   private Date createdAt;

   @PrePersist
   public void prePersist() {
      createdAt = new Date();
   }

   @OneToOne(mappedBy = "user")
   @JsonBackReference
   private Agent agent;
}
