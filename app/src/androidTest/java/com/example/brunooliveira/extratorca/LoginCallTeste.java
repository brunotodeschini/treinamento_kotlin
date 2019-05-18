package com.example.brunooliveira.extratorca;

import com.example.brunooliveira.extratorca.models.Extract;
import com.example.brunooliveira.extratorca.service.RetrofitConfig;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginCallTeste {
    private String userPassword = "123456";


    @Test
    public void callRetrofitTest() throws InterruptedException {
        Call<Extract> call = new RetrofitConfig().getLoginService().testLogin(userPassword);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        call.enqueue(new Callback<Extract>() {


            @Override
            public void onResponse(Call<Extract> call, Response<Extract> response) {
                Extract extract = response.body();
                countDownLatch.countDown();

            }

            @Override
            public void onFailure(Call<Extract> call, Throwable t) {

                countDownLatch.countDown();
            }

        });

        countDownLatch.await();
    }
}
