package com.example.bikecarbrandmodule.Model;

import java.util.List;

public class CarBrandModelsRootModel {

    public int statusCode;
    public String statusMessage;
    public List<CarBrandModelsModel> data;

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

    public List<CarBrandModelsModel> getData() {
        return data;
    }

    public void setData(List<CarBrandModelsModel> data) {
        this.data = data;
    }
}
