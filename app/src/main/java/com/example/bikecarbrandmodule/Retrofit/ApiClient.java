package com.example.bikecarbrandmodule.Retrofit;

import com.example.bikecarbrandmodule.Model.CarRootModel;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiClient {


    static CarBrandService carBrandService;

    public static CarBrandService getCarBrandService()
    {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        if(carBrandService==null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://www.tradetu.com/rto/api/v1.0/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            carBrandService = retrofit.create(CarBrandService.class);
        }
        return carBrandService;
    }

    static CarBrandService carBrandModelsService;

    public static CarBrandService getCarBrandModelsService()
    {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        if(carBrandModelsService==null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://www.tradetu.com/rto/api/v1.0/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            carBrandModelsService = retrofit.create(CarBrandService.class);
        }
        return carBrandModelsService;
    }

}
