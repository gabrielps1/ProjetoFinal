package com.Projeto.ProjetoFinal.model.fichas;

public record DadosAltecaoficha(
        Long idFicha,
        Fichas.ProdutoQuimico produtoQuimico,
        Fichas.ComoAplicaProduto comoAplicaProduto,
        Fichas.ViaExposicao viaExposicao,
        Fichas.FicouDoente ficouDoente,
        Fichas.VezesDoente vezesDoente,
        Fichas.EstadoInternado internado,
        Fichas.VezesInternado vezesInternado,
        Fichas.TempoAconteceu tempoAconteceu,
        Fichas.TipoContato tipoContato,
        Fichas.EquipamentosProtecao utilizaEquipamentosProtecao,
        Fichas.RoupaImprapropiada roupaImprapropiada,
        Fichas.Bota bota,
        Fichas.Luvas luvas,
        Fichas.Mascaras mascaras,
        Fichas.OculosProtecao oculosProtecao,
        Fichas.ProtetorAuricular protetorAuricular
) {
}
