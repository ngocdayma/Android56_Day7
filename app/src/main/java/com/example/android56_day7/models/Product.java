package com.example.android56_day7.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Product {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("discountPercentage")
    @Expose
    private Double discountPercentage;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("stock")
    @Expose
    private Integer stock;
    @SerializedName("tags")
    @Expose
    private List<String> tags;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("dimensions")
    @Expose
    private Dimensions dimensions;
    @SerializedName("warrantyInformation")
    @Expose
    private String warrantyInformation;
    @SerializedName("shippingInformation")
    @Expose
    private String shippingInformation;
    @SerializedName("availabilityStatus")
    @Expose
    private String availabilityStatus;
    @SerializedName("reviews")
    @Expose
    private List<Review> reviews;
    @SerializedName("returnPolicy")
    @Expose
    private String returnPolicy;
    @SerializedName("minimumOrderQuantity")
    @Expose
    private Integer minimumOrderQuantity;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("images")
    @Expose
    private List<String> images;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public String getWarrantyInformation() {
        return warrantyInformation;
    }

    public void setWarrantyInformation(String warrantyInformation) {
        this.warrantyInformation = warrantyInformation;
    }

    public String getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(String shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getReturnPolicy() {
        return returnPolicy;
    }

    public void setReturnPolicy(String returnPolicy) {
        this.returnPolicy = returnPolicy;
    }

    public Integer getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(Integer minimumOrderQuantity) {
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", rating=" + rating +
                ", stock=" + stock +
                ", tags=" + tags +
                ", brand='" + brand + '\'' +
                ", sku='" + sku + '\'' +
                ", weight=" + weight +
                ", dimensions=" + dimensions +
                ", warrantyInformation='" + warrantyInformation + '\'' +
                ", shippingInformation='" + shippingInformation + '\'' +
                ", availabilityStatus='" + availabilityStatus + '\'' +
                ", reviews=" + reviews +
                ", returnPolicy='" + returnPolicy + '\'' +
                ", minimumOrderQuantity=" + minimumOrderQuantity +
                ", meta=" + meta +
                ", images=" + images +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
