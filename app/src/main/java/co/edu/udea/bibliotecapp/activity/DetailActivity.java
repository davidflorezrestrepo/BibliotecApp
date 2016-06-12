package co.edu.udea.bibliotecapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.bibliotecapp.R;
import co.edu.udea.bibliotecapp.data.Autor;
import co.edu.udea.bibliotecapp.data.Disponibilidad;
import co.edu.udea.bibliotecapp.data.LibroConDetalle;

public class DetailActivity extends AppCompatActivity {

    ImageView imageBook;
    TextView title;
    TextView author;
    TextView isbn;
    //TextView notes;
    TextView availability;

    LibroConDetalle libro = new LibroConDetalle();
    Autor autor = new Autor();
    Disponibilidad disponib = new Disponibilidad();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_view);

        imageBook = (ImageView) findViewById(R.id.imageViewBook);

        title = (TextView) findViewById(R.id.textTitleDesc);
        libro.setTitulo("Cien años de soledad");
        title.setText(libro.getTitulo());

        author = (TextView)findViewById(R.id.textViewAuthorDesc);
        autor.setAutor_id("1000");
        autor.setAutor_nombre("García Márquez, Gabriel (Autor)");
        List<Autor> autores = new ArrayList<>();
        autores.add(autor);
        libro.setAutores(autores);
        author.setText(autores.get(0).getAutor_nombre());

        isbn = (TextView)findViewById(R.id.textViewISBNDesc);
        libro.setIsbn("9580439524");
        isbn.setText(libro.getIsbn());

        //notes = (TextView)findViewById(R.id.textViewNotesDesc);
        //libro.setNota("RESUMEN : Publicada en 1967, Cien años de soledad relata el origen, la evolución y la ruina de Macondo, una aldea imaginaria que había hecho su aparición en las tres novelas cortas que su autor había publicado con anterioridad. Estructurada como una saga familiar, la historia de la estirpe de los Buendía se extiende por más de cien años, y cuenta con seis generaciones para hacerlo.  La crónica de los Buendía, que acumula una gran cantidad de episodios fantásticos, divertidos y violentos, y la de Macondo, desde su fundación hasta su fin, representan el ciclo completo de una cultura y un mundo. El clima de violencia en el que se desarrollan sus personajes es el que marca la soledad que los caracteriza, provocada más por las condiciones de vida que por las angustias existenciales del individuo.  El realismo mágico (también llamado lo real maravilloso) hace posible que la objetividad de la vida material se vea matizada por la subjetividad de la fantasía. Lo insólito (situaciones parecidas a los cuentos de hadas, levitaciones, premoniciones, la extrasensorialidad presente) da lugar a una atmósfera mágica que atenúa la miseria social y humana, de forma que lo mágico subraya la dureza y desajuste de la realidad, la violencia que domina la vida cotidiana.");
        //notes.setText(libro.getNota());

        availability = (TextView)findViewById(R.id.textViewAvaliaDesc);
        disponib.setBarcode("61000001557277");
        disponib.setCategoria("30 Días");
        disponib.setEstado("En Préstamo");
        disponib.setEstante("Colección de Literatura Latinoamericana. Piso 3");
        disponib.setLocalizacion("Biblioteca Carlos Gaviria Diaz");
        disponib.setSignatura("C863/G216ci");
        List<Disponibilidad> disponibilidads = new ArrayList<>();
        disponibilidads.add(disponib);
        disponib = new Disponibilidad();
        disponib.setBarcode("0550649");
        disponib.setCategoria("30 Días");
        disponib.setEstado("En Préstamo");
        disponib.setEstante("Colección de Literatura. Piso 3");
        disponib.setLocalizacion("Biblioteca Carlos Gaviria Diaz");
        disponib.setSignatura("C863/G216ci 2002 e3");
        disponibilidads.add(disponib);
        disponib = new Disponibilidad();
        disponib.setBarcode("61000004918609");
        disponib.setCategoria("30 Días");
        disponib.setEstado("Retraso Largo");
        disponib.setEstante("Colección de Literatura. Piso 3");
        disponib.setLocalizacion("Biblioteca Carlos Gaviria Diaz");
        disponib.setSignatura("C863/G216ci 2003");
        disponibilidads.add(disponib);
        disponib = new Disponibilidad();
        disponib.setBarcode("0577198");
        disponib.setCategoria("30 Días");
        disponib.setEstado("Vencido");
        disponib.setEstante("Colección de Literatura. Piso 3");
        disponib.setLocalizacion("Biblioteca Carlos Gaviria Diaz");
        disponib.setSignatura("C863/G216ci 2002 e2");
        disponibilidads.add(disponib);
        disponib = new Disponibilidad();
        disponib.setBarcode("61000004149836");
        disponib.setCategoria("30 Días");
        disponib.setEstado("En Préstamo");
        disponib.setEstante("Colección de Literatura. Piso 3");
        disponib.setLocalizacion("Biblioteca Carlos Gaviria Diaz");
        disponib.setSignatura("C863/G216ci 2002");
        disponibilidads.add(disponib);
        disponib = new Disponibilidad();
        libro.setDisponibilidad(disponibilidads);
        availability.setText("");
        for (int i=0; i<disponibilidads.size();i++){
            availability.append("\nLocalización: "+ disponibilidads.get(i).getLocalizacion()+ "\nEstante: "+
                    disponibilidads.get(i).getEstante()+"\nSignatura: "+disponibilidads.get(i).getSignatura()+
                    "\nEstado: "+disponibilidads.get(i).getEstado()+"\nCategoria: "+disponibilidads.get(i).getCategoria()+"\n");
            Log.d("Disponibilidad "+i,"\nLocalización: " + disponibilidads.get(i).getLocalizacion() + "\nEstante: " +
                    disponibilidads.get(i).getEstante() + "\nSignatura: " + disponibilidads.get(i).getSignatura() +
                    "\nEstado: " + disponibilidads.get(i).getEstado() + "\nCategoria: " + disponibilidads.get(i).getCategoria() + "\n");
        }
    }
}
