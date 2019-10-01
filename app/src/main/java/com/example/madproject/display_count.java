package com.example.madproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class display_count extends AppCompatActivity {

    TextView answer;
    String total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_count);

        answer=findViewById(R.id.answer_txt);
        Intent intent02=getIntent();
        total=intent02.getStringExtra("total");
        answer.setText(total);

    }

    public void cancel(View v3)
    {
        Intent i3=new Intent(this,select_meal.class);
        startActivity(i3);
    }

    public void save(View v4)
    {
        Intent i4=new Intent(this,Add_form.class);
        String cal=answer.getText().toString();
        i4.putExtra("calory",cal);
        startActivity(i4);
    }
}
