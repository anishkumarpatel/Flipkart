package com.anish.golu.inheritancedemo.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "tbc_user")
public class User {
    @Id
    private Long id;
    private String name;
    private  String email;
}
