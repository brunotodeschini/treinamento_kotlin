package com.example.brunooliveira.extratorca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brunooliveira.extratorca.models.Extract;
import com.example.brunooliveira.extratorca.service.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView login;
    private TextView password;
    private Button logar;
    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.fieldLogin);
        password = findViewById(R.id.fieldPassword);
        logar = findViewById(R.id.button);

        login.setText("");
        password.setText("");

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userLogin = login.getText().toString();
                String userPassword = password.getText().toString();

                if (userLogin != null && userLogin.equals(userPassword) && !userLogin.isEmpty()) {
                    Call<Extract> call = new RetrofitConfig().getLoginService().testLogin(userPassword);
                    call.enqueue(new Callback<Extract>() {

                        @Override
                        public void onResponse(Call<Extract> call, Response<Extract> response) {
                            Extract extract = response.body();
                            status = extract.getStatus();

                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            intent.putExtra("extract", extract);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Extract> call, Throwable t) {
                            Toast toast = Toast.makeText(MainActivity.this, "Erro ao realizar conexão", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                            toast.show();
                        }
                    });
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, R.string.mensageError, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                }
            }
        });
    }
}