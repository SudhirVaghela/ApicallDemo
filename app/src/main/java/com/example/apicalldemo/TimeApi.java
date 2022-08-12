package com.example.apicalldemo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimeApi {

    String BASE_URL = "https://api.coindesk.com/v1/bpi/";

    @GET("currentprice.json")
    Call<JSonResponse> getTime();

}
