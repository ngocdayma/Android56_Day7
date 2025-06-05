package com.example.android56_day7.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Dimensions {
    @SerializedName("width")
    @Expose
    private Double width;
    @SerializedName("height")
    @Expose
    private Double height;
    @SerializedName("depth")
    @Expose
    private Double depth;

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

}
