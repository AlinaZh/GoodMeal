package com.example.alina.goodmeal;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alina.goodmeal.Model.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FoodDetail extends AppCompatActivity {

    TextView food_name,food_time,food_ingredients, food_directions;
    ImageView food_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnFav;

    String foodId="";
    FirebaseDatabase database;
    DatabaseReference foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        //Firebase
        database = FirebaseDatabase.getInstance();
        foods = database.getReference("Foods");

        //Init view
        btnFav = (FloatingActionButton)findViewById(R.id.btnFav);


        food_directions = (TextView)findViewById(R.id.food_directions);
        food_ingredients= (TextView)findViewById(R.id.food_ingredients);
        food_name = (TextView)findViewById(R.id.food_name);
        food_time = (TextView)findViewById(R.id.food_time);

        food_image = (ImageView)findViewById(R.id.img_food);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);


        //Get Food Id from Intent
        if(getIntent() != null)
            foodId = getIntent().getStringExtra("FoodsId");
        if(!foodId.isEmpty())
        {
            getDetailFood(foodId);
        }
    }

    private void getDetailFood(String foodId) {
        foods.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Food food = dataSnapshot.getValue(Food.class);

                //set image
                Picasso.with(getBaseContext()).load(food.getImage()).into(food_image);

                collapsingToolbarLayout.setTitle(food.getName());
                food_time.setText(food.getCookingTime());
                food_name.setText(food.getName());

                food_ingredients.setText(food.getIngredients());
                food_directions.setText(food.getDirections());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
