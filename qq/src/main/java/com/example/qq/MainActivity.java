package com.example.qq;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private List<Msg> msgList = new ArrayList<>();

    private EditText inputText;

    private Button send;

    private RecyclerView recyclerView;

    private MsgAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //初始化消息数据
        initMsgs();

        inputText = (EditText)findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send);
        recyclerView = (RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(adapter);
        send.setOnClickListener(view->{
            String content = inputText.getText().toString();
            if(!"".equals(content)){
                Msg msg = new Msg(content,Msg.TYPE_SENT);
                msgList.add(msg);
                adapter.notifyItemInserted(msgList.size()-1);//当有新消息
                //刷新ListVIew中的显示
                recyclerView.scrollToPosition(msgList.size()-1);//将LIstView定位到最后一行
                inputText.setText("");
            }
        });
    }



    private void initMsgs(){
        Msg msg1 = new Msg("Hello guy",Msg.TYPE_RECEIVED);
        Msg msg2 = new Msg("Hello Who is that?",Msg.TYPE_SENT);
        Msg msg3 = new Msg("This is Tom.Nice talking to you",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);
    }

}
