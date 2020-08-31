package com.shopnobuilder.digitalrailway.httpRequest;

/**
 * Created by DELL on 4/16/2018.
 */
public class Constant {
    // Root Url
    //private static final String BASE_PATH = "http://shapon.website/android/CRUD/";
    private static final String BASE_PATH = "http://railway.shapon.website/";

    public static final String CREATE_URL = BASE_PATH + "tracking/add";
    public static final String VIEW_TRACKING = BASE_PATH + "tracking/view_json";
    public static final String READ = BASE_PATH + "tracking/view";
    public static final String UPDATE = BASE_PATH + "updateEmp.php";
    public static final String DELETE = BASE_PATH + "deleteEmp.php";

    public static final String GET_METHOD = "GET";
    static final String POST_METHOD = "POST";
}