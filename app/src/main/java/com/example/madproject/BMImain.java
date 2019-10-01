package com.example.madproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.CalendarView;


public class BMImain extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmimain);

    }

        public void sendValue(View view)
        {
           Intent int1 = new Intent(BMImain.this,Calculate.class);
           startActivity(int1);
           // startActivity(new Intent(BMImain.this, CalendarView.class));

        }

    public void Gotohistory(View view) {
        Intent i1 = new Intent(BMImain.this,BmiList.class);
        startActivity(i1);
    }
    /*public void his(View view)
    {
        Intent i1 = new Intent(BMImain.this,BmiList.class);
        startActivity(i1);

    }*/


    }

