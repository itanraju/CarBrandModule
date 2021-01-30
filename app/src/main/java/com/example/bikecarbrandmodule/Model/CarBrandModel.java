package com.example.bikecarbrandmodule.Model;

public class CarBrandModel {

    public int id;
    public String brandName;
    public String brandSlug;
    public String imageUrl;

    public CarBrandModel(int id, String brandName, String brandSlug, String imageUrl) {
        this.id = id;
        this.brandName = brandName;
        this.brandSlug = brandSlug;
        this.imageUrl = imageUrl;
    }

    public CarBrandModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandSlug() {
        return brandSlug;
    }

    public void setBrandSlug(String brandSlug) {
        this.brandSlug = brandSlug;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
