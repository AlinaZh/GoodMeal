package com.example.alina.goodmeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alina.goodmeal.Database.Database;
import com.example.alina.goodmeal.Model.Favorites;
import com.example.alina.goodmeal.ViewHolder.FavAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyFavorites extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference request;

    List<Favorites> favorites = new ArrayList<>();

    FavAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorites);

        //Firebase
        database = FirebaseDatabase.getInstance();
        request = database.getReference("Request");

        //Init
        recyclerView = (RecyclerView)findViewById(R.id.listFav);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        
        loadListFood();
    }

    private void loadListFood() {
        favorites = new Database(this).getFav();
        adapter = new FavAdapter(favorites, this);
        recyclerView.setAdapter(adapter);
    }
}
