package com.example.bikecarbrandmodule.Retrofit;

import com.example.bikecarbrandmodule.Model.CarBrandModelsRootModel;
import com.example.bikecarbrandmodule.Model.CarRootModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CarBrandService {

    @GET("car_brands")
    Call<CarRootModel> getCardBrands();

    @GET("car_models")
    Call<CarBrandModelsRootModel> getCarBrabModels(@Query("brandId")String brandId);
}
