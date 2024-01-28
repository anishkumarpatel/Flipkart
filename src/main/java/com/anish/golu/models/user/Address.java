package com.anish.golu.models.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String city;
    private String street;
    private int number;
    private String zipcode;
}
