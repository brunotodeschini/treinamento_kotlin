package com.example.brunooliveira.extratorca;

import com.example.brunooliveira.extratorca.models.Data;
import com.example.brunooliveira.extratorca.models.Details;
import com.example.brunooliveira.extratorca.models.Extract;
import com.example.brunooliveira.extratorca.models.Installments;
import com.example.brunooliveira.extratorca.service.RetrofitConfig;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RunWith(JUnit4.class)
public class RequisicaoTest extends TestCase {
    private String userPassword = "123456";
    private String userPasswordWrong = "1456";
    int code;


    //Teste realizado para ver se a resposta do webservice está ok
    @Test
    public void answerTest() throws InterruptedException {
        Call<Extract> call = new RetrofitConfig().getLoginService().testLogin(userPassword);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        call.enqueue(new Callback<Extract>() {


            @Override
            public void onResponse(Call<Extract> call, Response<Extract> response) {
                Extract extract = response.body();
                assertNotNull(extract);
                code = extract.getCode();
                assertEquals(200, code);
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Call<Extract> call, Throwable t) {
                Extract extract = null;
                assertNotNull(extract);
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
    }

    //Teste realizado assumindo a hipótese do usuário ter entrado com a senha incorreta
    @Test
    public void answerTestWrong() throws InterruptedException {
        Call<Extract> call = new RetrofitConfig().getLoginService().testLogin(userPasswordWrong);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        call.enqueue(new Callback<Extract>() {

            @Override
            public void onResponse(Call<Extract> call, Response<Extract> response) {
                Extract extract = response.body();
                assertNotNull(extract);
                code = extract.getCode();
                assertEquals(400, code);
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Call<Extract> call, Throwable t) {
                Extract extract = null;
                assertNotNull(extract);
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
    }


    //Teste para verificar se o Objeto Data que vem dentro do json não está nulo e nem seus campos vazios
    @Test
    public void testDataNull() throws InterruptedException {
        Call<Extract> call = new RetrofitConfig().getLoginService().testLogin(userPassword);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        call.enqueue(new Callback<Extract>() {


            @Override
            public void onResponse(Call<Extract> call, Response<Extract> response) {
                Extract extract = response.body();
                assertNotNull(extract);
                Data data = extract.getData();

                assertNotNull(data);
                assertFalse(extract.getData().getName().isEmpty());
                assertFalse(extract.getData().getTotal_due().isEmpty());
                assertFalse(extract.getData().getTotal_overdue().isEmpty());
                assertFalse(extract.getData().getInstallments().isEmpty());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Call<Extract> call, Throwable t) {
                Extract extract = null;
                assertNotNull(extract);
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
    }

    //Teste para analisar se os dados do limite estão ok
    @Test
    public void testLimits() throws InterruptedException {
        Call<Extract> call = new RetrofitConfig().getLoginService().testLogin(userPassword);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        call.enqueue(new Callback<Extract>() {


            @Override
            public void onResponse(Call<Extract> call, Response<Extract> response) {
                Extract extract = response.body();
                assertNotNull(extract);
                assertFalse(extract.getData().getLimits().getTotal().isEmpty());
                assertFalse(extract.getData().getLimits().getAvailable().isEmpty());
                assertFalse(extract.getData().getLimits().getExpent().isEmpty());
                assertFalse(extract.getData().getLimits().getTotal_due().isEmpty());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Call<Extract> call, Throwable t) {
                Extract extract = null;
                assertNotNull(extract);
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
    }

    //Teste para analisar o que vem dentro de Installments
    @Test
    public void testInstallmentsNull() throws InterruptedException {
        Call<Extract> call = new RetrofitConfig().getLoginService().testLogin(userPassword);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        call.enqueue(new Callback<Extract>() {

            @Override
            public void onResponse(Call<Extract> call, Response<Extract> response) {
                Extract extract = response.body();
                assertNotNull(extract);
                Integer tam = extract.getData().getInstallments().size();
                assertNotNull(tam);
                ArrayList<Installments>InstallmentsTeste = extract.getData().getInstallments();
                //Percorrendo o ArrayLista de installments para verificar se tem algum vazio dentro
                for (Installments intallments : InstallmentsTeste){
                    assertFalse(intallments.getCarnet().isEmpty());
                    assertFalse(intallments.getInstallment().isEmpty());
                    assertFalse(intallments.getPast_due().isEmpty());
                    assertFalse(intallments.getValue().isEmpty());

                    //Verifica se o detalhe da parcela ta nulo
                    Details details = intallments.getDetail();
                    assertNotNull(details);

                    //Verifica se os dados do detalhe estão corretos
                    assertFalse(details.getOriginal_value().isEmpty());
                    assertFalse(details.getOverdue_date().isEmpty());
                    assertFalse(details.getStore().isEmpty());
                    assertFalse(details.getTotal_value().isEmpty());
                    assertFalse(details.getValue_diff().isEmpty());
                    assertNotNull(details.getOverdue_days());
                }
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Call<Extract> call, Throwable t) {
                Extract extract = null;
                assertNotNull(extract);
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();
    }



}
