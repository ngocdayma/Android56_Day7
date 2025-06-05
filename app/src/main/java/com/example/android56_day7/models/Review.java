package com.example.android56_day7.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Review {

    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("reviewerName")
    @Expose
    private String reviewerName;
    @SerializedName("reviewerEmail")
    @Expose
    private String reviewerEmail;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewerEmail() {
        return reviewerEmail;
    }

    public void setReviewerEmail(String reviewerEmail) {
        this.reviewerEmail = reviewerEmail;
    }

}
