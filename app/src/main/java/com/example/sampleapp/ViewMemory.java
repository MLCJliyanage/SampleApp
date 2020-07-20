package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ViewMemory extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_memory);

        textView = findViewById(R.id.txt1);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        textView.setText(pref.getString("Name",null).toString());

    }
}