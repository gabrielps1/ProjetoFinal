package com.Projeto.ProjetoFinal.model.fichasprodutos;

import com.Projeto.ProjetoFinal.model.fichasprodutos.FichaProdutos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaProdutoRepository extends JpaRepository<FichaProdutos, Long> {
}