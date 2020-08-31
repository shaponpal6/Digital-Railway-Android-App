package com.shopnobuilder.digitalrailway.tracking.viewTracking;

/**
 * Created by DELL on 4/19/2018.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;

import com.shopnobuilder.digitalrailway.R;
import com.shopnobuilder.digitalrailway.TrainViewActivity;
import com.shopnobuilder.digitalrailway.filterTabView.filter.ItemClickListener;
import com.shopnobuilder.digitalrailway.filterTabView.filter.TrainViewHolder;

import java.util.ArrayList;

public class ViewTrackingAdapter extends RecyclerView.Adapter<TrackingViewHolder> implements Filterable {

    Context c;
    ArrayList<Tracking> trackings, filterList;
    TrackingFilter filter;


    public ViewTrackingAdapter(Context ctx, ArrayList<Tracking> trains) {
        this.c = ctx;
        this.trackings = trains;
        this.filterList = trains;
    }


    @Override
    public TrackingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //CONVERT XML TO VIEW ONBJ
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_tracking_card, null);

        //HOLDER
        TrackingViewHolder holder = new TrackingViewHolder(v);
//        TrainViewHolder holder = new TrainViewHolder(v);
        return holder;
    }

    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(final TrackingViewHolder holder, int position) {

        //BIND DATA
        //holder.posTxt.setText(trains.get(position).getWeeklyOffDay());
        holder.userName.setText(trackings.get(position).getTr_name());
        holder.trainName.setText(trackings.get(position).getTracking_status());
        holder.group.setText(trackings.get(position).getTr_form());
        //holder.trainName.setText(trackings.get(position).getWeeklyOffDay());
        //holder.img.setImageResource(players.get(position).getTrainNo());

        //holder.online.setTag(123, trains.get(position).getTrainNo());
        holder.b.setTag(R.id.track, trackings.get(position).getTracking_id());


        // set Animation
        setAnimation(holder.itemView, position);


        //IMPLEMENT CLICK LISTENET
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                //Snackbar.make(v, trains.get(pos).getStartingStation(), Snackbar.LENGTH_SHORT).show();

                // Trian Obj
                Tracking tr = trackings.get(pos);
                Intent intent = new Intent(v.getContext(), TrainViewActivity.class);
                intent.putExtra("train", tr);
                c.startActivity(intent);
            }
        });

    }

    //GET TOTAL NUM OF PLAYERS
    @Override
    public int getItemCount() {
        return trackings.size();
    }

    //RETURN FILTER OBJ
    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new TrackingFilter(filterList, this);
        }

        return filter;
    }

    // Animation
    private int lastPosition = -1;
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        Animation animation = AnimationUtils.loadAnimation(c, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        viewToAnimate.startAnimation(animation);
    }
}


