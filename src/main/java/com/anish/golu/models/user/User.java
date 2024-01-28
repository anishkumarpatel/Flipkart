package com.anish.golu.models.user;

import com.anish.golu.models.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String email;
    private String username;
    private String password;
    private Name name;
    private Address address;
    private String phone;
}
