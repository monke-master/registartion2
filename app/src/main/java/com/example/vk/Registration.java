package com.example.vk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

    }
    public void Registration(View v) {
        TextView lgn = findViewById(R.id.lgn_rgstr);
        TextView pswrd = findViewById(R.id.pswrd_rgstr);
        String login = lgn.getText().toString();
        String password = pswrd.getText().toString();
        Intent i = new Intent();
        i.putExtra("login", login);
        i.putExtra("password", password);
        setResult(RESULT_OK, i);
        finish();
    }
}