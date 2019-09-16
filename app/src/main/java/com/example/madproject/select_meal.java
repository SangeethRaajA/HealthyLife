package com.example.madproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class select_meal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_meal);
    }
    public void next(View v1)
    {
        Intent i2=new Intent(this,display_count.class);
        startActivity(i2);
    }
}
