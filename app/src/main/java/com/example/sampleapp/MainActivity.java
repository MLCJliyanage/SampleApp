package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.API.Api;
import com.example.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnWebView);
        textView = findViewById(R.id.txtFromWeb);
        textView.setText("Hello "+ getIntent().getStringExtra("Name"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMemory();
            }
        });
        getAllUsers();
    }

    private void getAllUsers() {
        listView = findViewById(R.id.listUsers);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<User>> call = api.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Toast.makeText(MainActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                List<User> users = response.body();
                String[] userNames = new String[users.size()];
                for(int i=0; i < users.size(); i++){
                    userNames[i] = users.get(i).getName();
                }

                listView.setAdapter(
                        new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_expandable_list_item_1,
                                userNames
                        )
                );
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void viewMemory() {
        Intent intent = new Intent(this, ViewMemory.class);
        startActivity(intent);
    }
}