package com.shopnobuilder.digitalrailway.httpRequest;

import android.content.Context;
import android.os.AsyncTask;
import java.io.UnsupportedEncodingException;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
/**
 * Created by DELL on 4/16/2018.
 */

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
        Toast.makeText(context, "Return Result: "+s, Toast.LENGTH_LONG).show();
    }
}
