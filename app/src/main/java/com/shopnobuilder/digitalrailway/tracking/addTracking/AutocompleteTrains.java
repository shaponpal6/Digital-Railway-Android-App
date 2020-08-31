package com.shopnobuilder.digitalrailway.tracking.addTracking;

/**
 * Created by SHOPNOBUILDER on 5/5/2018.
 */

public class AutocompleteTrains {
    private String trainName;
    private String trainFrom;
    private String trainTo;

    public AutocompleteTrains(String trainName, String trainFrom, String trainTo) {
        this.trainName = trainName;
        this.trainFrom = trainFrom;
        this.trainTo = trainTo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainFrom() {
        return trainFrom;
    }

    public void setTrainFrom(String trainFrom) {
        this.trainFrom = trainFrom;
    }

    public String getTrainTo() {
        return trainTo;
    }

    public void setTrainTo(String trainTo) {
        this.trainTo = trainTo;
    }
}
