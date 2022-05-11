package com.example.clocktest;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class PrefActivity extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    Button button;
    String colourSelected;

        protected void onCreate(Bundle savedInstanceState){


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pref);
            spinner1 = findViewById(R.id.spinner1);
            spinner2 = findViewById(R.id.spinner2);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.colourList));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapter);
            spinner1.setSelection(0);

            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                    switch (position){
                        case 1:
                            colourSelected = "Black";
                            SaveIntoSharedPrefs("colour",colourSelected);
                        case 2:
                            colourSelected = "Blue";
                            SaveIntoSharedPrefs("colour",colourSelected);
                        case 3:
                            colourSelected = "Red";
                            SaveIntoSharedPrefs("colour",colourSelected);
                            
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent){

                }
            });

        }

    private void SaveIntoSharedPrefs(String colour, String colourSelected){
    }

}
