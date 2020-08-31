package com.shopnobuilder.digitalrailway.filterTabView.filter.byTrain;

/**
 * Created by SHOPNOBUILDER on 2/24/2018.
 */

import android.widget.Filter;

import com.shopnobuilder.digitalrailway.filterTabView.filter.MyAdapter;
import com.shopnobuilder.digitalrailway.filterTabView.filter.Train;

import java.util.ArrayList;

public class ByTrainFilter extends Filter{

    FilterByTrainAdapter byTrainAdapter;
    ArrayList<Train> filterList;


    public ByTrainFilter(ArrayList<Train> filterList, FilterByTrainAdapter adapter)
    {
        this.byTrainAdapter = adapter;
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
            ArrayList<Train> filteredPlayers=new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getTrainName().toUpperCase().contains(constraint))
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

        byTrainAdapter.trains= (ArrayList<Train>) results.values;

        //REFRESH
        byTrainAdapter.notifyDataSetChanged();
    }
}
