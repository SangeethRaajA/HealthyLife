package com.example.madproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculate extends AppCompatActivity {
    EditText height;
    EditText weight;
    EditText name;
    TextView res;
    Button btnSave, btnList,btnCal;

    public static BSQLiteHelper BSQLiteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        init();

        BSQLiteHelper = new BSQLiteHelper(this, "HealthLifeDB.sqlite", null, 1);

        BSQLiteHelper.queryData("CREATE TABLE IF NOT EXISTS BMI(Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, height VARCHAR, weight VARCHAR,ans VARCHAR)");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(!name.equals("") && !height.equals("") && !weight.equals("") && !res.equals("")) {
                if(name.getText().toString().length() == 0 && height.getText().toString().length() == 0 && weight.getText().toString().length() == 0 && res.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "Empty fields!", Toast.LENGTH_LONG).show();
                }else {//if(name.getText().toString().length() == 0 || height.getText().toString().length() == 0 || weight.getText().toString().length() == 0 || res.getText().toString().length() == 0){


                    BSQLiteHelper.insertData(
                            name.getText().toString().trim(),
                            height.getText().toString().trim(),
                            weight.getText().toString().trim(),
                            res.getText().toString().trim()
                    );
                    Toast.makeText(getApplicationContext(), "Saved successfully!", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    height.setText("");
                    weight.setText("");
                    res.setText("");
                }
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculate.this, BmiList.class);
                startActivity(intent);
            }
        });

    }
    public void back(View view)
    {
        Intent in1 = new Intent(Calculate.this, BMImain.class);
        startActivity(in1);

    }

    public void CalBMI(View view) {
        {
            String h = height.getText().toString();
            String w = weight.getText().toString();

            if(h!=null && !"".equals(h) && w!=null && !"".equals(w))
            {
                Float hf = Float.parseFloat(h);
                Float wf = Float.parseFloat(w);
                float bmi = (wf/(hf*hf))*10000;
                String lbl ="";

                if(bmi<=18.5){
                    lbl = getString(R.string.under);

                }
                else if(bmi>18.55 && bmi<= 24.99){
                    lbl = getString(R.string.over);
                }
                else{
                    lbl = getString(R.string.obesity);

                }
                res.setText(bmi+"\n\n"+lbl);
            }
        }
    }


    private void init(){
        name = (EditText) findViewById(R.id.editName);
        height = (EditText) findViewById (R.id.editHeight);
        weight= (EditText) findViewById (R.id.editWeight);
        res = (TextView) findViewById (R.id.res);
        btnCal = (Button) findViewById(R.id.btnCal);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnList = (Button) findViewById(R.id.btnHistory);


    }
}





