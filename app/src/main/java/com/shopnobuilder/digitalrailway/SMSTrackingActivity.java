package com.shopnobuilder.digitalrailway;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SMSTrackingActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private TextView mTrainNo, mSMSNo;
    private Button btnSMS;
    private String trainNo;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smstracking);

        // Tracking
        mTrainNo = findViewById(R.id.trainNo2);
        mSMSNo = findViewById(R.id.smsNo);
        btnSMS = findViewById(R.id.sendSMS);
        trainNo = getIntent().getStringExtra("TrainNo");
        mTrainNo.setText("Tr " + trainNo);

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String smsNO = (String) view.getTag(R.id.smsNo);
                Toast.makeText(SMSTrackingActivity.this, "Tr " + trainNo + " to 16318" , Toast.LENGTH_LONG).show();
            }
        });

        //String trainNO = (String) getTag(R.id.track);


        // Navigation
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
