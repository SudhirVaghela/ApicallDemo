package com.example.apicalldemo;

import com.google.gson.annotations.SerializedName;

public class BPIs {

    @SerializedName("USD")
    private USD usds;

    @SerializedName("GBP")
    private GBP gbp;

    @SerializedName("EUR")
    private EUR eur;

    public BPIs(USD usds, GBP gbp, EUR eur) {
        this.usds = usds;
        this.gbp = gbp;
        this.eur = eur;
    }

    public EUR getEur() {
        return eur;
    }

    public void setEur(EUR eur) {
        this.eur = eur;
    }


    public void setUsds(USD usds) {
        this.usds = usds;
    }

    public void setGbp(GBP gbp) {
        this.gbp = gbp;
    }

    public GBP getGbp() {
        return gbp;
    }

    public USD getUsds() {
        return usds;
    }

}
