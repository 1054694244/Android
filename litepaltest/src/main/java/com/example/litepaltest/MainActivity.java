package com.example.litepaltest;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = findViewById(R.id.button);
        createDatabase.setOnClickListener(view->{
            Connector.getDatabase();
        });
        Button addData = findViewById(R.id.add_data);
        addData.setOnClickListener(view->{
            Book book = new Book();
            book.setName("Shen Zhi Chao");
            book.setAuthor("Shen");
            book.setPages(555);
            book.setPrice(17.18);
            book.setPress("Unknow");
            book.save();
        });
        Button updateDate = findViewById(R.id.update_data);
        updateDate.setOnClickListener(view->{
            Book book = new Book();
            book.setPrice(888.88);
            book.updateAll("name=? and author=?","Shen Zhi Chao","Shen");
        });
        Button deleteButton = findViewById(R.id.delete_data);
        deleteButton.setOnClickListener(view->{
            DataSupport.deleteAll(Book.class,"price<?","15");
        });
        Button queryButton = findViewById(R.id.query_data);
        queryButton.setOnClickListener(view->{
            List<Book> all = DataSupport.findAll(Book.class);
            for (Book book:all) {
                System.out.println(book);
            }
        });
    }
}
