package com.shopnobuilder.digitalrailway;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.shopnobuilder.digitalrailway.filterTabView.filter.Train;

public class TrainViewActivity extends AppCompatActivity {

    private TextView mTextMessage;
    public Bundle train;
    public TextView mTv1, mTv2, mTv3, mTv4, mTv5, mTv6, mTv7, mTv8;

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
        setContentView(R.layout.activity_train_view);

        //mTv1 = (TextView) findViewById(R.id.trId);
        mTv2 = (TextView) findViewById(R.id.trainNo2);
        mTv3 = (TextView) findViewById(R.id.trName);
        mTv4 = (TextView) findViewById(R.id.trStartingStation);
        mTv5 = (TextView) findViewById(R.id.trDepartureTime);
        mTv6 = (TextView) findViewById(R.id.trArrivalStation);
        mTv7 = (TextView) findViewById(R.id.trArrivalTime);
        mTv8 = (TextView) findViewById(R.id.trWeeklyOffDay);

        // Get Train
        Train train = (Train) this.getIntent().getSerializableExtra("train");
        //train = this.getIntent().getExtras();
        if (train != null){
            mTv2.setText(String.valueOf(train.getTrainNo()));
            mTv3.setText(train.getTrainName());
            mTv4.setText(train.getStartingStation());
            mTv5.setText(train.getDepartureTime());
            mTv6.setText(train.getArrivalStation());
            mTv7.setText(train.getArrivalTime());
            mTv8.setText(train.getWeeklyOffDay());

            Toast.makeText(getApplicationContext(), train.getTrainNo().toString(), Toast.LENGTH_LONG).show();

        }



        // Navigation
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
