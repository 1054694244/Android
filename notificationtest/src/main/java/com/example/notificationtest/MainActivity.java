package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(view->{
            switch (view.getId()){
                case R.id.send_notice:
                    NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                    Intent intent = new Intent(this,NotificationActivity.class);
                    PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);

                    Notification notification = new NotificationCompat.Builder(this)
                            .setContentTitle("This is content title")
                            .setContentText("This is content text,This is content text,This is content text,This is content text,This is content text" +
                                    "This is content text,This is content text,This is content text," +
                                    "This is content text,This is content text,This is content text")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                            .setContentIntent(pi)//编辑通知可点击
                            .setAutoCancel(true)//通知点击之后图标消失
                            //.setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))//播放音频
                            //.setVibrate(new long[]{0,1000,1000,1000})//设置震动
                            //.setLights(Color.GREEN,1000,1000)
                            //设置默认的led灯，震动，铃声
                            //.setDefaults(NotificationCompat.DEFAULT_ALL)
                            //设置长文本
                            //.setStyle(new NotificationCompat.BigTextStyle().bigText("This is content text,This is content text,This is content text,This is content text,This is content text" +
                             //       "This is content text,This is content text,This is content text," +
                            //        "This is content text,This is content text,This is content text"))
                            //设置图片
                            //.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background)))
                            //.setPriority(NotificationCompat.PRIORITY_MAX)
                            .build();
                    manager.notify(1,notification);
                    break;
                default:
                    break;
            }
        });
    }
}
