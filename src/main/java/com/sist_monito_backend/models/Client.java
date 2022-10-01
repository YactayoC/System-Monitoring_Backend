package com.sist_monito_backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotEmpty(message = "Can not be empty")
   @Size(min = 4, max = 12, message = "The size must be between 4 and 12 characters")
   @Column(nullable = false)
   private String firstname;

   @NotEmpty(message = "Can not be empty")
   private String lastname;

   @NotEmpty(message = "can not be empty")
   @Email(message = "It is not a valid email")
   @Column(nullable = false, unique = true)
   private String email;

   @Column(name="create_at")
   @Temporal(TemporalType.DATE)
   private Date createAt;
   @PrePersist
   public void prePersist() {
      createAt = new Date();
   }
}
