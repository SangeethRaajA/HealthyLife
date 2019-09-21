package com.example.madproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mainButton = findViewById(R.id.mainButton);
    }

    public void reminder(View v){
        Intent intent = new Intent(this, add_task.class);
        startActivity(intent);
    }

    public void bmi(View v){
        Intent intent = new Intent(MainActivity.this,bmi.class);
        startActivity(intent);
    }

    public void diet(View v){
        Intent intent = new Intent(this,diet.class);
        startActivity(intent);
    }

    public void expense(View v){
        Intent intent = new Intent(MainActivity.this,expense.class);
        startActivity(intent);
    }


}
