package com.example.apicalldemo;

import com.google.gson.annotations.SerializedName;

public class JSonResponse {
    @SerializedName("time")
    private Times time;
    @SerializedName("chartName")
    private String chartName;
    @SerializedName("disclaimer")
    private String disclaimer;
    @SerializedName("bpi")
    private BPIs bpis;

    public BPIs getBpis() {
        return bpis;
    }

    public String getChartName() {
        return chartName;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public Times getTime() {
        return time;
    }

    public void setTime(Times time) {
        this.time = time;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public void setBpis(BPIs bpis) {
        this.bpis = bpis;
    }
}
