package br.com.seuprojeto.starcodewars.service;

import br.com.seuprojeto.starcodewars.repository.PlanetaDao;
import br.com.seuprojeto.starcodewars.model.Planeta;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PlanetaServico {

    @Inject
    private PlanetaDao dao;

    @Inject
    private ApiSwapi api;

    public void adicionar(Planeta planeta) {
        if (planeta.getNome() == null || planeta.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("nome obrigatorio");
        }

        if (dao.existe(planeta.getNome())) {
            throw new IllegalArgumentException("planeta ja existe");
        }

        int aparicoes = api.buscarAparicoes(planeta.getNome());
        planeta.setAparicoesFilmes(aparicoes);

        dao.salvar(planeta);
    }

    public List<Planeta> listar() {
        return dao.listar();
    }

    public Planeta buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    public List<Planeta> buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return listar();
        }
        return dao.buscarPorNome(nome);
    }

    public boolean remover(Long id) {
        return dao.remover(id);
    }
}