package com.example.bikecarbrandmodule.Model;

import java.util.List;

public class CarRootModel {

    public int statusCode;
    public String statusMessage;
    public List<CarBrandModel> data;

    public CarRootModel(int statusCode, String statusMessage, List<CarBrandModel> data) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
    }

    public CarRootModel() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public List<CarBrandModel> getData() {
        return data;
    }

    public void setData(List<CarBrandModel> data) {
        this.data = data;
    }
}
