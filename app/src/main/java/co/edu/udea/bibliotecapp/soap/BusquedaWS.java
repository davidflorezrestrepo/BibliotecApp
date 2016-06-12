package co.edu.udea.bibliotecapp.soap;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.bibliotecapp.adapter.AdapterSearchResults;
import co.edu.udea.bibliotecapp.data.Libro;

public class BusquedaWS extends AsyncTask<String, Void, Void> {

    private final String NAMESPACE = "http://aplicacionesbiblioteca.udea.edu.co/OPAC/servicios/";
    private final String URL = "http://aplicacionesbiblioteca.udea.edu.co/OPAC/servicios/olib.php";
    private final String SOAP_ACTION = "http://aplicacionesbiblioteca.udea.edu.co/OPAC/servicios/APP_ConsultaCatalogo";
    private final String METHOD_NAME = "APP_ConsultaCatalogo";
    private final String APP_KEY = "UGT15rr80App4@";

    private String busqueda;
    private List<Libro> libros;
    private AdapterSearchResults adapterSearchResults;

    public BusquedaWS(String busqueda, AdapterSearchResults adapterSearchResults){
        this.adapterSearchResults = adapterSearchResults;
        this.busqueda = busqueda;
    }

    @Override
    protected Void doInBackground(String... params) {
        buscarLibro(this.busqueda);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        adapterSearchResults.setBooksList((ArrayList<Libro>) libros);
    }

    public void buscarLibro(String busqueda){
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        PropertyInfo busquedaInfo = new PropertyInfo();
        busquedaInfo.setName("busqueda");
        busquedaInfo.setValue(busqueda);
        busquedaInfo.setType(String.class);

        PropertyInfo appKeyInfo = new PropertyInfo();
        appKeyInfo.setName("appKey");
        appKeyInfo.setValue(APP_KEY);
        appKeyInfo.setType(String.class);

        request.addProperty(busquedaInfo);
        request.addProperty(appKeyInfo);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        androidHttpTransport.debug = true;

        try {
            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapObject response = (SoapObject) envelope.getResponse();
            String respuesta = ((SoapObject)response.getProperty(0)).getProperty("value").toString();
            Log.d("RESULTADO", "buscarLibro: "  + respuesta);
            libros = new Gson().fromJson(respuesta, new TypeToken<List<Libro>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
