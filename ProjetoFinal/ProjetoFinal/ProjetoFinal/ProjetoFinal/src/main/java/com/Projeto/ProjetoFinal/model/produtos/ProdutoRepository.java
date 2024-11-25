package com.Projeto.ProjetoFinal.model.produtos;

import com.Projeto.ProjetoFinal.model.produtos.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
    @Query(value = "SELECT * FROM produtos WHERE nome_produto LIKE %?1%", nativeQuery = true)
    List<Produtos> findByNome(String nomeProduto);
}
