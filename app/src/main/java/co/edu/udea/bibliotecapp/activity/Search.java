package co.edu.udea.bibliotecapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import co.edu.udea.bibliotecapp.R;
import co.edu.udea.bibliotecapp.data.Libro;
import co.edu.udea.bibliotecapp.soap.BusquedaWS;

public class Search extends AppCompatActivity {

    Button buttonBuscar;
    EditText editTextPalabraClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);

        buttonBuscar = (Button) findViewById(R.id.buttonBuscar);
        editTextPalabraClave = (EditText) findViewById(R.id.palabraClave);

        buttonBuscar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                /*BusquedaWS busquedaWS = new BusquedaWS(editTextPalabraClave.getText().toString(), new ArrayList<Libro>());
                busquedaWS.execute();*/
            }
        });
    }
}
