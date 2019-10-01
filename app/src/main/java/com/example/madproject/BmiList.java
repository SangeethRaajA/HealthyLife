package com.example.madproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class BmiList extends AppCompatActivity {
    GridView gridView;
    ArrayList<Bmi> list;
    BmiListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_list_activity);
        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new BmiListAdapter(this, R.layout.bmi_item, list);
        gridView.setAdapter(adapter);


        // get all data from sqlite
        Cursor cursor = Calculate.BSQLiteHelper.getData("SELECT * FROM BMI");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String height = cursor.getString(2);
            String weight = cursor.getString(3);
            String ans = cursor.getString(4);


            list.add(new Bmi(name, height, weight, ans, id));
        }
        adapter.notifyDataSetChanged();

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                CharSequence[] items = {"Update", "Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(BmiList.this);

                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (item == 0) {
                            // update
                            Cursor c = Calculate.BSQLiteHelper.getData("SELECT id FROM BMI");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            // show dialog update at here
                            showDialogUpdate(BmiList.this, arrID.get(position));

                        } else {
                            // delete
                            Cursor c = Calculate.BSQLiteHelper.getData("SELECT id FROM BMI");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });
    }


    private void showDialogUpdate(Activity activity, final int position){

        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.update_bmi_activity);
        dialog.setTitle("Update");

        final EditText edtName = (EditText) dialog.findViewById(R.id.editName);
        Button btnUpdate = (Button) dialog.findViewById(R.id.btnUpdate);

        // set width for dialog
        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        // set height for dialog
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Calculate.BSQLiteHelper.updateData(
                            edtName.getText().toString().trim(), position
                    );
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Updated successfully!!!", Toast.LENGTH_SHORT).show();
                }
                catch (Exception error) {
                    Log.e("Update error", error.getMessage());
                }
                updateBmiList();
            }
        });
    }

    private void showDialogDelete(final int idBmi){
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(BmiList.this);

        dialogDelete.setTitle("Warning!");
        dialogDelete.setMessage("Are you sure you want to delete?");
        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    Calculate.BSQLiteHelper.deleteData(idBmi);
                    Toast.makeText(getApplicationContext(), "Deleted successfully!!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Log.e("error", e.getMessage());
                }
                updateBmiList();
            }
        });

        dialogDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void updateBmiList(){
        // get all data from sqlite
        Cursor cursor = Calculate.BSQLiteHelper.getData("SELECT * FROM BMI");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String height = cursor.getString(2);
            String weight = cursor.getString(3);
            String ans = cursor.getString(4);


            list.add(new Bmi(name, height, weight, ans, id));
        }
        adapter.notifyDataSetChanged();
    }




}