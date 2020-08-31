package com.shopnobuilder.digitalrailway.filterTabView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopnobuilder.digitalrailway.R;
import com.shopnobuilder.digitalrailway.filterTabView.filter.BangladeshTrains;
import com.shopnobuilder.digitalrailway.filterTabView.filter.MyAdapter;
import com.shopnobuilder.digitalrailway.filterTabView.filter.Train;
import com.shopnobuilder.digitalrailway.filterTabView.filter.byTrain.FilterByTrainAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by SHOPNOBUILDER on 2/24/2018.
 */

public class FilterByTrainName extends Fragment {
    SearchView sv;
    ArrayList<Train> trains = new ArrayList<>();

    FilterByTrainAdapter byTrainAdapter;


    public FilterByTrainName() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.find_train_by_train_name, container, false);

        // ------------ Get Trains ----------
        BangladeshTrains bangladeshTrains = new BangladeshTrains();
        this.trains = bangladeshTrains.getTrains(loadJSONFromAsset("itbg.json"));
        // ------------ Get Trains ----------

        // ------------ Filter ----------
        sv = (SearchView) rootView.findViewById(R.id.mSearch);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.myRecycler);

        //SET ITS PROPETRIES
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        byTrainAdapter = new FilterByTrainAdapter(getContext(), this.trains);
        rv.setAdapter(byTrainAdapter);

        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                byTrainAdapter.getFilter().filter(query);
                return false;
            }
        });
        //------------- Filter Code ------------

        return rootView;
    }

    public String loadJSONFromAsset(String url) {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open(url);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
