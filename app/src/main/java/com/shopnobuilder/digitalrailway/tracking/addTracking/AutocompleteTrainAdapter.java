package com.shopnobuilder.digitalrailway.tracking.addTracking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopnobuilder.digitalrailway.R;
import com.shopnobuilder.digitalrailway.include.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class AutocompleteTrainAdapter extends ArrayAdapter<AutocompleteTrains> implements View.OnClickListener {
    private List<AutocompleteTrains> countryListFull;
    Context mContext;
    private int lastPosition = -1;

    @Override
    public void onClick(View view) {
        int position=(Integer) view.getTag();
        Object object= getItem(position);
        AutocompleteTrains autocompleteTrains=(AutocompleteTrains)object;

        TextView from = (TextView)view.findViewById(R.id.tracking_tr_from);
        TextView to = (TextView)view.findViewById(R.id.tracking_tr_to);
        from.setText(autocompleteTrains.getTrainFrom());
        to.setText(autocompleteTrains.getTrainTo());
        switch (view.getId())
        {
            case R.id.text_view_name:
                Snackbar.make(view, "Release date " +autocompleteTrains.getTrainFrom() + " --- TO--- "+  autocompleteTrains.getTrainTo(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    // View lookup cache
    private static class ViewHolder {
        TextView tr_name;
        TextView tr_from;
        TextView tr_to;
    }

    public AutocompleteTrainAdapter(@NonNull Context context, @NonNull List<AutocompleteTrains> countryList) {
        super(context, 0, countryList);
        countryListFull = new ArrayList<>(countryList);
        this.mContext=context;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get Data at position
        AutocompleteTrains autocompleteTrains = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.autocomplete_find_train, parent, false);
            viewHolder.tr_name = (TextView) convertView.findViewById(R.id.text_view_name);
            viewHolder.tr_from = (TextView) convertView.findViewById(R.id.ac_tr_from);
            viewHolder.tr_to = (TextView) convertView.findViewById(R.id.ac_tr_to);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.tr_name.setText(autocompleteTrains.getTrainName());
        viewHolder.tr_from.setText(autocompleteTrains.getTrainFrom());
        viewHolder.tr_to.setText(autocompleteTrains.getTrainTo());
        // Return the completed view to render on screen






        //-------------------------- ok ------------
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.autocomplete_find_train, parent, false
//            );
//        }
//
//        TextView ac_tr_name = convertView.findViewById(R.id.text_view_name);
//        TextView ac_tr_from = convertView.findViewById(R.id.ac_tr_from);
//        TextView ac_tr_to = convertView.findViewById(R.id.ac_tr_to);
//        if (autocompleteTrains != null) {
//            ac_tr_name.setText(autocompleteTrains.getTrainName());
//            ac_tr_from.setText(autocompleteTrains.getTrainFrom());
//            ac_tr_to.setText(autocompleteTrains.getTrainTo());
//        }
        //-------------------ok -------

        return convertView;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<AutocompleteTrains> suggestions = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                suggestions.addAll(countryListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (AutocompleteTrains item : countryListFull) {
                    if (item.getTrainName().toLowerCase().contains(filterPattern)) {
                        suggestions.add(item);
                    }
                }
            }

            results.values = suggestions;
            results.count = suggestions.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((AutocompleteTrains) resultValue).getTrainName();
        }
    };
}
