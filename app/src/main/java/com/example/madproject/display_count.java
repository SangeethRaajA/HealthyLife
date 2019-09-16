package com.example.madproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class display_count extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_count);
    }

    public void cancel(View v3)
    {
        Intent i3=new Intent(this,select_meal.class);
        startActivity(i3);
    }

    public void save(View v4)
    {
        Intent i4=new Intent(this,history.class);
        startActivity(i4);
    }
}
