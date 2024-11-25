package com.Projeto.ProjetoFinal.model.produtos;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    private String nomeProduto;

    private String classeQuimica;

    public Produtos() {
    }

    public Produtos(DadosCadastroProduto dados) {
        this.nomeProduto = dados.nomeProduto();
        this.classeQuimica = dados.classeQuimica();
    }

    public void atualizaDados(DadosAlteracaoProduto dados)
    {
        this.nomeProduto = dados.nomeProduto();
        this.classeQuimica = dados.classeQuimica();
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getClasseQuimica() {
        return classeQuimica;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", classeQuimica='" + classeQuimica + '\'' +
                '}';
    }
}
