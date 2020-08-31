package com.shopnobuilder.digitalrailway.tracking.viewTracking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by SHOPNOBUILDER on 4/20/2018.
 */

public class TrainTracking {
    ArrayList<Tracking> trackings = new ArrayList<>();

    public ArrayList<Tracking> getTrackings(String jsonString){
        // ------------ push In Array ----------
        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONArray m_jArry = obj.getJSONArray("all_tracking");

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);

                //-----
                String tracking_id = jo_inside.getString("tracking_id");
                String user_id = jo_inside.getString("user_id");
                String tracking_status = jo_inside.getString("tracking_status");
                String tr_name = jo_inside.getString("tr_name");
                String tr_to = jo_inside.getString("tr_to");
                String tr_form = jo_inside.getString("tr_form");
                String current_station = jo_inside.getString("current_station");
                String delay_time = jo_inside.getString("status");
                String status = jo_inside.getString("current_station");
                String tracking_time = jo_inside.getString("tracking_time");
                String created_at = jo_inside.getString("created_at");


                // Log.d("Details-->", jo_inside.getString("trainName"));


                Tracking tracking = new Tracking();
                //Add your values in your `ArrayList` as below:
                tracking.setTracking_id(tracking_id);
                tracking.setUser_id(user_id);
                tracking.setTracking_status(tracking_status);
                tracking.setTr_name(tr_name);
                tracking.setTr_to(tr_to);
                tracking.setTr_form(tr_form);
                tracking.setCurrent_station(current_station);
                tracking.setDelay_time(delay_time);
                tracking.setStatus(status);
                tracking.setTracking_time(tracking_time);
                tracking.setCreated_at(created_at);

                trackings.add(tracking);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return trackings;

        // ------------ push In Array ----------
    }
}
