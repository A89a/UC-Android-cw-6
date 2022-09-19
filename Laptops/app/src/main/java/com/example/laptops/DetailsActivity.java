package com.example.laptops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView nameText=findViewById(R.id.textViewNameD);
        TextView priceText=findViewById(R.id.textViewPriceD);
        ImageView img= findViewById(R.id.imageViewDetails);

        //next day  we add view and link it to show the next page once click on the main view
        Bundle bundle=getIntent().getExtras();
        Laptops sentLaptop =(Laptops) bundle.getSerializable("Laptop");
        nameText.setText(sentLaptop.getName());
        priceText.setText(sentLaptop.getPrice()+"");
        img.setImageResource(sentLaptop.getImg());
    }
}