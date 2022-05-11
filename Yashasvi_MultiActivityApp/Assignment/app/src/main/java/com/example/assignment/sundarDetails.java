package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class sundarDetails extends AppCompatActivity {

    private TextView nameTV = null , titleTV = null, addressTV = null, phoneTV = null;
    private ImageView photoTV = null;
    private Person sundarData = null;
    private Button more = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sundar_details);

        //wire the textviews
        nameTV = findViewById(R.id.sundarname);
        titleTV = findViewById(R.id.sundartitle);
        addressTV = findViewById(R.id.sundaraddress);
        phoneTV = findViewById(R.id.sundarphone);

        //wire image
        photoTV = findViewById(R.id.sundarimageView);

        //wire button
        more = findViewById(R.id.moreinfo);

        //get the data from the intent
        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();

        sundarData = (Person) bundle.getSerializable("data");

        //populate textfields
        nameTV.setText(sundarData.getName());
        titleTV.setText(sundarData.getTitle());
        addressTV.setText(sundarData.getAddress());
        phoneTV.setText(sundarData.getPhone());

        //populate ImageView
        String name1 = sundarData.getImage();
        name1 = name1.substring(0, name1.indexOf("."));
        int imageID1 = this.getResources().getIdentifier(name1, "drawable", this.getPackageName());
        photoTV.setImageResource(imageID1);

        //button event for moreinfo

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //make an explicit intent and a bundle

                Intent intent =new Intent(sundarDetails.this, moreInfo.class);
                Bundle bundle = new Bundle();

                //place personData in the bundle

                bundle.putSerializable("data", sundarData);

                //put Bundle in the intent

                intent.putExtras(bundle);

                //start activity
                startActivity(intent);
            }
        });

    }
}