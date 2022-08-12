package com.example.apicalldemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apicalldemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Times> timesList;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.txtDisclaimer.setMovementMethod(new ScrollingMovementMethod());

       /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.coindesk.com/v1/bpi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TimeApi timeApi = retrofit.create(TimeApi.class); */

        Call<JSonResponse> call = RetrofitClient.getInstance().getApi().getTime();

        call.enqueue(new Callback<JSonResponse>() {

            @Override
            public void onResponse(Call<JSonResponse> call, Response<JSonResponse> response) {

                JSonResponse jSonResponse = response.body();
                timesList = new ArrayList<>(Arrays.asList(jSonResponse.getTime()));

                binding.txtChart.setText(jSonResponse.getChartName());
                binding.txtDisclaimer.setText(jSonResponse.getDisclaimer());

                binding.btnUsd.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View view) {
                        binding.btnUsd.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        binding.btnUsd.setTextColor(getResources().getColor(R.color.white));

                        binding.txtCurrencyData.setText(jSonResponse.getBpis().getUsds().getCode() + "\n"
                                + jSonResponse.getBpis().getUsds().getSymbol() + "\n"
                                + jSonResponse.getBpis().getUsds().getDescription() + "\n"
                                + jSonResponse.getBpis().getUsds().getRate() + "\n"
                                + jSonResponse.getBpis().getUsds().getRate_float());


                        binding.btnGdp.setBackgroundColor(getResources().getColor(R.color.light_grey));
                        binding.btnGdp.setTextColor(getResources().getColor(R.color.black));

                        binding.btnEur.setBackgroundColor(getResources().getColor(R.color.light_grey));
                        binding.btnEur.setTextColor(getResources().getColor(R.color.black));

                    }

                });
                binding.btnGdp.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View view) {
                        binding.btnGdp.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        binding.btnGdp.setTextColor(getResources().getColor(R.color.white));

                        binding.txtCurrencyData.setText(jSonResponse.getBpis().getGbp().getCode() + "\n"
                                + jSonResponse.getBpis().getGbp().getSymbol() + "\n"
                                + jSonResponse.getBpis().getGbp().getDescription() + "\n"
                                + jSonResponse.getBpis().getGbp().getRate() + "\n"
                                + jSonResponse.getBpis().getGbp().getRate_float());


                        binding.btnUsd.setBackgroundColor(getResources().getColor(R.color.light_grey));
                        binding.btnUsd.setTextColor(getResources().getColor(R.color.black));

                        binding.btnEur.setBackgroundColor(getResources().getColor(R.color.light_grey));
                        binding.btnEur.setTextColor(getResources().getColor(R.color.black));

                    }

                });
                binding.btnEur.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View view) {
                        binding.btnEur.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        binding.btnEur.setTextColor(getResources().getColor(R.color.white));

                        binding.txtCurrencyData.setText(jSonResponse.getBpis().getEur().getCode() + "\n"
                                + jSonResponse.getBpis().getEur().getSymbol() + "\n"
                                + jSonResponse.getBpis().getEur().getDescription() + "\n"
                                + jSonResponse.getBpis().getEur().getRate() + "\n"
                                + jSonResponse.getBpis().getEur().getRate_float());


                        binding.btnUsd.setBackgroundColor(getResources().getColor(R.color.light_grey));
                        binding.btnUsd.setTextColor(getResources().getColor(R.color.black));

                        binding.btnGdp.setBackgroundColor(getResources().getColor(R.color.light_grey));
                        binding.btnGdp.setTextColor(getResources().getColor(R.color.black));

                    }

                });


                for (int i = 0; i < timesList.size(); i++) {
                    Toast.makeText(MainActivity.this, "data" + timesList.get(i).getUpdated(), Toast.LENGTH_LONG).show();
                    binding.txtUpdated.setText(timesList.get(i).getUpdated());
                    binding.txtUpdatedISO.setText(timesList.get(i).getUpdatedISO());
                    binding.txtUpdatedUK.setText(timesList.get(i).getUpdateduk());
                }

                Log.e("helowwowowowo", response.body().toString());
            }

            @Override
            public void onFailure(Call<JSonResponse> call, Throwable t) {
                // textView.append("hiiiiiiiiiiiiiiii"+call+" "+t);
                Log.e("cvbnop", call.toString() + " " + t);
            }
        });

    }
}