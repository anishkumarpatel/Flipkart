package com.anish.golu.models.user;

import com.anish.golu.models.BaseModel;
import jakarta.persistence.Embedded;
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
    @Embedded
    private Name name;
    @Embedded
    private Address address;
    private String phone;
}
