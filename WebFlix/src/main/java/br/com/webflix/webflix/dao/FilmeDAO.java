package br.com.webflix.webflix.dao;
import br.com.webflix.webflix.model.Filme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FilmeDAO {
    private Map<Integer, Filme> filmes;

    public FilmeDAO() {
        filmes = new HashMap<Integer, Filme>();
    }


    public void adicionarFilme(Filme filme) {
        int id = filmes.size() + 1;
        filme.setId(id);
        filmes.put(id, filme);
    }

    public void editarFilme(Filme filme) {
        filmes.put(filme.getId(), filme);
    }

    public void removerFilme(int id) {
        filmes.remove(id);
    }

    public String listarFilmes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Listar filmes\n");
        sb.append("----------------\n");

        List<Filme> filmes = new ArrayList<>(getFilmes().values());
        for (Filme filme : filmes) {
            sb.append("ID: " + filme.getId() + "\n");
            sb.append("Título: " + filme.getTitulo() + "\n");
            sb.append("Gênero: " + filme.getGenero() + "\n");
            sb.append("Duração: " + filme.getDuracao() + " minutos\n");
            sb.append("Sinopse: " + filme.getSinopse() + "\n");
            sb.append("----------------\n");
        }

        return sb.toString();
    }

    public Filme buscarFilmePorId(int id) {
        return filmes.get(id);
    }

    public Map<Integer, Filme> getFilmes() {
        return filmes;
    }
}
