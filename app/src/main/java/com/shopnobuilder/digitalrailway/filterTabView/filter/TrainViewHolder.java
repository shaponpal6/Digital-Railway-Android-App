package com.shopnobuilder.digitalrailway.filterTabView.filter;

/**
 * Created by SHOPNOBUILDER on 2/24/2018.
 */
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopnobuilder.digitalrailway.R;

public class TrainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //OUR VIEWS
    Activity mActivity;
    ImageView img;
    public TextView trainNo, nameTxt, posTxt, trainName, track, online;
    public Button btn2, b;

    ItemClickListener itemClickListener;


    public TrainViewHolder(View itemView) {
        super(itemView);

        //this.img= (ImageView) itemView.findViewById(R.id.playerImage);
        this.trainNo = (TextView) itemView.findViewById(R.id.trainName);
        this.nameTxt= (TextView) itemView.findViewById(R.id.trName);
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
