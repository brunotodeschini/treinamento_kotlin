package com.example.brunooliveira.extratorca.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;



    public RetrofitConfig(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://www.icoded.com.br/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
    }

    public ExtractService getExtractService(){
        return this.retrofit.create(ExtractService.class);
    }

    public LoginService getLoginService(){
        return this.retrofit.create(LoginService.class);
    }
}
