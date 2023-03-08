package br.com.webflix.webflix.model;

public class Filme {
    private int id;
    private String titulo;
    private String genero;
    private int duracao;
    private String sinopse;
    private String imagem;
    private int likes;

    public Filme(int id, String titulo, String genero, int duracao, String sinopse, String imagem, int likes) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.sinopse = sinopse;
        this.imagem = imagem;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Filme [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", duracao=" + duracao + ", sinopse="
                + sinopse + ", imagem=" + imagem + ", likes=" + likes + "]";
    }
}
