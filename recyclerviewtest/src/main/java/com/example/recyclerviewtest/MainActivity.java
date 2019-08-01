/*
package com.example.recyclerviewtest;

import android.os.Bundle;

import android.support.v7.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //初始化水果数据
        initFruits();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruits);
        recyclerView.setAdapter(adapter);

    }


    private void initFruits() {
        for (int i=0;i<4;i++){
            Fruit apple = new Fruit("Apple",R.drawable.apple_pic);
            fruits.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.banana_pic);
            fruits.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.orange_pic);
            fruits.add(orange);
            fruits.add(banana);
            Fruit watermelon = new Fruit("Watermelon",R.drawable.watermelon_pic);
            fruits.add(watermelon);
        }
    }

}
*/
