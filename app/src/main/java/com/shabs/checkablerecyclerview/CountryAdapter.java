package com.shabs.checkablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CustomViewHolder> {

    Context context;
    private ArrayList<MCountry> dataModelsList;
    private int checkedPosition = 0;
    public ArrayList<MCountry> selected = new ArrayList<MCountry>();

    public CountryAdapter(Context context, ArrayList<MCountry> dataModelsList) {
        this.context = context;
        this.dataModelsList = dataModelsList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_row_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CustomViewHolder holder, int position) {
        holder.bindData(dataModelsList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataModelsList.size();
    }

    public ArrayList<MCountry> getSelected() {
        selected.clear();
        for(MCountry mCountry : dataModelsList){
            if(mCountry.isChecked()){
                selected.add(mCountry);
            }
        }
        return selected;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewFlag, imageViewcheckButton;
        TextView textView;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFlag = itemView.findViewById(R.id.imageviewCountry);
            imageViewcheckButton = itemView.findViewById(R.id.checkButton);
            textView = itemView.findViewById(R.id.countryName);
        }

        public void bindData(MCountry country) {
            if (checkedPosition == -1) {
                imageViewcheckButton.setVisibility(View.INVISIBLE);
            } else {
                if(checkedPosition == getAdapterPosition()){
                    imageViewcheckButton.setVisibility(View.VISIBLE);
                    country.setChecked(!country.isChecked());
                }else{
                    imageViewcheckButton.setVisibility(View.INVISIBLE);
                }
            }
            textView.setText(country.getCountryName());
            Glide.with(context).load(country.getCountryFlag()).into(imageViewFlag);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    country.setChecked(!country.isChecked());
                    imageViewcheckButton.setVisibility(country.isChecked() ? View.VISIBLE : View.INVISIBLE);
                }
            });
        }
    }
}
