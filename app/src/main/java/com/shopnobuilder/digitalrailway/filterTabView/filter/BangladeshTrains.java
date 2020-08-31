package com.shopnobuilder.digitalrailway.filterTabView.filter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by SHOPNOBUILDER on 3/2/2018.
 */

public class BangladeshTrains {
    ArrayList<Train> trains = new ArrayList<>();

    public ArrayList<Train> getTrains(String jsonString){
        // ------------ push In Array ----------
        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONArray m_jArry = obj.getJSONArray("itbg");

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);

                //-----
                String trainNo = jo_inside.getString("trainNo");
                String trainName = jo_inside.getString("trainName");
                String weeklyOffDay = jo_inside.getString("weeklyOffDay");
                String startingStation = jo_inside.getString("startingStation");
                String departureTime = jo_inside.getString("departureTime");
                String arrivalStation = jo_inside.getString("arrivalStation");
                String arrivalTime = jo_inside.getString("arrivalTime");

               // Log.d("Details-->", jo_inside.getString("trainName"));


                Train train = new Train();
                //Add your values in your `ArrayList` as below:
                train.setTrainNo(trainNo);
                train.setTrainName(trainName);
                train.setWeeklyOffDay(weeklyOffDay);
                train.setStartingStation(startingStation);
                train.setDepartureTime(departureTime);
                train.setArrivalStation(arrivalStation);
                train.setArrivalTime(arrivalTime);

                trains.add(train);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return trains;

        // ------------ push In Array ----------
    }
}
