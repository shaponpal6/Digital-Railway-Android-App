package com.shopnobuilder.digitalrailway.tracking.viewTracking;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.shopnobuilder.digitalrailway.httpRequest.HttpRequestHandler;

/**
 * Created by SHOPNOBUILDER on 4/21/2018.
 */

public class ViewTrackingRequestHandler extends AsyncTask<Void, Void, String> {
    Context context;
    // Request URL
    String url;

    public ViewTrackingRequestHandler(Context c, String url){
        this.context = c;
        this.url = url;
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
        String s = backgroundWorker.getRequestHandler(url);
        if (s.length() > 0) {
            return  s.toString();
        }else {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        //progressBar.setVisibility(GONE);
        //Toast.makeText(getApplicationContext, "Result : " + s, Toast.LENGTH_LONG).show();
        Toast.makeText(context, "Return Result: "+s, Toast.LENGTH_LONG).show();
        Log.d("+++Trains+++", s);
    }
}


