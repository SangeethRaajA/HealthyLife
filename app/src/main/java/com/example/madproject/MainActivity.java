package com.example.madproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mainButton = findViewById(R.id.mainButton);


    }

    /*public void viewMyMain(View v)
    {
        Intent i = new Intent(this,Add_ToDo.class);
        startActivity(i);

    }*/


    /*public void record(View v){

    public void reminder(View v){


        Intent intent = new Intent(this,Add_ToDo.class);
        //Intent intent = new Intent(this,expense_home.class);
        startActivity(intent);
    }

    //TEST 02
    //GUYS REMAIN USE THIS ACTIVITY AND CREATE YOUR INTENDS

    public void bmi(View v){


    //test 03 add branch
    /*public void bmi(View v){


        Intent intent = new Intent(MainActivity.this,BMI.class);
        //Intent intent = new Intent(this,expense_home.class);
        startActivity(intent);
    }*/

    public void diet(View v){

        Intent intent = new Intent(this,diet.class);
        //Intent intent = new Intent(this,expense_home.class);
        startActivity(intent);
    }

   /* public void reminder(View v){

        Intent intent = new Intent(MainActivity.this,REMINDER.class);
        //Intent intent = new Intent(this,expense_home.class);
        startActivity(intent);
    }*/

//commit
}
