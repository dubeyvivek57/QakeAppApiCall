package com.example.vivek.qakeappapicall.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feed {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;

    public Feed() {
    }

    public Feed(String type, List<Feature> features) {
        super();
        this.type = type;
        this.features = features;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Feed{");
        sb.append("type='").append(type).append('\'');
        sb.append(", features=").append(features);
        sb.append('}');
        return sb.toString();
    }
}