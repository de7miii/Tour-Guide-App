package com.example.tourguide.Repository;

import android.content.Context;

import com.example.tourguide.Model.Location;
import com.example.tourguide.R;

import java.util.ArrayList;

public class Repository {

    private static volatile Repository sRepository;

    private Context mContext;
    private ArrayList<Location> mMarketsList;
    private ArrayList<Location> mHistoricalSitesList;
    private ArrayList<Location> mMuseumsList;
    private ArrayList<Location> mRuinsList;

    private Repository(Context context) {
        mContext = context.getApplicationContext();
        if (sRepository != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        initData();
    }

    public static Repository getInstance(Context context) {
        if (sRepository == null) {
            sRepository = new Repository(context);
        }
        return sRepository;
    }

    private void initData() {

        //init markets list with locations.
        mMarketsList = new ArrayList<>();
        mMarketsList.add(new Location(mContext.getString(R.string.omdurman_souq_name),
                mContext.getString(R.string.omdurman_souq_desc), R.drawable.omdurman_market));
        mMarketsList.add(new Location(mContext.getString(R.string.kassala_souq_name),
                mContext.getString(R.string.kassala_souq_desc), 0));
        mMarketsList.add(new Location(mContext.getString(R.string.fish_market_name),
                mContext.getString(R.string.fish_market_desc), 0));
        mMarketsList.add(new Location(mContext.getString(R.string.central_market_name),
                mContext.getString(R.string.central_market_desc), 0));
        mMarketsList.add(new Location(mContext.getString(R.string.camel_market_name),
                mContext.getString(R.string.camel_market_desc), R.drawable.camel_market));

        //init historical sites list with locations.
        mHistoricalSitesList = new ArrayList<>();
        mHistoricalSitesList.add(new Location(mContext.getString(R.string.soleb_temple_name),
                mContext.getString(R.string.soleb_tmeple_desc), R.drawable.soleb_temple));
        mHistoricalSitesList.add(new Location(mContext.getString(R.string.maroe_pyramids_name),
                mContext.getString(R.string.maroe_pyramids_desc), R.drawable.pyramids));
        mHistoricalSitesList.add(new Location(mContext.getString(R.string.barkal_mountain_name),
                mContext.getString(R.string.barkal_mountain_desc), R.drawable.gebel_barkal));
        mHistoricalSitesList.add(new Location(mContext.getString(R.string.musawwarat_name),
                mContext.getString(R.string.musawwarat_desc), R.drawable.musawarat_es_suffra));
        mHistoricalSitesList.add(new Location(mContext.getString(R.string.sai_island_name),
                mContext.getString(R.string.sai_island_desc), R.drawable.sai_island));

        //init museums list with locations.
        mMuseumsList = new ArrayList<>();
        mMuseumsList.add(new Location(mContext.getString(R.string.national_museum_name),
                mContext.getString(R.string.national_museum_desc), R.drawable.national_museum));
        mMuseumsList.add(new Location(mContext.getString(R.string.kerma_museum_name),
                mContext.getString(R.string.kerma_museum_desc), R.drawable.kerma_museum));
        mMuseumsList.add(new Location(mContext.getString(R.string.ethnographic_museum_name),
                mContext.getString(R.string.ethnographic_museum_desc), 0));
        mMuseumsList.add(new Location(mContext.getString(R.string.karima_museum_name),
                mContext.getString(R.string.karima_museum_desc), 0));
        mMuseumsList.add(new Location(mContext.getString(R.string.republican_palace_museum_name),
                mContext.getString(R.string.republican_palace_museum_desc), 0));

        //init ruins list with locations.
        mRuinsList = new ArrayList<>();
        mRuinsList.add(new Location(mContext.getString(R.string.kurru_name),
                mContext.getString(R.string.kurru_desc), R.drawable.el_kurru));
        mRuinsList.add(new Location(mContext.getString(R.string.old_dongola_name),
                mContext.getString(R.string.old_dongola_desc), R.drawable.old_dongola));
        mRuinsList.add(new Location(mContext.getString(R.string.suakin_island_name),
                mContext.getString(R.string.suakin_island_desc), R.drawable.suakin_island));

    }

    public ArrayList<Location> getMarketsList() {
        return mMarketsList;
    }

    public ArrayList<Location> getHistoricalSitesList() {
        return mHistoricalSitesList;
    }

    public ArrayList<Location> getMuseumsList() {
        return mMuseumsList;
    }

    public ArrayList<Location> getRuinsList() {
        return mRuinsList;
    }
}
