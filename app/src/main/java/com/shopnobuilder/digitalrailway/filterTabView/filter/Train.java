package com.shopnobuilder.digitalrailway.filterTabView.filter;

import java.io.Serializable;

/**
 * Created by SHOPNOBUILDER on 2/24/2018.
 */

public class Train implements Serializable {
    private String trainNo;
    private String trainName;
    private String weeklyOffDay;
    private String startingStation;
    private String departureTime;
    private String arrivalStation;
    private String arrivalTime;

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getWeeklyOffDay() {
        return weeklyOffDay;
    }

    public void setWeeklyOffDay(String weeklyOffDay) {
        this.weeklyOffDay = weeklyOffDay;
    }

    public String getStartingStation() {
        return startingStation;
    }

    public void setStartingStation(String startingStation) {
        this.startingStation = startingStation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
