package com.example.listviewtest;

import lombok.Data;

@Data
public class Fruit {

    private String name;

    private String imageId;


    public Fruit(String name,String imageId){
        this.name = name;
        this.imageId = imageId;
    }

}
