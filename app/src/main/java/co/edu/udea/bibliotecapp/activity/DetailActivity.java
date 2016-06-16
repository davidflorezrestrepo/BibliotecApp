package co.edu.udea.bibliotecapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.edu.udea.bibliotecapp.R;
import co.edu.udea.bibliotecapp.adapter.ExpandableListAdapter;
import co.edu.udea.bibliotecapp.data.Autor;
import co.edu.udea.bibliotecapp.data.Disponibilidad;
import co.edu.udea.bibliotecapp.data.LibroConDetalle;
import co.edu.udea.bibliotecapp.soap.DetalleWS;


public class DetailActivity extends AppCompatActivity {

    private ImageView imageBook;
    private TextView title;
    private TextView author;
    private TextView isbn;
    //private TextView availability;

    private LibroConDetalle libro = new LibroConDetalle();
    private Autor autor = new Autor();
    private Disponibilidad disponib = new Disponibilidad();

    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_view);

        imageBook = (ImageView) findViewById(R.id.imageViewBook);
        title = (TextView) findViewById(R.id.textTitleDesc);
        author = (TextView) findViewById(R.id.textViewAuthorDesc);
        isbn = (TextView) findViewById(R.id.textViewISBNDesc);
        //availability = (TextView) findViewById(R.id.textViewAvaliaDesc);
        expListView = (ExpandableListView) findViewById(R.id.listAvailabExp);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("BOOK_IMAGE");
            value = extras.getString("TITLENO");
            searchDetail(value);
        }
/*
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        */
    }

    private void searchDetail(String titleNo) {
        DetalleWS detalleWS = new DetalleWS(titleNo, title, author, isbn, expListView,this);
        detalleWS.execute();
    }
}
