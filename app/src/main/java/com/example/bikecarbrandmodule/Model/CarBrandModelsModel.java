package com.example.bikecarbrandmodule.Model;

public class CarBrandModelsModel {

    public int id;
    public String brandId;
    public String brandName;
    public String carModelName;
    public String carModelSlug;
    public String exShowroomPrice;
    public String imageUrl;
    public boolean isDiscontinued;
    public boolean isBS6Compliant;

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarModelSlug() {
        return carModelSlug;
    }

    public void setCarModelSlug(String carModelSlug) {
        this.carModelSlug = carModelSlug;
    }

    public String getExShowroomPrice() {
        return exShowroomPrice;
    }

    public void setExShowroomPrice(String exShowroomPrice) {
        this.exShowroomPrice = exShowroomPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isDiscontinued() {
        return isDiscontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        isDiscontinued = discontinued;
    }

    public boolean isBS6Compliant() {
        return isBS6Compliant;
    }

    public void setBS6Compliant(boolean BS6Compliant) {
        isBS6Compliant = BS6Compliant;
    }
}
