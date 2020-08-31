package com.shopnobuilder.digitalrailway.tracking.viewTracking;

import android.content.Context;
import android.content.Loader;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shopnobuilder.digitalrailway.R;
import com.shopnobuilder.digitalrailway.httpRequest.Constant;
import com.shopnobuilder.digitalrailway.httpRequest.HttpRequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by DELL on 4/18/2018.
 */

public class ViewTrackingClass extends Fragment {

    SearchView sv;
    RecyclerView rv;
    //ArrayList<Train> trains = new ArrayList<>();
    ArrayList<Tracking> trackings = new ArrayList<>();
    ViewTrackingAdapter viewTrackingAdapter;
    //MyAdapter adapter;
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    //private boolean loading;
    private Loader.OnLoadCanceledListener onLoadMoreListener;

    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount;

    public ViewTrackingClass() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.view_tracking_class, container, false);

        // ------------ Get Trains ----------
        //TrainTracking trainTracking = new TrainTracking();
        //this.trackings = trainTracking.getTrains("http://api.shapon.website/tracking/view_json");

        HttpGetRequest httpGetRequest = new HttpGetRequest(getContext(), Constant.VIEW_TRACKING);
        httpGetRequest.execute();


        //Log.d("++JSON+++++ ", this.trackings.toString());

//        BangladeshTrains bangladeshTrains = new BangladeshTrains();
//        this.trains = bangladeshTrains.getTrains(loadJSONFromAsset("itbg.json"));
        // ------------ Get Trains ----------
        //------------- Filter Code ------------
        sv = (SearchView) rootView.findViewById(R.id.mSearch2);
        rv = (RecyclerView) rootView.findViewById(R.id.myRecycler2);

        //SET ITS PROPETRIES
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setItemAnimator(new DefaultItemAnimator());
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) rv.getLayoutManager();

        // OnScrollLesener
        if (rv.getLayoutManager() instanceof LinearLayoutManager) {

            rv.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override
                public void onScrolled(RecyclerView recyclerView,
                                       int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager
                            .findLastVisibleItemPosition();
                    if (loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        // End has been reached
                        // Do something
                        HttpGetRequest httpGetRequest = new HttpGetRequest(getContext(), Constant.VIEW_TRACKING);
                        httpGetRequest.execute();

                        Toast.makeText(getContext(), "Now Load More1111 ", Toast.LENGTH_LONG).show();
                        if (onLoadMoreListener != null) {
                            //onLoadMoreListener.onLoadMore();
                            //https://stackoverflow.com/questions/31000964/how-to-implement-setonscrolllistener-in-recyclerview
                            Toast.makeText(getContext(), "Now Load More ", Toast.LENGTH_LONG).show();
                        }
                        loading = false;
                    }
                }

                @Override
                public void onScrollStateChanged(RecyclerView recyclerView,int scrollState) {
                    //blank, not using this
                }
            });
        }






//        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            int ydy = 0;
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                int offset = dy - ydy;
//                ydy = dy;
//                boolean shouldRefresh = (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0)
//                        && (recyclerView.getScrollState() == RecyclerView.SCROLL_STATE_DRAGGING) && offset > 30;
//                if (shouldRefresh) {
//                    //swipeRefreshLayout.setRefreshing(true);
//                    //Refresh to load data here.
//                    return;
//                }
//                boolean shouldPullUpRefresh = linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getChildCount() - 1
//                        && recyclerView.getScrollState() == RecyclerView.SCROLL_STATE_DRAGGING && offset < -30;
//                if (shouldPullUpRefresh) {
//                    //swipeRefreshLayout.setRefreshing(true);
//                    //refresh to load data here.
//                    return;
//                }
//                //swipeRefreshLayout.setRefreshing(false);
//            }
//        });







        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                viewTrackingAdapter.getFilter().filter(query);
                return false;
            }
        });

        //------------- Filter Code ------------
        return rootView;
    }


    // Http Request Handler
    public class HttpGetRequest extends AsyncTask<Void, Void, String> {
        Context context;
        public ContentLoadingProgressBar contentLoadingProgressBar;
        // Request URL
        String url;
        public android.app.ProgressDialog progDailog;

        public HttpGetRequest(Context c, String url){
            this.context = c;
            this.url = url;
            // Log.d("Input Box", designation);
            contentLoadingProgressBar = new ContentLoadingProgressBar(c);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progDailog = new android.app.ProgressDialog(getActivity());
            progDailog.setMessage("Loading...");
            progDailog.setIndeterminate(false);
            progDailog.setProgressStyle(android.app.ProgressDialog.STYLE_SPINNER);
            progDailog.setCancelable(true);
            progDailog.show();
            //progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... voids) {

            // Now Send a post request
            HttpRequestHandler backgroundWorker = new HttpRequestHandler();
            String s = backgroundWorker.getRequestHandler(url);

            // Json String to arraylist

            if (s.length() > 0) {
                return  s.toString();
            }else {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            TrainTracking trainTracking = new TrainTracking();
            trackings = trainTracking.getTrackings(s.toString());



            //ADAPTER
            viewTrackingAdapter = new ViewTrackingAdapter(getContext(), trackings);
            rv.setAdapter(viewTrackingAdapter);

            contentLoadingProgressBar.hide();

            //progressBar.setVisibility(GONE);
            //Toast.makeText(getApplicationContext, "Result : " + s, Toast.LENGTH_LONG).show();
            //Toast.makeText(context, "Return Result: "+s, Toast.LENGTH_LONG).show();
            Log.d("+++Return Result+++", s);
            progDailog.dismiss();
        }
    }



}

