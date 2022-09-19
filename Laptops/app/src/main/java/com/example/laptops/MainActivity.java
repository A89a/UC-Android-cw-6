package com.example.laptops;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <Laptops> laptopList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///laptops List ///
        Laptops laptop1 = new Laptops("ACER" , 100 , R.drawable.acer);
        Laptops laptop2 = new Laptops("DELL" , 350 , R.drawable.dell);
        Laptops laptop3 = new Laptops("MACBOOK" , 450 , R.drawable.macbook);
        Laptops laptop4 = new Laptops("MSI" , 500 , R.drawable.msi);
        Laptops laptop5 = new Laptops("SONY" , 250 , R.drawable.sony);
        Laptops laptop6 = new Laptops("VAIO" , 200 , R.drawable.vaio);

        ///Laptops addition to ArrayList///
        laptopList.add(laptop1);
        laptopList.add(laptop2);
        laptopList.add(laptop3);
        laptopList.add(laptop4);
        laptopList.add(laptop5);
        laptopList.add(laptop6);

        ///Create Recycler View

        RecyclerView recycler=findViewById(R.id.rv);
        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);

        ItemAdapter adapter= new ItemAdapter(laptopList,this);
        recycler.setAdapter(adapter);



    }
}