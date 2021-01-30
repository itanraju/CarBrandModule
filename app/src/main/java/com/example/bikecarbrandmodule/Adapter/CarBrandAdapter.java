package com.example.bikecarbrandmodule.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bikecarbrandmodule.CarBrandModelsActivity;
import com.example.bikecarbrandmodule.R;

import java.util.ArrayList;

public class CarBrandAdapter extends RecyclerView.Adapter<CarBrandAdapter.ViewHolder> {

    Context context;
    ArrayList<Integer> brandIdList=new ArrayList<>();
    ArrayList<String> brandName=new ArrayList<>();
    ArrayList<String> imageUrl=new ArrayList<>();

    public CarBrandAdapter(Context context,ArrayList<Integer> brandIdList, ArrayList<String> brandName, ArrayList<String> imageUrl) {
        this.context = context;
        this.brandIdList=brandIdList;
        this.brandName = brandName;
        this.imageUrl = imageUrl;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.car_brand_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tBrandName.setText(brandName.get(position));
        Glide.with(context).load(imageUrl.get(position)).placeholder(R.drawable.car_place_holder).into(holder.iBrandImage);
        String id= String.valueOf(brandIdList.get(position));

        holder.iBrandImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(id);
                Intent intent = new Intent(context, CarBrandModelsActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("name",brandName.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return brandName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tBrandName;
        ImageView iBrandImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tBrandName=itemView.findViewById(R.id.brandName);
            iBrandImage=itemView.findViewById(R.id.brandImage);
        }
    }

}
