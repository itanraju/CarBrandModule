package com.example.bikecarbrandmodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bikecarbrandmodule.Adapter.CarBrandModelsAdapter;
import com.example.bikecarbrandmodule.Model.CarBrandModel;
import com.example.bikecarbrandmodule.Model.CarBrandModelsModel;
import com.example.bikecarbrandmodule.Model.CarBrandModelsRootModel;
import com.example.bikecarbrandmodule.Model.CarRootModel;
import com.example.bikecarbrandmodule.Retrofit.ApiClient;
import com.example.bikecarbrandmodule.Retrofit.CarBrandService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarBrandModelsActivity extends AppCompatActivity {

    String brandId,brandName;
    ImageView backButton;
    TextView carBrandName;
    RecyclerView carModelRecycleView;
    ProgressDialog progressDialog;
    ArrayList<Integer>  modelID=new ArrayList<>();
    ArrayList<String>  modelName=new ArrayList<>();
    ArrayList<String>  modelShowroomPrice=new ArrayList<>();
    ArrayList<String>  modelimageUrl=new ArrayList<>();
    List<CarBrandModelsModel> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_brand_models);

        brandId=getIntent().getStringExtra("id");
        brandName=getIntent().getStringExtra("name");
        list = new ArrayList<>();
        backButton=findViewById(R.id.back_button);
        carBrandName=findViewById(R.id.toolbar_brandName);
        carModelRecycleView=findViewById(R.id.carModelsRecycleView);
        progressDialog=new ProgressDialog(CarBrandModelsActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        getCarModelsData();
        carBrandName.setText(brandName);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void getCarModelsData() {



        CarBrandService carBrandService= ApiClient.getCarBrandModelsService();

        Call<CarBrandModelsRootModel> call=carBrandService.getCarBrabModels(brandId);

        call.enqueue(new Callback<CarBrandModelsRootModel>() {
            @Override
            public void onResponse(Call<CarBrandModelsRootModel> call, Response<CarBrandModelsRootModel> response) {

                if(response.isSuccessful())
                {

                    list = new ArrayList<>();
                    CarBrandModelsRootModel carBrandModelsRootModel=response.body();

                    list =carBrandModelsRootModel.getData();

                    for (int i = 0; i< list.size(); i++)
                    {
                            CarBrandModelsModel carBrandModelsModel= list.get(i);

                            int id=carBrandModelsModel.getId();
                            String name=carBrandModelsModel.getCarModelName();
                            String price=carBrandModelsModel.getExShowroomPrice();
                            String imageLink=carBrandModelsModel.getImageUrl();

                             modelID.add(id);
                             modelName.add(name);
                             modelShowroomPrice.add(price);
                             modelimageUrl.add(imageLink);

                            CarBrandModelsAdapter carBrandModelsAdapter=new CarBrandModelsAdapter(CarBrandModelsActivity.this,modelID,modelName,modelShowroomPrice,modelimageUrl);
                            carModelRecycleView.setLayoutManager(new GridLayoutManager(CarBrandModelsActivity.this,2));
                            carModelRecycleView.setAdapter(carBrandModelsAdapter);
                            carModelRecycleView.setHasFixedSize(true);

                        }

                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<CarBrandModelsRootModel> call, Throwable t) {

                Toast.makeText(CarBrandModelsActivity.this, "Response Fail !", Toast.LENGTH_SHORT).show();

            }
        });

    }
}