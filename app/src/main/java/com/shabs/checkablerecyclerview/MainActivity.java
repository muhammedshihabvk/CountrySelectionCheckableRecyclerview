package com.shabs.checkablerecyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button continueButton;

    ArrayList<MCountry> dataModelsList = new ArrayList<MCountry>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataModelsList.add(new MCountry("1", "Quater", "https://www.vedi-express.com/34499-large_default/canada-flag.jpg",false));
        dataModelsList.add(new MCountry("2", "India", "https://cdn.britannica.com/97/1597-004-05816F4E/Flag-India.jpg",false));
        dataModelsList.add(new MCountry("1", "USA", "https://cdn.britannica.com/79/4479-050-6EF87027/flag-Stars-and-Stripes-May-1-1795.jpg",false));
        dataModelsList.add(new MCountry("1", "Quater", "https://cdn.britannica.com/69/5869-004-7D75CD05/Flag-Argentina.jpg",false));
        dataModelsList.add(new MCountry("1", "Quater", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/1200px-Flag_of_Canada_%28Pantone%29.svg.png",false));
        dataModelsList.add(new MCountry("1", "Quater", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/1200px-Flag_of_Canada_%28Pantone%29.svg.png",false));
        dataModelsList.add(new MCountry("1", "Quater", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/1200px-Flag_of_Canada_%28Pantone%29.svg.png",false));
        dataModelsList.add(new MCountry("1", "Quater", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/1200px-Flag_of_Canada_%28Pantone%29.svg.png",false));
        dataModelsList.add(new MCountry("1", "Quater", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/1200px-Flag_of_Canada_%28Pantone%29.svg.png",false));
        dataModelsList.add(new MCountry("1", "Quater", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/1200px-Flag_of_Canada_%28Pantone%29.svg.png",false));


        recyclerView = findViewById(R.id.recyclerview);
        continueButton = findViewById(R.id.continueButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

        CountryAdapter countryAdapter = new CountryAdapter(this, dataModelsList);

        recyclerView.setAdapter(countryAdapter);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<MCountry> list = countryAdapter.getSelected();
                if(list.size()<=0){
                    Toast.makeText(MainActivity.this,"No items selected" , Toast.LENGTH_SHORT).show();
                }else{
                    String country ="";
                    for (MCountry mCountry : list){
                        country += mCountry.getCountryName() + ",";
                    }
                    Toast.makeText(MainActivity.this, country, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}