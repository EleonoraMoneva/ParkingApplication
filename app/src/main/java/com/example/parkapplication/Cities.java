package com.example.parkapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Cities extends AppCompatActivity {

    RecyclerView recyclerView;
    String nm[],  sc[];
    Database database;
    String userName;
    int pl[];
    int images[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        if (getIntent().hasExtra("userName"))
        {
            userName = getIntent().getStringExtra("userName");

        }
        else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }

        recyclerView = findViewById(R.id.recyclerView);

        database = new Database(this, null, null, 2);

        nm = database.getCities();
        sc = database.getShortcuts();
        pl = database.getNumParkingLots();
        images = database.getCityImages();



        MyAdapter myAdapter = new MyAdapter(com.example.parkapplication.Cities.this, nm, sc, pl, images, userName);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}