package com.example.vivek.qakeappapicall.model;

import com.example.vivek.qakeappapicall.feature.Properties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feature {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("properties")
    @Expose
    private Properties properties;

    public Feature() {
    }

    public Feature(String type, Properties properties) {
        super();
        this.type = type;
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Feature{");
        sb.append("type='").append(type).append('\'');
        sb.append(", properties=").append(properties);
        sb.append('}');
        return sb.toString();
    }
}
