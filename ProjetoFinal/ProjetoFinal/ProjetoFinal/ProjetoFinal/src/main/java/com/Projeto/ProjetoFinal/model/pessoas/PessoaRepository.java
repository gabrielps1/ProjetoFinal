package com.Projeto.ProjetoFinal.model.pessoas;

import com.Projeto.ProjetoFinal.model.pessoas.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoas, Long> {
}
