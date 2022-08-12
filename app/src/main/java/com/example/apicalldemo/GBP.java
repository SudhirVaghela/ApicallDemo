package com.example.apicalldemo;

import com.google.gson.annotations.SerializedName;

public class GBP {

    @SerializedName("code")
    String code;
    @SerializedName("symbol")
    String symbol;
    @SerializedName("rate")
    String rate;
    @SerializedName("description")
    String description;
    @SerializedName("rate_float")
    float rate_float;

    public GBP(String code, String symbol, String rate, String description, float rate_float) {
        this.code = code;
        this.symbol = symbol;
        this.rate = rate;
        this.description = description;
        this.rate_float = rate_float;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getRate() {
        return rate;
    }

    public String getDescription() {
        return description;
    }

    public float getRate_float() {
        return rate_float;
    }
}
