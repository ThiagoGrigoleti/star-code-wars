package br.com.thiago.starcodewars.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "planetas")

public class Planeta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;

    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String clima;

    @Column(nullable = false)
    private String terreno;

    @Column(name = "aparicoes_filmes")
    private Integer aparicoesFilmes;

    public Planeta() {}

    public Planeta(String nome, String clima, String terreno){
        this.clima = clima;
        this.terreno = terreno;
        this.nome = nome;
    }


    //getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getClima() { return clima; }
    public void setClima(String clima) { this.clima = clima; }
    public String getTerreno() { return terreno; }
    public void setTerreno(String terreno) { this.terreno = terreno; }
    public Integer getAparicoesFilmes() { return aparicoesFilmes; }
    public void setAparicoesFilmes(Integer aparicoesFilmes) { this.aparicoesFilmes = aparicoesFilmes; }


}