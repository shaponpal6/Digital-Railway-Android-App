package com.shopnobuilder.digitalrailway.tracking.viewTracking;

/**
 * Created by DELL on 4/19/2018.
 */
import android.widget.Filter;

import java.util.ArrayList;

public class TrackingFilter extends Filter{

    ViewTrackingAdapter viewTrackingAdapter;
    ArrayList<Tracking> filterList;


    public TrackingFilter(ArrayList<Tracking> filterList, ViewTrackingAdapter adapter)
    {
        this.viewTrackingAdapter = adapter;
        this.filterList = filterList;

    }

    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<Tracking> filteredPlayers = new ArrayList<>();

            for (int i=0; i<filterList.size(); i++)
            {
                //CHECK Here For Filter
                // ****\\\\\\ CHECK HERE \\\\\\\\\\***
                if(filterList.get(i).getTr_name().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredPlayers.add(filterList.get(i));
                }
            }

            results.count=filteredPlayers.size();
            results.values=filteredPlayers;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;

        }


        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        viewTrackingAdapter.trackings= (ArrayList<Tracking>) results.values;

        //REFRESH
        viewTrackingAdapter.notifyDataSetChanged();
    }
}
