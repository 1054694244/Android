package com.example.recyclerviewtest;




public class Fruit {

    private int fruitImageId;

    private String fruitName;

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitImageId() {
        return fruitImageId;
    }

    public Fruit(String fruitName,int fruitImageId){
        this.fruitImageId = fruitImageId;
        this.fruitName = fruitName;
    }

}
