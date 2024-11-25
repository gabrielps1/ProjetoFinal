package com.Projeto.ProjetoFinal.model.pessoas;

import com.Projeto.ProjetoFinal.model.fichas.Fichas;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Pessoas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    private String nomePessoa;
    private String endereco;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fichas> ListaFichas = new ArrayList<>();

    // Construtor padrão
    public Pessoas() {
    }

    // Construtor utilizando os dados de cadastro
    public Pessoas(DadosCadastroPessoa dados) {
        this.nomePessoa = dados.nomePessoa();
        this.endereco = dados.endereco();
    }

    public void atualizaDados(DadosAltecaopessoa dados) {
        this.nomePessoa = dados.nomePessoa();
        this.endereco = dados.endereco();
    }

    // Getters e Setters
    public Long getIdPessoa() {
        return idPessoa;
    }



    public String getNomePessoa() {
        return nomePessoa;
    }
    public void setNomePessoa(String nomePessoa) {this.nomePessoa = nomePessoa;}
    public String getEndereco() {
        return endereco;
    }
    public List<Fichas> getListaFichas() {return ListaFichas;}

    @Override
    public String toString() {
        return "Pessoas{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nomePessoa + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
