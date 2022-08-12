package com.example.apicalldemo;

import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("time")
    private Times times;
    @SerializedName("disclaimer")
    private String disclaimer;
    @SerializedName("chartName")
    private String chartName;
    @SerializedName("bpi")
    private BPIs bpi;

    public DataModel(String disclaimer, String chartName, BPIs bpi) {
        this.disclaimer = disclaimer;
        this.chartName = chartName;
        this.bpi = bpi;
    }


    public BPIs getBpi() {
        return bpi;
    }

    public void setBpi(BPIs bpi) {
        this.bpi = bpi;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Times getTimes() {
        return times;
    }

    public void setTimes(Times times) {
        this.times = times;
    }
}
