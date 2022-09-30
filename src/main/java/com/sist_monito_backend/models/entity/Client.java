package com.sist_monito_backend.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

   private String firstname;
   private String lastname;
   private String email;

   @Column(name="create_at")
   @Temporal(TemporalType.DATE)
   private Date createAt;
}
