package com.Projeto.ProjetoFinal.model.fichasprodutos;

import com.Projeto.ProjetoFinal.model.fichas.Fichas;
import com.Projeto.ProjetoFinal.model.produtos.Produtos;
import jakarta.persistence.*;

@Entity
@Table(name = "ficha_produtos")
public class FichaProdutos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_fichas")
    private Fichas ficha;

    @ManyToOne
    @JoinColumn(name = "id_produtos")
    private Produtos produto;

    public FichaProdutos() {}

    public FichaProdutos(Fichas ficha, Produtos produto) {
        this.ficha = ficha;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public Fichas getFicha() {
        return ficha;
    }

    public Produtos getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return "FichaProdutos{" +
                "id=" + id +
                ", ficha=" + ficha +
                ", produto=" + produto +
                '}';
    }
}
