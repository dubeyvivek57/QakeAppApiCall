package com.example.vivek.qakeappapicall.feature;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {

    @SerializedName("mag")
    @Expose
    private double mag;
    @SerializedName("place")
    @Expose
    private String place;

    @SerializedName("time")
    @Expose
    private long time;
    @SerializedName("detail")
    @Expose
    private String detail;

    public Properties() {
    }

    public Properties(double mag, String place, long time, String detail) {
        this.mag = mag;
        this.place = place;
        this.time = time;
        this.detail = detail;
    }

    public double getMag() {
        return mag;
    }

    public String getPlace() {
        return place;
    }

    public long getTime() {
        return time;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Properties{");
        sb.append("mag=").append(mag);
        sb.append(", place='").append(place).append('\'');
        sb.append(", time=").append(time);
        sb.append(", detail='").append(detail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}