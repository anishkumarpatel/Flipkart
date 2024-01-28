package com.anish.golu.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
    private String title;
    private double price;
    private String category;
    private String description;
    public String getDescription(){
        return "I called " ;
    }
    private String imageUrl;
}

//  1      :  1
// Product : Category
//  m           1
//=================
//   m : 1
