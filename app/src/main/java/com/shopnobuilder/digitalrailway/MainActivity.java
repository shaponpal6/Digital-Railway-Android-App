package com.shopnobuilder.digitalrailway;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shopnobuilder.digitalrailway.library.AppStatus;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
  
    Button mFindTrain, mOnline;
    public Button webview, mDigital;
    Toolbar toolbar;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Implement OnClickListener() For Buttons
        Button one = (Button) findViewById(R.id.find_train);
        one.setOnClickListener(this); // calling onClick() method
        Button two = (Button) findViewById(R.id.liveUpdate);
        two.setOnClickListener(this); // calling onClick() method
        Button three = (Button) findViewById(R.id.train_tacking);
        three.setOnClickListener(this); // calling onClick() method
        Button four = (Button) findViewById(R.id.buyTicket);
        four.setOnClickListener(this); // calling onClick() method
        Button five = (Button) findViewById(R.id.all_station_maps);
        five.setOnClickListener(this); // calling onClick() method
        Button six = (Button) findViewById(R.id.important_number);
        six.setOnClickListener(this); // calling onClick() method
        Button seven = (Button) findViewById(R.id.mobile_ticket);
        seven.setOnClickListener(this); // calling onClick() method

        // Check Internet Connection
        TextView notification = (TextView) findViewById(R.id.notification);
        if (AppStatus.getInstance(this).isOnline()) {
            notification.setText("You are online!!!!");
            Toast.makeText(this,"You are online!!!!",Toast.LENGTH_LONG).show();
        } else {
            notification.setText("You are not online!!!!");
            Toast.makeText(this,"You are not online!!!!",Toast.LENGTH_LONG).show();
            Log.v("Home", "############################You are not online!!!!");
        }



        // Navigation
        navigation();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.find_train:
                startActivity(new Intent(MainActivity.this, FindTrainActivity.class));
                break;
            case R.id.liveUpdate:
                startActivity(new Intent(MainActivity.this, AddTrackingActivity.class));
                break;
            case R.id.train_tacking:
                startActivity(new Intent(MainActivity.this, WebViewActivity.class));
                break;
            case R.id.buyTicket:
                startActivity(new Intent(MainActivity.this, SMSTicketingSystemDocActivity.class));
                break;
            case R.id.all_station_maps:
                startActivity(new Intent(MainActivity.this, ViewTrackingActivity.class));
                break;
            case R.id.important_number:
                startActivity(new Intent(MainActivity.this, ImportantNumberActivity.class));
                break;
            case R.id.mobile_ticket:
                startActivity(new Intent(MainActivity.this, AnimationActivity.class));
                break;

            default:
                break;
        }
    }

    public void navigation(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
