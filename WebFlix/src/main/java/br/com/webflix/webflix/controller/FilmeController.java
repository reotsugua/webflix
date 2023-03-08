package br.com.webflix.webflix.controller;
import br.com.webflix.webflix.model.Filme;
import br.com.webflix.webflix.dao.FilmeDAO;

import java.util.List;
import java.util.Map;


public class FilmeController {
    private FilmeDAO dao;
    private Map<Integer, Filme> filmes;

    public FilmeController() {
        dao = new FilmeDAO();
        filmes = dao.getFilmes();
    }

    public void adicionarFilme(String titulo, String genero, int duracao, String sinopse, String imagem) {
        int id = filmes.size() + 1;
        Filme filme = new Filme(id, titulo, genero, duracao, sinopse, imagem, 0);
        dao.adicionarFilme(filme);
    }

    public void editarFilme(int id, String titulo, String genero, int duracao, String sinopse, String imagem) {
        Filme filme = dao.buscarFilmePorId(id);
        if (filme != null) {
            filme.setTitulo(titulo);
            filme.setGenero(genero);
            filme.setDuracao(duracao);
            filme.setSinopse(sinopse);
            filme.setImagem(imagem);
            dao.editarFilme(filme);
            atualizarFilmes();
        }
    }

    public void removerFilme(int id) {
        dao.removerFilme(id);
        atualizarFilmes();
    }

    public String listarFilmes() {
        return dao.listarFilmes();
    }

    public Filme buscarFilmePorId(int id) {
        return dao.buscarFilmePorId(id);
    }

    private void atualizarFilmes() {
        filmes = dao.getFilmes();
    }
}
