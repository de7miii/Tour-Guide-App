package com.example.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourguide.Adapters.CustomLocationAdapter;
import com.example.tourguide.Model.Location;
import com.example.tourguide.Repository.Repository;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarketsFragment extends Fragment implements CustomLocationAdapter.OnItemClickListener {


    @BindView(R.id.rv_markets)
    RecyclerView mRecyclerView;

    private Repository mRepository;

    public MarketsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository = Repository.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_markets, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CustomLocationAdapter locationAdapter = new CustomLocationAdapter(getContext(), this);
        locationAdapter.updateLocationsList(mRepository.getMarketsList());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(locationAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Location currentLocation = mRepository.getMarketsList().get(position);
        Bundle locationInfoBundle = new Bundle();
        locationInfoBundle.putInt(getString(R.string.image_key), currentLocation.getImageResourceId());
        locationInfoBundle.putString(getString(R.string.name_key), currentLocation.getName());
        locationInfoBundle.putString(getString(R.string.desc_key), currentLocation.getDescription());
        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtras(locationInfoBundle);
        startActivity(intent);
    }
}
