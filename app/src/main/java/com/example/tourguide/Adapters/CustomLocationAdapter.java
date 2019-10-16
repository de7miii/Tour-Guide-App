package com.example.tourguide.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourguide.Location;
import com.example.tourguide.R;

import java.util.ArrayList;


public class CustomLocationAdapter extends RecyclerView.Adapter<CustomLocationAdapter.CustomLocationViewHolder> {

    private Context mContext;

    private ArrayList<Location> mLocationsList;

    public CustomLocationAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public CustomLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout, parent, false);
        return new CustomLocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomLocationViewHolder holder, int position) {
        Location currentLocation = mLocationsList.get(position);
        holder.bind(currentLocation);
    }

    @Override
    public int getItemCount() {
        return mLocationsList != null? mLocationsList.size(): 0;
    }

    class CustomLocationViewHolder extends RecyclerView.ViewHolder {
        ImageView locationImage;
        TextView locationName;
        TextView locationDesc;

        CustomLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            locationImage = itemView.findViewById(R.id.img_location);
            locationName = itemView.findViewById(R.id.text_location_name);
            locationDesc = itemView.findViewById(R.id.text_location_desc);
        }

        void bind(Location location) {
            if (location.getImageResourceId() != 0) {
                locationImage.setImageResource(location.getImageResourceId());
            } else {
                locationImage.setVisibility(View.GONE);
            }
            locationName.setText(location.getName());
            locationDesc.setText(location.getDescription());
        }
    }

    public void updateLocationsList(ArrayList<Location> locations) {
        mLocationsList = locations;
    }
    public interface OnItemClickListener{
        public void onItemClick(int position);
    }
}
