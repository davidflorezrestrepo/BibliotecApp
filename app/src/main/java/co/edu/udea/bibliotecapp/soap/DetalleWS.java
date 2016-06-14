package co.edu.udea.bibliotecapp.soap;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

import co.edu.udea.bibliotecapp.data.Autor;
import co.edu.udea.bibliotecapp.data.Disponibilidad;
import co.edu.udea.bibliotecapp.data.Libro;
import co.edu.udea.bibliotecapp.data.LibroConDetalle;

public class DetalleWS extends AsyncTask<String, Void, Void> {

    private final String NAMESPACE = "http://aplicacionesbiblioteca.udea.edu.co/OPAC/servicios/";
    private final String URL = "http://aplicacionesbiblioteca.udea.edu.co/OPAC/servicios/olib.php";
    private final String SOAP_ACTION = "http://aplicacionesbiblioteca.udea.edu.co/OPAC/servicios/APP_DetalleTitulo";
    private final String METHOD_NAME = "APP_DetalleTitulo";
    private final String APP_KEY = "UGT15rr80App4@";

    private String titleno;
    private List<LibroConDetalle> librosConDetalle;
    private LibroConDetalle libroConDetalle;
    private TextView title;
    TextView author;
    TextView isbn;
    TextView avai;

    public DetalleWS(String titleno, TextView title, TextView author, TextView isbn, TextView avai) {
        this.titleno = titleno;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.avai = avai;
    }

    @Override
    protected Void doInBackground(String... params) {
        buscarDetalle(this.titleno);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        Autor autor;
        Disponibilidad disponibilidad;
        String disp = "";
        if (librosConDetalle != null && !librosConDetalle.isEmpty()) {
            libroConDetalle = librosConDetalle.get(0);
            title.setText(libroConDetalle.getTitulo());
            autor = libroConDetalle.getAutores().get(0);
            author.setText(autor.getAutor_nombre());
            isbn.setText(libroConDetalle.getIsbn());
            for (int i = 0; i < libroConDetalle.getDisponibilidad().size(); i++) {
                disponibilidad = libroConDetalle.getDisponibilidad().get(i);
                disp += "LUGAR " + (i+1) + "\n-Lugar: " + disponibilidad.getLocalizacion() + "\n-Estante: " + disponibilidad.getEstante()
                        + "\n-Signatura: " + disponibilidad.getSignatura() + "\n-Estado: " + disponibilidad.getEstado() +
                        "\nCategoria: " + disponibilidad.getCategoria() + "\n";
            }
            avai.setText(disp);

        }
    }

    public void buscarDetalle(String titleno) {

        if (titleno == null || titleno.isEmpty()) {
            return;
        }

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        PropertyInfo busquedaInfo = new PropertyInfo();
        busquedaInfo.setName("titleno");
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
            String respuesta = ((SoapObject) response.getProperty(0)).getProperty("value").toString();
            librosConDetalle = new Gson().fromJson(respuesta, new TypeToken<List<LibroConDetalle>>() {
            }.getType());
            libroConDetalle = librosConDetalle.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
