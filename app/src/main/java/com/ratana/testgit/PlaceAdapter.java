package com.ratana.testgit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.swing.text.html.ImageView;

class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.EventViewHolder>{

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder{

        private ImageView txtimage;
        private TextView txtTitle;
        private TextView txtShortDescription;
        private TextView txtLongDescription;

        public EventViewHolder(View itemView) {
            super(itemView);
        }
    }
}
