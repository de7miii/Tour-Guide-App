package com.example.tourguide.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tourguide.HistoricalSitesFragment;
import com.example.tourguide.MarketsFragment;
import com.example.tourguide.MuseumsFragment;
import com.example.tourguide.R;
import com.example.tourguide.RuinsFragment;

public class LocationPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;

    public LocationPagerAdapter(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);
        mContext = context.getApplicationContext();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MarketsFragment();
        } else if (position == 1) {
            return new HistoricalSitesFragment();
        } else if (position == 2) {
            return new MuseumsFragment();
        } else {
            return new RuinsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.markets_page_title);
        } else if (position == 1) {
            return mContext.getString(R.string.historical_sites_page_title);
        } else if (position == 2) {
            return mContext.getString(R.string.museums_page_title);
        } else {
            return mContext.getString(R.string.ruins_page_title);
        }
    }

}
