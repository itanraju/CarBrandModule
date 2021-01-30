package com.example.bikecarbrandmodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.bikecarbrandmodule.Adapter.CarBrandAdapter;
import com.example.bikecarbrandmodule.Model.CarBrandModel;
import com.example.bikecarbrandmodule.Model.CarRootModel;
import com.example.bikecarbrandmodule.Retrofit.ApiClient;
import com.example.bikecarbrandmodule.Retrofit.CarBrandService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<CarBrandModel> list=new ArrayList<>();
    ArrayList<String> brandNameList=new ArrayList<>();
    ArrayList<String> imageUrlList=new ArrayList<>();
    ArrayList<Integer> brandIdList=new ArrayList<>();
    RecyclerView recyclerView;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleView);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        getCarBrandData();

    }

    private void getCarBrandData() {

        CarBrandService carBrandService= ApiClient.getCarBrandService();
        Call<CarRootModel> call=carBrandService.getCardBrands();
        call.enqueue(new Callback<CarRootModel>() {
            @Override
            public void onResponse(Call<CarRootModel> call, Response<CarRootModel> response) {

                if(response.isSuccessful())
                {
                    CarRootModel carRootModel=response.body();
                    Log.d("TAGOP", "onResponse: "+new Gson().toJson(carRootModel));

                    list=carRootModel.getData();

                    for(int i=0;i<list.size();i++)
                    {
                        CarBrandModel carBrandModel=list.get(i);

                        String brandName=carBrandModel.getBrandName();
                        String imageUrl=carBrandModel.getImageUrl();
                        int id=carBrandModel.getId();

                        brandNameList.add(brandName);
                        imageUrlList.add(imageUrl);
                        brandIdList.add(id);

                        CarBrandAdapter carBrandAdapter=new CarBrandAdapter(MainActivity.this,brandIdList,brandNameList,imageUrlList);
                        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
                        recyclerView.setAdapter(carBrandAdapter);
                        recyclerView.setHasFixedSize(true);

                        progressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<CarRootModel> call, Throwable t) {

                Log.e("error","Response Fail");
            }
        });
    }
}