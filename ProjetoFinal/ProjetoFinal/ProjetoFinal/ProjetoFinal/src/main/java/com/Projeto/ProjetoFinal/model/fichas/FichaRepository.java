package com.Projeto.ProjetoFinal.model.fichas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FichaRepository extends JpaRepository<Fichas, Long> {
    List<Fichas> findByProdutoQuimico(Fichas.ProdutoQuimico produtoQuimico);
    List<Fichas> findByFicouDoente(Fichas.FicouDoente ficouDoente);
    @Query("SELECT f FROM Fichas f WHERE f.internado = :estado")
    List<Fichas> findByInternado(@Param("estado") Fichas.EstadoInternado estado);
    @Query("SELECT f FROM Fichas f WHERE f.viaExposicao = :viaExposicao")
    List<Fichas> findByViaExposicao(@Param("viaExposicao") Fichas.ViaExposicao viaExposicao);
}
