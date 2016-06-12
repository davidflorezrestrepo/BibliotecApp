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

    private CharSequence Titles[];
    private int NumbOfTabs;
    private TabSearch tab1;
    private TabFavorites tab2;

    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            tab1 = new TabSearch();
            return tab1;
        } else {
            tab2 = new TabFavorites();
            return tab2;
        }
    }

    public void setQuery(String query){
        tab1.searchBooks(query);
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
