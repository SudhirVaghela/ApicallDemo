package com.example.apicalldemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private TimeApi api;

    private RetrofitClient() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(TimeApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(TimeApi.class);
    }
    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }
    public  TimeApi getApi(){ return  api; }
}
