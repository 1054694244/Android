package com.example.ui;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //去掉自带的标题栏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        /*Button button = (Button)findViewById(R.id.button);
        EditText editText = (EditText)findViewById(R.id.edit_text);
        ImageView imageView = (ImageView)findViewById(R.id.image_view);
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        button.setOnClickListener(view->{*/
            /*String inputTxt = editText.getText().toString();
            Toast.makeText(MainActivity.this,inputTxt,Toast.LENGTH_SHORT).show();*/
            /*imageView.setImageResource(R.drawable.img_2);*/
            /*if(progressBar.getVisibility() == View.GONE){
                progressBar.setVisibility(View.VISIBLE);
            }else {
                progressBar.setVisibility(View.GONE);
            }*/
            /*int progress = progressBar.getProgress();
            progress = progress + 10;
            progressBar.setProgress(progress);*/
            /*AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("this is Dialog");
            dialog.setMessage("something important");
            dialog.setCancelable(false);
            //设置确定事件
            dialog.setPositiveButton("OK",(log,which)->{
                Toast.makeText(MainActivity.this,"nihao",Toast.LENGTH_SHORT).show();
            });
            //设置取消事件
            dialog.setNegativeButton("Cancel",(log,which)->{
                Toast.makeText(MainActivity.this,"nihao",Toast.LENGTH_SHORT).cancel();
            });
            dialog.show();*/
            /*ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Thiss is ProgressDialog");
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(true);
            progressDialog.show();*/
        /*});*/

    }
}
