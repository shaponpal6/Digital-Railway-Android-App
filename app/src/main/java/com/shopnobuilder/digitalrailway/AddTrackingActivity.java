package com.shopnobuilder.digitalrailway;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.shopnobuilder.digitalrailway.httpRequest.Constant;
import com.shopnobuilder.digitalrailway.httpRequest.HttpRequestHandler;
import com.shopnobuilder.digitalrailway.tracking.addTracking.AutocompleteTrainAdapter;
import com.shopnobuilder.digitalrailway.tracking.addTracking.AutocompleteTrains;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddTrackingActivity extends AppCompatActivity {
    // Custom
    private List<AutocompleteTrains> trains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tracking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Drop Down
        final AutoCompleteTextView trNameFilter = (AutoCompleteTextView) findViewById(R.id.tracking_tr_name);
        ImageView trImg1 = (ImageView) findViewById(R.id.aro2);
        final AutoCompleteTextView actv1 = (AutoCompleteTextView) findViewById(R.id.tracking_tr_name);
        ImageView aro = (ImageView) findViewById(R.id.aro1);
        Button submit = (Button) findViewById(R.id.tracking_submit_btn);

        // Train Name filter
        fillTrains();

        AutoCompleteTextView actv_tr_name = (AutoCompleteTextView)findViewById(R.id.tracking_tr_name);
        AutocompleteTrainAdapter autoCompleteCountryAdapter = new AutocompleteTrainAdapter(this, trains);
        actv_tr_name.setAdapter(autoCompleteCountryAdapter);
        //---------------old------------ ok --------------
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,colors);
//        actv1.setAdapter(adapter);

        //Expend Dropdown
        aro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actv1.showDropDown();
            }
        });

        // Submit
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color = actv1.getText().toString();
                Toast.makeText(getApplicationContext(), "Color: "+ color, Toast.LENGTH_LONG).show();

                // Create Tracking
                createTracking(view);
            }
        });
        //--------------------------- ok ---------------
    }
    private static final String[] colors = new String[]{"Red","white","green","Blue"};

    // Create
    public void createTracking(View view){
        // Initialize EditText View
        EditText mTrName = (EditText) findViewById(R.id.tracking_tr_name);
        EditText mTrForm = (EditText) findViewById(R.id.tracking_tr_from);
        EditText mTrTo = (EditText) findViewById(R.id.tracking_tr_to);
        EditText mTrCurrentStation = (EditText) findViewById(R.id.tracking_tr_current_station);
        EditText mTrStatus = (EditText) findViewById(R.id.tracking_tr_status);
        EditText mTrDelay = (EditText) findViewById(R.id.tracking_tr_delay);

        Button mTracking_submit_btn = (Button) findViewById(R.id.tracking_submit_btn);

        String trName = mTrName.getText().toString();
        String trForm = mTrForm.getText().toString();
        String trTo = mTrTo.getText().toString();
        String trCurrentStation = mTrCurrentStation.getText().toString();
        String trStatus = mTrStatus.getText().toString();
        String trDelay = mTrDelay.getText().toString();

        HashMap<String, String> trParams = new HashMap<>();
        trParams.put("tr_name", trName);
        trParams.put("tr_form", trForm);
        trParams.put("tr_to", trTo);
        trParams.put("current_station", trCurrentStation);
        trParams.put("tracking_status", trStatus);
        trParams.put("delay_time", trDelay);

        //Log.d("HashMap", requestedParams.get("tr_name"));
        //Toast.makeText(getApplicationContext(), "Success!!! Employee Added Name: " + trParams.get("tr_name"), Toast.LENGTH_LONG).show();

        //HttpPostRequest httpPostRequest = new HttpPostRequest(Constant.CREATE_URL, requestedParams);
        //httpPostRequest.execute();

        HttpPostRequest httpPostRequest = new HttpPostRequest(this, Constant.CREATE_URL, trParams);
        httpPostRequest.execute();

        //HttpPostRequest postRequestHandler = new HttpPostRequest(Constant.CREATE_URL, requestedParams);
        //postRequestHandler.execute();
    }

    // Demo Data
    private void fillTrains() {
        trains = new ArrayList<>();
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Breujs", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bare", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Chotla", "Chittagong", "Daugong"));
        trains.add(new AutocompleteTrains("Abu", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
        trains.add(new AutocompleteTrains("Bromopotro", "Dhaka", "Daugong"));
    }

    // Send Post Request
    public class HttpPostRequest extends AsyncTask<Void, Void, String> {
        Context context;
        // Request URL
        String url;
        // Key, Value pair
        HashMap<String, String> requestedParams;

        public HttpPostRequest(Context c, String url, HashMap<String, String> params){
            this.context = c;
            this.url = url;
            this.requestedParams = params;
            // Log.d("Input Box", designation);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... voids) {

            // Now Send a post request
            HttpRequestHandler backgroundWorker = new HttpRequestHandler();
            try {
                String s = backgroundWorker.postRequestHandler(url, requestedParams);
//                    Log.d("HashMap--------", requestedParams.get("salary"));
//                    Log.d("Results------", s.toString());
//                    Toast.makeText(getApplicationContext(), s.toString(), Toast.LENGTH_LONG).show();
                return s.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //progressBar.setVisibility(GONE);
            //Toast.makeText(getApplicationContext, "Result : " + s, Toast.LENGTH_LONG).show();

            if (s != null){
                startActivity(new Intent(AddTrackingActivity.this, ViewTrackingActivity.class));
                Toast.makeText(context, "Return Result: "+s, Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(context, "Sorry Not Added Tracking !! Return Result: "+s, Toast.LENGTH_LONG).show();
            }
        }
    }


}
