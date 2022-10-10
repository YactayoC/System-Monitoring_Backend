package com.sist_monito_backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Transactional
@NoArgsConstructor
@Table(name = "agents")
public class Agent implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "id_agent")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idAgent;

   @NotEmpty(message = "Can not be empty")
   @Size(min = 4, max = 12, message = "The size must be between 4 and 12 characters")
   @Column(nullable = false)
   private String fullname;

   @NotEmpty(message = "Can not be empty")
   private String dni;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "id_user")
   @JsonManagedReference
   private User user;
}
