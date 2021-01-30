package com.example.bikecarbrandmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CarModelTypes extends AppCompatActivity {

    String modelName;
    ImageView backButton;
    TextView txt_modelName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_model_types);

        Intent intent = getIntent();
        modelName = intent.getStringExtra("modelName");

        backButton = findViewById(R.id.back_button);
        txt_modelName = findViewById(R.id.toolbar_modelName);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}