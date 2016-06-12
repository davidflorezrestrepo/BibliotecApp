package co.edu.udea.bibliotecapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

import co.edu.udea.bibliotecapp.R;
import co.edu.udea.bibliotecapp.adapter.AdapterSearchResults;
import co.edu.udea.bibliotecapp.data.Libro;
import co.edu.udea.bibliotecapp.soap.BusquedaWS;

/**
 * Created by cristian on 30/05/2016.
 */
public class TabSearch extends Fragment {

    private RecyclerView recyclerListBooks;
    private AdapterSearchResults adapterSearchResults;
    public static String QUERY_STRING = "QUERY";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_search, container, false);

        recyclerListBooks = (RecyclerView) v.findViewById(R.id.recyclerListBooks);
        recyclerListBooks.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterSearchResults = new AdapterSearchResults(getActivity());
        recyclerListBooks.setAdapter(adapterSearchResults);
        //searchBooks("Cien años de soledad");

        return v;
    }

    public void searchBooks(String query) {
        BusquedaWS busquedaWS = new BusquedaWS(query, adapterSearchResults);
        busquedaWS.execute();

    }
}
