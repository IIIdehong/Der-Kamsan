package com.ratana.testgit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.EventViewHolder>{

    public Places[] data;
    public  void setData(Places[] data){
        this.data =data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view =layoutInflater.inflate(R.layout.fragment_place_item,viewGroup,false);
        EventViewHolder eventViewHolder = new EventViewHolder(view);
        return eventViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
//        Places places = data[position];
//        holder.txtTitle.setText(places.getTitle());


    }

    @Override
    public int getItemCount() {
        return  10;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder{

        private ImageView txtimage;
        private TextView txtTitle;
        private TextView txtShortDescription;
        private TextView txtLongDescription;

        public EventViewHolder(View itemView) {
            super(itemView);
            txtimage = itemView.findViewById(R.id.img_place);
            txtTitle = itemView.findViewById(R.id.txt_title_of_trip);
            txtShortDescription = itemView.findViewById(R.id.txt_short_description);
            txtLongDescription = itemView.findViewById(R.id.txt_long_description);

        }


    }
}
