package com.example.springdatajpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
@Data
public class User
{
   @Id
   @GeneratedValue(generator = "idGenerator")
   @GenericGenerator(name = "idGenerator",strategy = "org.hibernate.id.UUIDGenerator")
   private  String id;

   @Column(name = "username",unique = true,nullable = false,length = 64)
    private String userName;

   @Column(name = "password",nullable =false,length =64)
    private String password;

   @Column(name = "email",length =64)
    private String email;

}
