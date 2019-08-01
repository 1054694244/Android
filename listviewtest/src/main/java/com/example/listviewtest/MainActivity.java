package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"Apple","Banana","Orange","Watermelon","Pear",
    "Grape","Pineapple","Orange","Apple","Banana","Orange","Watermelon","Pear",
            "Grape","Pineapple","Orange"};


    private List<Fruit> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //初始化水果数据
        initFruits();

        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruits);

        /*ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,data);*/
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((AdapterView<?> parent, View view,int position,long id)->{
            Fruit fruit = fruits.get(position);
            Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
        });
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
