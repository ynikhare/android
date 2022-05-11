package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class satyaDetails extends AppCompatActivity {

    private TextView nameTV = null , titleTV = null, addressTV = null, phoneTV = null;
    private ImageView photoTV = null;
    private Person satyaData = null;
    private Button more =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.satya_details);

        //wire the textviews
        nameTV = findViewById(R.id.satyaname);
        titleTV = findViewById(R.id.satyatitle);
        addressTV = findViewById(R.id.satyaaddress);
        phoneTV = findViewById(R.id.satyaphone);

        //wire image
        photoTV = findViewById(R.id.satyaimageView);

        //wire button
        more = findViewById(R.id.moreinfo);

        //get the data from the intent
        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();

        satyaData = (Person) bundle.getSerializable("data");

        //populate textfields
        nameTV.setText(satyaData.getName());
        titleTV.setText(satyaData.getTitle());
        addressTV.setText(satyaData.getAddress());
        phoneTV.setText(satyaData.getPhone());

        //populate ImageView
        String name1 = satyaData.getImage();
        name1 = name1.substring(0, name1.indexOf("."));
        int imageID1 = this.getResources().getIdentifier(name1, "drawable", this.getPackageName());
        photoTV.setImageResource(imageID1);

        //button event for moreinfo

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //make an explicit intent and a bundle

                Intent intent =new Intent(satyaDetails.this, moreInfo.class);
                Bundle bundle = new Bundle();

                //place personData in the bundle

                bundle.putSerializable("data", satyaData);

                //put Bundle in the intent

                intent.putExtras(bundle);

                //start activity
                startActivity(intent);
            }
        });

    }
}