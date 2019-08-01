package com.example.listviewtest;

import lombok.Data;

@Data
public class Fruit {

    private String name;

    private int imageId;


    public Fruit(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

}
