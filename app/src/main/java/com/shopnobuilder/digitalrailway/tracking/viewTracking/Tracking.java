package com.shopnobuilder.digitalrailway.tracking.viewTracking;

import java.io.Serializable;

/**
 * Created by SHOPNOBUILDER on 4/20/2018.
 */

public class Tracking implements Serializable {
    private String tracking_id;
    private String user_id;
    private String tracking_status;
    private String tr_name;
    private String tr_to;
    private String tr_form;
    private String current_station;
    private String delay_time;
    private String status;
    private String tracking_time;
    private String created_at;

    public String getTracking_id() {
        return tracking_id;
    }

    public void setTracking_id(String tracking_id) {
        this.tracking_id = tracking_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTracking_status() {
        return tracking_status;
    }

    public void setTracking_status(String tracking_status) {
        this.tracking_status = tracking_status;
    }

    public String getTr_name() {
        return tr_name;
    }

    public void setTr_name(String tr_name) {
        this.tr_name = tr_name;
    }

    public String getTr_to() {
        return tr_to;
    }

    public void setTr_to(String tr_to) {
        this.tr_to = tr_to;
    }

    public String getTr_form() {
        return tr_form;
    }

    public void setTr_form(String tr_form) {
        this.tr_form = tr_form;
    }

    public String getCurrent_station() {
        return current_station;
    }

    public void setCurrent_station(String current_station) {
        this.current_station = current_station;
    }

    public String getDelay_time() {
        return delay_time;
    }

    public void setDelay_time(String delay_time) {
        this.delay_time = delay_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTracking_time() {
        return tracking_time;
    }

    public void setTracking_time(String tracking_time) {
        this.tracking_time = tracking_time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
