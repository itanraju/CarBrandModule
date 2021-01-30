package com.example.bikecarbrandmodule.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bikecarbrandmodule.CarModelTypes;
import com.example.bikecarbrandmodule.R;

import java.util.ArrayList;

public class CarBrandModelsAdapter extends RecyclerView.Adapter<CarBrandModelsAdapter.ViewHolder> {

    Context context;
    ArrayList<Integer> modelID=new ArrayList<>();
    ArrayList<String>  modelName=new ArrayList<>();
    ArrayList<String>  modelShowroomPrice=new ArrayList<>();
    ArrayList<String>  modelimageUrl=new ArrayList<>();

    public CarBrandModelsAdapter(Context context, ArrayList<Integer> modelID, ArrayList<String> modelName, ArrayList<String> modelShowroomPrice, ArrayList<String> modelimageUrl) {
        this.context = context;
        this.modelID = modelID;
        this.modelName = modelName;
        this.modelShowroomPrice = modelShowroomPrice;
        this.modelimageUrl = modelimageUrl;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.car_models_layout,parent,false);
        return new CarBrandModelsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.carModelName.setText(modelName.get(position));
        holder.carModelPrice.setText(modelShowroomPrice.get(position));
        Glide.with(context).load(modelimageUrl.get(position)).placeholder(R.drawable.car_place_holder).into(holder.carModelImage);
        String id= String.valueOf(modelID.get(position));
        holder.carModelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, CarModelTypes.class);
                intent.putExtra("modelId",id);
                intent.putExtra("modelName",modelName.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelID.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView carModelImage;
        TextView carModelName;
        TextView carModelPrice;
        CardView carModelView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            carModelImage=itemView.findViewById(R.id.carModelImage);
            carModelName=itemView.findViewById(R.id.carModelName);
            carModelPrice=itemView.findViewById(R.id.carModelPrice);
            carModelView=itemView.findViewById(R.id.carModelView);
        }
    }
}
