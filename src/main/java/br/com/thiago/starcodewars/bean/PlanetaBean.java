package br.com.thiago.starcodewars.bean;

import br.com.thiago.starcodewars.model.Planeta;
import br.com.thiago.starcodewars.service.PlanetaServico;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PlanetaBean implements Serializable {

    @Inject
    private PlanetaServico servico;

    private Planeta planeta;
    private List<Planeta> planetas;
    private String buscaNome;
    private Long buscaId;

    @PostConstruct
    public void init() {
        planeta = new Planeta();
        carregar();
    }

    public void carregar() {
        planetas = servico.listar();
    }

    public void adicionar() {
        try {
            servico.adicionar(planeta);
            msg(FacesMessage.SEVERITY_INFO, "sucesso", "planeta adicionado");
            planeta = new Planeta();
            carregar();
        } catch (IllegalArgumentException e) {
            msg(FacesMessage.SEVERITY_ERROR, "erro", e.getMessage());
        }
    }

    public void remover(Planeta p) {
        servico.remover(p.getId());
        msg(FacesMessage.SEVERITY_INFO, "sucesso", "removido");
        carregar();
    }

    public void buscarNome() {
        planetas = servico.buscarPorNome(buscaNome);
    }

    public void buscarId() {
        if (buscaId != null) {
            Planeta p = servico.buscarPorId(buscaId);
            planetas = p != null ? List.of(p) : List.of();
        }
    }

    public void limpar() {
        buscaNome = null;
        buscaId = null;
        carregar();
    }

    private void msg(FacesMessage.Severity s, String t, String d) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(s, t, d));
    }

    public Planeta getPlaneta() { return planeta; }
    public void setPlaneta(Planeta planeta) { this.planeta = planeta; }
    public List<Planeta> getPlanetas() { return planetas; }
    public String getBuscaNome() { return buscaNome; }
    public void setBuscaNome(String n) { this.buscaNome = n; }
    public Long getBuscaId() { return buscaId; }
    public void setBuscaId(Long id) { this.buscaId = id; }
}