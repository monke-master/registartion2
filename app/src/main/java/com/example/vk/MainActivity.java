package com.example.vk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String rLogin = "admin";
    String rPassword = "admin";
    SharedPreferences.Editor ed;
    SharedPreferences info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = getSharedPreferences("pref", Context.MODE_PRIVATE);
        ed = info.edit();
        ed.putString("login", rLogin);
        ed.putString("password", rPassword);
        ed.apply();
        TextView txt = findViewById(R.id.answer);
        txt.setText(info.getString("login", "none"));
    }
    public void enter(View v) {
        EditText lgn = findViewById(R.id.lgn);
        EditText pswrd = findViewById(R.id.pswrd);
        String login = lgn.getText().toString();
        String password = pswrd.getText().toString();
        TextView answer = findViewById(R.id.answer);
        if ((login.equals(info.getString("login", "none"))) && (password.equals(info.getString("login", "none"))))
            answer.setText("Успешный вход");
        else {
            Intent i = new Intent(this, Registration.class);
            startActivityForResult(i, 1);
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                rLogin = data.getStringExtra("login");
                rPassword = data.getStringExtra("password");
                ed.clear();
                ed.putString("login", rLogin);
                ed.putString("password", rPassword);
                ed.apply();
                EditText lgn = findViewById(R.id.lgn);
                lgn.setText(rLogin);
                TextView text = findViewById(R.id.answer);
                text.setText("");
                EditText pswrd = findViewById(R.id.pswrd);
                pswrd.setText("");
                break;
        }
    }

}