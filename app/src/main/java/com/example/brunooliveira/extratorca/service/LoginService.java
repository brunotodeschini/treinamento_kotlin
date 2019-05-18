package com.example.brunooliveira.extratorca.service;

import com.example.brunooliveira.extratorca.models.Extract;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginService {

    @GET("extract.php")
    Call<Extract> testLogin(@Query("pwd") String password);
}
