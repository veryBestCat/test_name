package com.example.demo.dto;


import lombok.Value;


@Value(staticConstructor = "of")
public class User {
   private Integer id;
   private String password;
   private String userName;
}
