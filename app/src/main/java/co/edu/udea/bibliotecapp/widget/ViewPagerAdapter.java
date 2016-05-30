package co.edu.udea.bibliotecapp.widget;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import co.edu.udea.bibliotecapp.R;
import co.edu.udea.bibliotecapp.fragment.TabFavorites;
import co.edu.udea.bibliotecapp.fragment.TabSearch;

/**
 * Created by cristian on 30/05/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[];
    int NumbOfTabs;

    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            TabSearch tab1 = new TabSearch();
            return tab1;
        } else {
            TabFavorites tab2 = new TabFavorites();
            return tab2;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
