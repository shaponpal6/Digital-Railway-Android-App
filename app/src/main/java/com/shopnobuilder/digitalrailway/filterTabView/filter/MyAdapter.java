package com.shopnobuilder.digitalrailway.filterTabView.filter;

/**
 * Created by SHOPNOBUILDER on 2/24/2018.
 */

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import com.shopnobuilder.digitalrailway.R;

public class MyAdapter extends RecyclerView.Adapter<TrainViewHolder> implements Filterable{

    Context c;
    ArrayList<Train> trains, filterList;
    CustomFilter filter;


    public MyAdapter(Context ctx, ArrayList<Train> trains)
    {
        this.c=ctx;
        this.trains = trains;
        this.filterList = trains;
    }


    @Override
    public TrainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //CONVERT XML TO VIEW ONBJ
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.find_train_card_view,null);

        //HOLDER
        TrainViewHolder holder=new TrainViewHolder(v);
        return holder;
    }

    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(TrainViewHolder holder, int position) {

        //BIND DATA
        holder.posTxt.setText(trains.get(position).getWeeklyOffDay());
        holder.nameTxt.setText(trains.get(position).getTrainName());
        //holder.img.setImageResource(players.get(position).getTrainNo());


        //IMPLEMENT CLICK LISTENET
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v,trains.get(pos).getTrainName(),Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    //GET TOTAL NUM OF PLAYERS
    @Override
    public int getItemCount() {
        return trains.size();
    }

    //RETURN FILTER OBJ
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }

        return filter;
    }
}

