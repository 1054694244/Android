package com.example.networktest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.send_request);
        responseText = findViewById(R.id.response_text);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.send_request){
            //sendRequestWithHttpURLConnection();
            sendRequestWithOkHttp();
        }
    }

    private void sendRequestWithOkHttp(){
        new Thread(()->{
            try{
                OkHttpClient client = new OkHttpClient();
                //如果是post请求
                /*ResponseBody body = new FormBody.Builder()
                        .add("username","admin")
                        .add("password","123456")
                        .build();*/
                Request request = new Request.Builder()
                        .url("https://www.baidu.com")
                        .build();
                Response response = client.newCall(request).execute();
                String responseData = response.body().string();
                showResponse(responseData);
            }catch (IOException e){
                e.printStackTrace();
            }finally {

            }
        }).start();
    }

    private void sendRequestWithHttpURLConnection(){
        //开启线程来发起网络请求
        new Thread(()->{
            HttpURLConnection connection =null;
            BufferedReader reader = null;
            try{
                URL url = new URL("https://www.baidu.com");
                connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                InputStream in = connection.getInputStream();
                //对获取到输入流进行读取
                reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine())!=null){
                    sb.append(line);
                }
                showResponse(sb.toString());
            }catch (IOException e){
                if (reader != null){
                    try{
                        reader.close();
                    }catch (IOException e1){
                        e1.printStackTrace();
                    }
                }
                if(connection != null){
                    connection.disconnect();
                }
            }
        }).start();
    }

    private void showResponse(final String response){
        runOnUiThread(()->{
            //在这里进行UI操作，将结果显示到界面上
            responseText.setText(response);
        });
    }

}
