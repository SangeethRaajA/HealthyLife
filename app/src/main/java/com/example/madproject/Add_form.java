package com.example.madproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

public class Add_form extends AppCompatActivity {

    EditText edtCalories, edtDate;
    Button  btnAdd, btnList;
    ImageView imageView;

    final int REQUEST_CODE_GALLERY = 999;
    public static SQLiteHelper sqLiteHelper;

    private static final String TAG="Add_form";
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);

        init();
        Intent i2=getIntent();
        String str=i2.getStringExtra("calory");
        edtCalories.setText(str);
        sqLiteHelper = new SQLiteHelper(this, "FoodDB.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS CALORY(id INTEGER PRIMARY KEY AUTOINCREMENT, calories VARCHAR, date VARCHAR)");

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(
                        Add_form.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet:dd/mm/yyy"+day+"/"+month+"/"+year);
                String date=day+"/"+month+"/"+year;
                edtDate.setText(date);
            }
        };

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (edtCalories.getText().toString().equals("") || edtDate.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Fill All Required Fields!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        sqLiteHelper.insertData(
                                edtCalories.getText().toString().trim(),
                                edtDate.getText().toString().trim()

                        );
                        Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
                        edtCalories.setText("");
                        edtDate.setText("");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Add_form.this,FoodList.class);
                startActivity(intent);
            }
        });

    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void init(){
        edtCalories = (EditText) findViewById(R.id.Edt_Calories);
        edtDate = (EditText) findViewById(R.id.Edt_Date);
        btnAdd = (Button) findViewById(R.id.Add_btn);
        btnList = (Button) findViewById(R.id.List_btn);
    }


}
