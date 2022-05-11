package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class moreInfo extends AppCompatActivity {

    private TextView nameTV = null , titleTV = null, addressTV = null, phoneTV = null, urlTV = null;
    private Person timData = null;
    private WebView mWebview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_info);

        mWebview  = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });



        //wire the textviews
        nameTV = findViewById(R.id.timname);
        titleTV = findViewById(R.id.timtitle);
        addressTV = findViewById(R.id.timaddress);
        phoneTV = findViewById(R.id.timphone);
        urlTV = findViewById(R.id.timurl);
        urlTV.setPaintFlags(urlTV.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        //get the data from the intent
        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();

        timData = (Person) bundle.getSerializable("data");

        //populate textfields
        nameTV.setText(timData.getName());
        titleTV.setText(timData.getTitle());
        addressTV.setText(timData.getAddress());
        phoneTV.setText(timData.getPhone());
        urlTV.setText(timData.getUrl());

        //button event for urltext
        urlTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebview.loadUrl(timData.getUrl());
                setContentView(mWebview);
            }
        });

    }



}