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

import java.util.List;

import co.edu.udea.bibliotecapp.data.Libro;
import co.edu.udea.bibliotecapp.data.LibroConDetalle;

public class DetalleWS extends AsyncTask<String, Void, Void> {

    private final String NAMESPACE = "http://aplicacionesbiblioteca.udea.edu.co/OPAC/servicios/";
    private final String URL = "http://aplicacionesbiblioteca.udea.edu.co/OPAC/servicios/olib.php";
    private final String SOAP_ACTION = "http://aplicacionesbiblioteca.udea.edu.co/OPAC/servicios/APP_DetalleTitulo";
    private final String METHOD_NAME = "APP_DetalleTitulo";
    private final String APP_KEY = "UGT15rr80App4@";

    private String titleno;
    private List<Libro> librosConDetalle;

    public DetalleWS(String titleno){
        this.titleno = titleno;
    }

    @Override
    protected Void doInBackground(String... params) {
        buscarDetalle(this.titleno);
        return null;
    }

    public void buscarDetalle(String titleno){
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        PropertyInfo busquedaInfo = new PropertyInfo();
        busquedaInfo.setName("busqueda");
        busquedaInfo.setValue(titleno);
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
            librosConDetalle = new Gson().fromJson(respuesta, new TypeToken<List<LibroConDetalle>>(){}.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
