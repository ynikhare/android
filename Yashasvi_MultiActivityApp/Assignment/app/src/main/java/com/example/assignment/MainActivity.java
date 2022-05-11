package com.example.assignment;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView tim = null;
    private ImageView sundar = null;
    private ImageView satya = null;

    private TextView timText = null;
    private TextView sundarText = null;
    private TextView satyaText = null;

    private TextView timtitle = null;
    private TextView sundartitle = null;
    private TextView satyatitle = null;

    private Button timinfo = null;
    private Button sundarinfo = null;
    private Button satyainfo = null;

    private Person timData = null;
    private Person sundarData = null;
    private Person satyaData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wiring the objects with widgets
        //images
        tim = findViewById(R.id.imageView1);
        sundar = findViewById(R.id.imageView2);
        satya = findViewById(R.id.imageView3);
        //buttons
        timinfo = findViewById(R.id.button1);
        sundarinfo = findViewById(R.id.button2);
        satyainfo = findViewById(R.id.button3);
        //textviews
        timText = findViewById(R.id.textView11);
        sundarText = findViewById(R.id.textView21);
        satyaText = findViewById(R.id.textView31);
        timtitle = findViewById(R.id.textView12);
        sundartitle = findViewById(R.id.textView22);
        satyatitle = findViewById(R.id.textView32);


        //making data
        timData = new Person("Tim Cook",
                "Chief Executive Officer of Apple",
                "1 Infinite Loop, Cupertino, CA 95014, USA",
                "+1 408-996-1010",
                "tim.png",
                "https://twitter.com/tim_cook");
        sundarData = new Person("Sundar Pichai",
                "Chief Executive Officer of Alphabet",
                "1600 Amphitheatre Parkway, Mountain View, CA 94043",
                "+1 650-253-0000",
                "sundar.png",
                "https://twitter.com/sundarpichai");
        satyaData = new Person("Satya Nadella",
                "Chief Executive Officer of Microsoft",
                "Microsoft Corporation, One Microsoft Way, Redmond, WA 98052-6399, USA.",
                "+1 425-882-8080",
                "satya.png",
                "https://twitter.com/satyanadella");


        //populate widget with Data
        timText.setText(timData.getName());
        timtitle.setText(timData.getTitle());
        sundarText.setText(sundarData.getName());
        sundartitle.setText(sundarData.getTitle());
        satyaText.setText(satyaData.getName());
        satyatitle.setText(satyaData.getTitle());

        //getting image from its name
        String name1 = timData.getImage();
        name1 = name1.substring(0, name1.indexOf("."));
        int imageID1 = this.getResources().getIdentifier(name1, "drawable", this.getPackageName());
        tim.setImageResource(imageID1);

        String name2 = sundarData.getImage();
        name2 = name2.substring(0, name2.indexOf("."));
        int imageID2 = this.getResources().getIdentifier(name2, "drawable", this.getPackageName());
        sundar.setImageResource(imageID2);

        String name3 = satyaData.getImage();
        name3 = name3.substring(0, name3.indexOf("."));
        int imageID3 = this.getResources().getIdentifier(name3, "drawable", this.getPackageName());
        satya.setImageResource(imageID3);

        //button event for tim
        timinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //make an explicit intent and a bundle

                Intent intent =new Intent(MainActivity.this, timDetails.class);
                Bundle bundle = new Bundle();

                //place personData in the bundle

                bundle.putSerializable("data", timData);

                //put Bundle in the intent

                intent.putExtras(bundle);

                //start activity
                startActivity(intent);


            }
        });

        //button event for sundar
        sundarinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //make an explicit intent and a bundle

                Intent intent =new Intent(MainActivity.this, sundarDetails.class);
                Bundle bundle = new Bundle();

                //place personData in the bundle

                bundle.putSerializable("data", sundarData);

                //put Bundle in the intent

                intent.putExtras(bundle);

                //start activity
                startActivity(intent);
            }
        });

        //button event for satya
        satyainfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //make an explicit intent and a bundle

                Intent intent =new Intent(MainActivity.this, satyaDetails.class);
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