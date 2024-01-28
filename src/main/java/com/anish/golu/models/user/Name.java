package com.anish.golu.models.user;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Name {
    private String firstname;
    private String lastname;
}
