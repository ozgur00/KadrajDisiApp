package com.example.ozgur.kadrajdisi;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ozgur.kadrajdisi.pages.FavoritesFragment;
import com.example.ozgur.kadrajdisi.pages.PredictionsFragment;
import com.example.ozgur.kadrajdisi.pages.ReviewsFragment;

/**
 * Created by ozgur on 23.02.2018.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUMBER_OF_PAGES = 3;
    private static final int REVIEWS_POSITION = 0;
    private static final int FAVORITES_POSITION = 1;
    private static final int PREDICTIONS_POSITION = 2;

    private Context context;

    public MainPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case REVIEWS_POSITION:
                return ReviewsFragment.newInstance();
            case FAVORITES_POSITION:
                return FavoritesFragment.newInstance();
            case PREDICTIONS_POSITION:
                return PredictionsFragment.newInstance();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return NUMBER_OF_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case REVIEWS_POSITION:
                return context.getString(R.string.reviews);
            case FAVORITES_POSITION:
                return context.getString(R.string.favorites);
            case PREDICTIONS_POSITION:
                return context.getString(R.string.predictions);
            default:
                return null;
        }
    }
}
