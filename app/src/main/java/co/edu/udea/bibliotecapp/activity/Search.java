package co.edu.udea.bibliotecapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    }

    public void onClickBuscar(View arg0) {
        finish();
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        String query = String.valueOf(editTextPalabraClave.getText());
        data.putExtra("queryBook", query);
        setResult(RESULT_OK, data);
        super.finish();
    }
}
