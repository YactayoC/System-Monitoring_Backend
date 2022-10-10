package com.sist_monito_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "id_role")
   private Long idRole;

   @Column(name = "name_role")
   private String rolName;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
   @JsonBackReference
   private Set<User> users;
}
