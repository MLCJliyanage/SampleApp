package com.example.API;

import com.example.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("users")
    Call<List<User>> getUsers();
}
