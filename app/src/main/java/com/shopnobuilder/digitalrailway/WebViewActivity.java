package com.shopnobuilder.digitalrailway;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.shopnobuilder.digitalrailway.library.AppStatus;

public class WebViewActivity extends AppCompatActivity {

    private WebView myWebView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(WebViewActivity.this, MainActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(WebViewActivity.this, FindTrainActivity.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(WebViewActivity.this, BaseActivity.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        if (AppStatus.getInstance(this).isOnline()) {
             Toast.makeText(this,"You are online!!!!",Toast.LENGTH_LONG).show();
        } else {
            startActivity(new Intent(WebViewActivity.this, MainActivity.class));
            //Toast.makeText(this,"You are not online!!!!",Toast.LENGTH_LONG).show();
            Log.v("Home", "############################You are not online!!!!");
        }

        //Web View
        myWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://api.shapon.website");
        myWebView.setWebViewClient(new WebViewClient());


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
