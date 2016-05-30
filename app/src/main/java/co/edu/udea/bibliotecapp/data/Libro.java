package co.edu.udea.bibliotecapp.data;

public class Libro {

    private String titleno;
    private String titulo;
    private String autores;
    private String isbn;
    private String image_url;
    private String ejemplares;

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

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(String ejemplares) {
        this.ejemplares = ejemplares;
    }    
}
