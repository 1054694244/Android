package com.example.broadcasttest2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    
    private EditText accountEdit;

    private EditText passwordEdit;

    private Button login;

    private SharedPreferences preferences;

    private SharedPreferences.Editor editor;

    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = findViewById(R.id.account);
        passwordEdit = findViewById(R.id.password);
        checkBox = findViewById(R.id.remember_pass);
        login = findViewById(R.id.login);
        boolean isRemember = preferences.getBoolean("remember_password",false);
        //如果上一次登录选择的是记住密码
        if(isRemember){
            String account = preferences.getString("account","");
            String password = preferences.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            checkBox.setChecked(true);
            Log.d(TAG,account);
            Log.d(TAG,password);
        }
        Log.d(TAG,isRemember+"");

        login.setOnClickListener(view->{
            String account = accountEdit.getText().toString();
            String password = passwordEdit.getText().toString();
            //如果账号是admin密码是123455，登录成功
            if("admin".equals(account) && "123456".equals(password)){
                editor = preferences.edit();
                Log.d(TAG,checkBox.isChecked()+"");
                if(checkBox.isChecked()){
                    editor.putBoolean("remember_password",true);
                    editor.putString("account",account);
                    editor.putString("password", password);
                }else {
                    editor.clear();
                }
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(LoginActivity.this,"account or password id invalid",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
