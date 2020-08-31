package com.shopnobuilder.digitalrailway.tracking.viewTracking;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopnobuilder.digitalrailway.R;
import com.shopnobuilder.digitalrailway.filterTabView.filter.ItemClickListener;

/**
 * Created by SHOPNOBUILDER on 4/20/2018.
 */

public class TrackingViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    //OUR VIEWS
    Activity mActivity;
    ImageView img;
    public TextView userName, trainNo, nameTxt, group, trainName, track, online;
    public Button btn2, b;

    ItemClickListener itemClickListener;


    public TrackingViewHolder(View itemView) {
        super(itemView);

        //this.img= (ImageView) itemView.findViewById(R.id.playerImage);
        this.userName = (TextView) itemView.findViewById(R.id.user_name);
        this.group = (TextView) itemView.findViewById(R.id.group_name);
        this.trainNo = (TextView) itemView.findViewById(R.id.trainName);
        this.nameTxt= (TextView) itemView.findViewById(R.id.trainName);
        this.trainName= (TextView) itemView.findViewById(R.id.trainName);
        this.track= (TextView) itemView.findViewById(R.id.ticket_price);
        this.online= (TextView) itemView.findViewById(R.id.online);

        // Action Button
        this.btn2 = (Button) itemView.findViewById(R.id.track);
        this.b = itemView.findViewById(R.id.track);
        //b.setTag(R.id.track, "something");

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }
}
