package co.edu.udea.bibliotecapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.edu.udea.bibliotecapp.R;

/**
 * Created by cristian on 30/05/2016.
 */
public class TabFavorites extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_search, container, false);
        return v;
    }
}
