package com.example.madproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class diet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
    }

    public void customize(View v)
    {
        Intent i1=new Intent(this,select_meal.class);
        startActivity(i1);

    }
    public void history(View v5)
    {
        Intent i5=new Intent(this,FoodList.class);
        startActivity(i5);
    }

}
