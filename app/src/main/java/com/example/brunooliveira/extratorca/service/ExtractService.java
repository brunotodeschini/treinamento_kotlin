package com.example.brunooliveira.extratorca.service;

import com.example.brunooliveira.extratorca.models.Extract;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExtractService {

    @GET("extract.php?pwd=123456")
    Call<Extract> searchExtract();
}
