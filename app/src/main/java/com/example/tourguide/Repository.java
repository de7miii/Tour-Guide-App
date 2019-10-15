package com.example.tourguide;

import android.content.Context;

import java.util.ArrayList;

public class Repository {

    private static volatile Repository sRepository;

    private Context mContext;
    private ArrayList<Location> mMarketsList;
    private ArrayList<Location> mHistoricalSitesList;
    private ArrayList<Location> mMuseumsList;
    private ArrayList<Location> mRuinsList;
    private ArrayList<Location> mRestaurantList;

    private Repository(Context context) {
        mContext = context;
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
        mMarketsList.add(new Location(mContext.getString(R.string.omdurman_souq_name),
                mContext.getString(R.string.omdurman_souq_desc), 0));
        mMarketsList.add(new Location(mContext.getString(R.string.kassala_souq_name),
                mContext.getString(R.string.kassala_souq_desc), 0));
        mMarketsList.add(new Location(mContext.getString(R.string.fish_market_name),
                mContext.getString(R.string.fish_market_desc), 0));
        mMarketsList.add(new Location(mContext.getString(R.string.central_market_name),
                mContext.getString(R.string.central_market_desc), 0));
        mMarketsList.add(new Location(mContext.getString(R.string.camel_market_name),
                mContext.getString(R.string.camel_market_desc), 0));

        //init historical sites list with locations.
        mHistoricalSitesList.add(new Location(mContext.getString(R.string.soleb_temple_name),
                mContext.getString(R.string.soleb_tmeple_desc), 0));
        mHistoricalSitesList.add(new Location(mContext.getString(R.string.maroe_pyramids_name),
                mContext.getString(R.string.maroe_pyramids_desc), 0));
        mHistoricalSitesList.add(new Location(mContext.getString(R.string.barkal_mountain_name),
                mContext.getString(R.string.barkal_mountain_desc), 0));
        mHistoricalSitesList.add(new Location(mContext.getString(R.string.musawwarat_name),
                mContext.getString(R.string.musawwarat_desc), 0));
        mHistoricalSitesList.add(new Location(mContext.getString(R.string.sai_island_name),
                mContext.getString(R.string.sai_island_desc), 0));

        //init museums list with locations.
        mMuseumsList.add(new Location(mContext.getString(R.string.national_museum_name),
                mContext.getString(R.string.national_museum_desc), 0));
        mMuseumsList.add(new Location(mContext.getString(R.string.kerma_museum_name),
                mContext.getString(R.string.kerma_museum_desc), 0));
        mMuseumsList.add(new Location(mContext.getString(R.string.ethnographic_museum_name),
                mContext.getString(R.string.ethnographic_museum_desc), 0));
        mMuseumsList.add(new Location(mContext.getString(R.string.karima_museum_name),
                mContext.getString(R.string.karima_museum_desc), 0));
        mMuseumsList.add(new Location(mContext.getString(R.string.republican_palace_museum_name),
                mContext.getString(R.string.republican_palace_museum_desc), 0));

        //init ruins list with locations.
        mRuinsList.add(new Location(mContext.getString(R.string.kurru_name),
                mContext.getString(R.string.kurru_desc), 0));
        mRuinsList.add(new Location(mContext.getString(R.string.old_dongola_name),
                mContext.getString(R.string.old_dongola_desc), 0));
        mRuinsList.add(new Location(mContext.getString(R.string.suakin_island_name),
                mContext.getString(R.string.suakin_island_desc), 0));

        //init restaurants list with locations.
        mRestaurantList.add(new Location(mContext.getString(R.string.housh_name),
                mContext.getString(R.string.housh_desc), 0));
        mRestaurantList.add(new Location(mContext.getString(R.string.assaha_village_name),
                mContext.getString(R.string.assaha_village_desc), 0));
        mRestaurantList.add(new Location(mContext.getString(R.string.fish_wok_name),
                mContext.getString(R.string.fish_wok_desc), 0));
        mRestaurantList.add(new Location(mContext.getString(R.string.amwaj_name),
                mContext.getString(R.string.amwaj_desc), 0));
        mRestaurantList.add(new Location(mContext.getString(R.string.laziz_name),
                mContext.getString(R.string.laziz_desc), 0));
    }
}
