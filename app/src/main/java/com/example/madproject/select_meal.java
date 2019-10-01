package com.example.madproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class select_meal extends AppCompatActivity {

    private static DecimalFormat df2 = new DecimalFormat("#.##");
    EditText nuts,noodles,rice,cereal,oats,bread,tuna,meat,milk;
    EditText eggs,oranje,banana,apple,avacado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_meal);

        nuts=findViewById(R.id.nuts_txt);
        noodles=findViewById(R.id.noodles_txt);
        rice=findViewById(R.id.rice_txt);
        cereal=findViewById(R.id.cereal_txt);
        oats=findViewById(R.id.oats_txt);
        bread=findViewById(R.id.bread_txt);
        tuna=findViewById(R.id.tuna_txt);
        meat=findViewById(R.id.meat_txt);
        milk=findViewById(R.id.milk_txt);
        eggs=findViewById(R.id.eggs_txt);
        oranje=findViewById(R.id.orange_txt);
        banana=findViewById(R.id.banana_txt);
        apple=findViewById(R.id.apple_txt);
        avacado=findViewById(R.id.avacado_txt);


    }
    public void next(View v1)
    {

        double val=0;

        if(!nuts.getText().toString().equals(""))
        {
            String nut=nuts.getText().toString();
            val= (val+(6.07)*Double.parseDouble(nut));
        }
        if(!noodles.getText().toString().equals(""))
        {
            String nood = noodles.getText().toString();
            val = (val + (1.38) * Double.parseDouble(nood));
        }
        if(!rice.getText().toString().equals(""))
        {
            String ric = rice.getText().toString();
            val = (val + (1.30) * Double.parseDouble(ric));
        }
        if(!cereal.getText().toString().equals(""))
        {
            String cere = cereal.getText().toString();
            val = (val + (3.80) * Double.parseDouble(cere));
        }
        if(!oats.getText().toString().equals(""))
        {
            String oat = oats.getText().toString();
            val = (val + (3.90) * Double.parseDouble(oat));
        }
        if(!bread.getText().toString().equals(""))
        {
            String bre = bread.getText().toString();
            val = (val + (2.65) * Double.parseDouble(bre));
        }
        if(!tuna.getText().toString().equals(""))
        {
            String tun = tuna.getText().toString();
            val = (val + (1.44) * Double.parseDouble(tun));
        }
        if(!meat.getText().toString().equals(""))
        {
            String mea = meat.getText().toString();
            val = (val + (3.00) * Double.parseDouble(mea));
        }
        if(!milk.getText().toString().equals(""))
        {
            String mil = milk.getText().toString();
            val = (val + (0.42) * Double.parseDouble(mil));
        }
        if(!eggs.getText().toString().equals(""))
        {
            String egg = eggs.getText().toString();
            val = (val + (1.55) * Double.parseDouble(egg));
        }
        if(!oranje.getText().toString().equals(""))
        {
            String ora = oranje.getText().toString();
            val = (val + (0.45) * Double.parseDouble(ora));
        }
        if(!banana.getText().toString().equals(""))
        {
            String ban = banana.getText().toString();
            val = (val + (0.89) * Double.parseDouble(ban));
        }
        if(!apple.getText().toString().equals(""))
        {
            String app = apple.getText().toString();
            val = (val + (0.52) * Double.parseDouble(app));
        }
        if(!avacado.getText().toString().equals(""))
        {
            String ava = avacado.getText().toString();
            val = (val + (1.60) * Double.parseDouble(ava));
        }

        Intent i2=new Intent(this,display_count.class);
        String input=String.format("%.2f",val);
        String value=input;
        i2.putExtra("total",value);
        startActivity(i2);
    }
}
