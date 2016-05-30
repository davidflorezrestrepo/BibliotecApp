package co.edu.udea.bibliotecapp.data;

import java.util.List;

public class LibroConDetalle {
    private String titleno;
    private String titulo;
    private String tipo_publicacion;
    private List<Autor> autores;
    private String publicacion;
    private String descripcion_fisica;
    private String idioma;
    private String isbn;
    private String nota;
    private List<Disponibilidad> disponibilidad;

    public String getTitleno() {
        return titleno;
    }

    public void setTitleno(String titleno) {
        this.titleno = titleno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo_publicacion() {
        return tipo_publicacion;
    }

    public void setTipo_publicacion(String tipo_publicacion) {
        this.tipo_publicacion = tipo_publicacion;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public String getDescripcion_fisica() {
        return descripcion_fisica;
    }

    public void setDescripcion_fisica(String descripcion_fisica) {
        this.descripcion_fisica = descripcion_fisica;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public List<Disponibilidad> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(List<Disponibilidad> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
