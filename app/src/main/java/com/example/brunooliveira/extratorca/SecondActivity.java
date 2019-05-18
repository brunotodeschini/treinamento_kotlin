package com.example.brunooliveira.extratorca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brunooliveira.extratorca.adapter.ExtractAdapter;
import com.example.brunooliveira.extratorca.models.Extract;
import com.example.brunooliveira.extratorca.models.Installments;

import java.util.ArrayList;


public class SecondActivity extends Activity{

    private TextView name;
    private TextView valueAvailable;
    private TextView limitValue;
    private TextView usedValue;
    private ImageButton logout;

    private RecyclerView extractRecycler;
    private RecyclerView.LayoutManager layoutManager;
    ExtractAdapter adapter;
    ArrayList<Installments> installments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = findViewById(R.id.userName);
        valueAvailable = findViewById(R.id.availableValueField);
        limitValue = findViewById(R.id.limitValueField);
        usedValue = findViewById(R.id.fieldUsedBox);
        logout = findViewById(R.id.logoutId);


        Extract extract = (Extract) getIntent().getSerializableExtra("extract");

        name.setText(extract.getData().getName());
        valueAvailable.setText(extract.getData().getLimits().getAvailable());
        limitValue.setText(extract.getData().getLimits().getTotal());
        usedValue.setText(extract.getData().getLimits().getExpent());

       installments = extract.getData().getInstallments();
        createAdapter(installments);


        logout.setOnClickListener(v -> {
            Intent intent1 = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent1);
            finish();
        });
    }

    public void createAdapter(ArrayList<Installments> installments){
        extractRecycler = findViewById(R.id.extractListId);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        extractRecycler.setLayoutManager(layoutManager);
        adapter = new ExtractAdapter(this, installments);
        extractRecycler.setAdapter(adapter);
        final ArrayList<Installments> itens = installments;

        adapter.setOnItemClickListener(new ExtractAdapter.OnExtractClickListener() {
            @Override
            public void onExtractClick(View view, int position) {
                switch (view.getId()) {

                    case R.id.clItem: {
                        Toast.makeText(SecondActivity.this, "Data do vencimento: " + itens.get(position).getPast_due() , Toast.LENGTH_LONG).show();
                    }
                    break;
                }
            }
        });
    }

}
