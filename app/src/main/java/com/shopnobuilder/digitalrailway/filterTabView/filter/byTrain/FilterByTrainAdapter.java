package com.shopnobuilder.digitalrailway.filterTabView.filter.byTrain;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;

import com.shopnobuilder.digitalrailway.R;
import com.shopnobuilder.digitalrailway.filterTabView.filter.CustomFilter;
import com.shopnobuilder.digitalrailway.filterTabView.filter.ItemClickListener;
import com.shopnobuilder.digitalrailway.filterTabView.filter.Train;
import com.shopnobuilder.digitalrailway.filterTabView.filter.TrainViewHolder;

import java.util.ArrayList;

public class FilterByTrainAdapter extends RecyclerView.Adapter<TrainViewHolder> implements Filterable {

    Context c;
    ArrayList<Train> trains, filterList;
    ByTrainFilter filter;


    public FilterByTrainAdapter(Context ctx, ArrayList<Train> trains) {
        this.c = ctx;
        this.trains = trains;
        this.filterList = trains;
    }


    @Override
    public TrainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //CONVERT XML TO VIEW ONBJ
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_train_card_view, null);

        //HOLDER
        TrainViewHolder holder = new TrainViewHolder(v);
        return holder;
    }

    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(TrainViewHolder holder, int position) {

        //BIND DATA
        //holder.posTxt.setText(trains.get(position).getWeeklyOffDay());
        holder.trainNo.setText(trains.get(position).getTrainNo());
//        holder.nameTxt.setText(trains.get(position).getTrainName());
        holder.trainName.setText(trains.get(position).getTrainName());
        //holder.img.setImageResource(players.get(position).getTrainNo());

        holder.b.setTag(R.id.track, trains.get(position).getTrainNo());

        // set Animation
        setAnimation(holder.itemView, position);

        //IMPLEMENT CLICK LISTENET
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v, trains.get(pos).getTrainName(), Snackbar.LENGTH_SHORT).show();
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
        if (filter == null) {
            filter = new ByTrainFilter(filterList, this);
        }

        return filter;
    }

    // Animation
    private int lastPosition = -1;

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        Animation animation = AnimationUtils.loadAnimation(c, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        viewToAnimate.startAnimation(animation);
    }
}

