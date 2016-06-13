package co.edu.udea.bibliotecapp.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import co.edu.udea.bibliotecapp.R;
import co.edu.udea.bibliotecapp.fragment.NavigationDrawerFragment;
import co.edu.udea.bibliotecapp.widget.SlidingTabLayout;
import co.edu.udea.bibliotecapp.widget.ViewPagerAdapter;

public class ActivityMain extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private SlidingTabLayout tabs;
    private CharSequence Titles[] = {"Resultados", "Favoritos"};
    private int Numboftabs = 2;
    private ListView listView;
    private String[] mTitlesFragment;
    private static int REQUEST_CODE = 1;
    NavigationDrawerFragment drawerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        mTitlesFragment = getResources().getStringArray(R.array.titles_array);
        listView = (ListView) findViewById(R.id.left_drawer);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        listView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mTitlesFragment));
        listView.setOnItemClickListener(new DrawerItemClickListener());

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles, Numboftabs);

        pager = (ViewPager) findViewById(R.id.tab_layout_pager);
        pager.setAdapter(adapter);



        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        tabs.setViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments

        Intent intent;
        if(position==0 || position==1){
            intent = new Intent(this,Search.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
        /*
        Fragment fragment = new TabSearch();

        Bundle args = new Bundle();
        args.putInt(TabSearch.QUERY_STRING, position);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.tabs, fragment).commit();*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("queryBook")) {
                String s = data.getExtras().getString("queryBook");
                Log.d("DATOS", "onActivityResult: " + s);
                adapter.setQuery(s);
                drawerFragment.closeDrawer();
            }
        }
    }
}
