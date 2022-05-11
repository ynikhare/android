package com.example.clocktest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private  ClockSurfaceView clock;
    private  int length = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        clock = new ClockSurfaceView(this, length);
        setContentView(clock);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        //setup some menu components with their listeners

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int itemID = item.getItemId();

        switch (itemID){
            case R.id.about:
                // do a dialog box to say who you are
                androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Yashasvi Nikhare \n\n 120220982 \n\n MScCS@2020\n\nUCC")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        });

                builder.show();
                break;
            case  R.id.prefs:
                Intent intent1 =new Intent(MainActivity.this, PrefActivity.class);
                Bundle bundle2 = new Bundle();
                startActivity(intent1);
                break;
            case  R.id.alarm:
                Intent intent2 =new Intent(MainActivity.this, Alarm.class);
                Bundle bundle = new Bundle();
                startActivity(intent2);

                break;
        }

        return false;
    }


}