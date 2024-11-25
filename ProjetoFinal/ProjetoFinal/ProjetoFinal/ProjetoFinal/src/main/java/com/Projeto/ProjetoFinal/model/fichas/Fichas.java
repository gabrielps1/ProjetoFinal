package com.Projeto.ProjetoFinal.model.fichas;

import com.Projeto.ProjetoFinal.model.pessoas.Pessoas;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "fichas")
public class Fichas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFicha;

    @ManyToOne
    @JoinColumn(name = "idPessoa", nullable = false)
    private Pessoas pessoa;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProdutoQuimico produtoQuimico;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ComoAplicaProduto comoAplicaProduto;

    @Enumerated(EnumType.STRING)
    private ViaExposicao viaExposicao;

    @org.jetbrains.annotations.NotNull
    @Enumerated(EnumType.STRING)
    private FicouDoente ficouDoente;

    @Enumerated(EnumType.STRING)
    private VezesDoente vezesDoente;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoInternado internado;

    @Enumerated(EnumType.STRING)
    private VezesInternado vezesInternado;

    @Enumerated(EnumType.STRING)
    private TempoAconteceu tempoAconteceu;

    @Enumerated(EnumType.STRING)
    private TipoContato tipoContato;

    @Enumerated(EnumType.STRING)
    private EquipamentosProtecao utilizaEquipamentosProtecao;

    @Enumerated(EnumType.STRING)
    private RoupaImprapropiada roupaImprapropiada;

    @Enumerated(EnumType.STRING)
    private Bota bota;

    @Enumerated(EnumType.STRING)
    private Luvas luvas;

    @Enumerated(EnumType.STRING)
    private Mascaras mascaras;

    @Enumerated(EnumType.STRING)
    private OculosProtecao oculosProtecao;

    @Enumerated(EnumType.STRING)
    private ProtetorAuricular protetorAuricular;

    public Fichas() {}

    public Fichas(DadosCadastroFicha dados) {
        this.pessoa = dados.pessoa();
        this.produtoQuimico = dados.produtoQuimico();
        this.comoAplicaProduto = dados.comoAplicaProduto();
        this.viaExposicao = dados.viaExposicao();
        this.ficouDoente = dados.ficouDoente();
        this.vezesDoente = dados.vezesDoente();
        this.internado = dados.internado();
        this.vezesInternado = dados.vezesInternado();
        this.tempoAconteceu = dados.tempoAconteceu();
        this.tipoContato = dados.tipoContato();
        this.utilizaEquipamentosProtecao = dados.utilizaEquipamentosProtecao();
        this.roupaImprapropiada = dados.roupaImprapropiada();
        this.bota = dados.bota();
        this.luvas = dados.luvas();
        this.mascaras = dados.mascaras();
        this.oculosProtecao = dados.oculosProtecao();
        this.protetorAuricular = dados.protetorAuricular();
    }

    public void atualizaDados(DadosAltecaoficha dados) {
        this.produtoQuimico = dados.produtoQuimico();
        this.comoAplicaProduto = dados.comoAplicaProduto();
        this.viaExposicao = dados.viaExposicao();
        this.ficouDoente = dados.ficouDoente();
        this.vezesDoente = dados.vezesDoente();
        this.internado = dados.internado();
        this.vezesInternado = dados.vezesInternado();
        this.tempoAconteceu = dados.tempoAconteceu();
        this.tipoContato = dados.tipoContato();
        this.utilizaEquipamentosProtecao = dados.utilizaEquipamentosProtecao();
        this.roupaImprapropiada = dados.roupaImprapropiada();
        this.bota = dados.bota();
        this.luvas = dados.luvas();
        this.mascaras = dados.mascaras();
        this.oculosProtecao = dados.oculosProtecao();
        this.protetorAuricular = dados.protetorAuricular();
    }

    // Getters and setters

    public Long getIdFicha() {
        return idFicha;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public ProdutoQuimico getProdutoQuimico() {
        return produtoQuimico;
    }

    public ComoAplicaProduto getComoAplicaProduto() {
        return comoAplicaProduto;
    }

    public ViaExposicao getViaExposicao() {
        return viaExposicao;
    }

    public FicouDoente getFicouDoente() {
        return ficouDoente;
    }

    public VezesDoente getVezesDoente() {
        return vezesDoente;
    }

    public EstadoInternado getInternado() {
        return internado;
    }

    public VezesInternado getVezesInternado() {
        return vezesInternado;
    }

    public TempoAconteceu getTempoAconteceu() {
        return tempoAconteceu;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public EquipamentosProtecao getUtilizaEquipamentosProtecao() {
        return utilizaEquipamentosProtecao;
    }

    public RoupaImprapropiada getRoupaImprapropiada() {
        return roupaImprapropiada;
    }

    public Bota getBota() {
        return bota;
    }

    public Luvas getLuvas() {
        return luvas;
    }

    public Mascaras getMascaras() {
        return mascaras;
    }

    public OculosProtecao getOculosProtecao() {
        return oculosProtecao;
    }

    public ProtetorAuricular getProtetorAuricular() {
        return protetorAuricular;
    }

    @Override
    public String toString() {
        return "Ficha{" +
                "idFicha=" + idFicha +
                ", pessoa=" + pessoa +
                ", produtoQuimico=" + produtoQuimico +
                ", comoAplicaProduto=" + comoAplicaProduto +
                ", viaExposicao=" + viaExposicao +
                ", ficouDoente=" + ficouDoente +
                ", vezesDoente=" + vezesDoente +
                ", internado=" + internado +
                ", vezesInternado=" + vezesInternado +
                ", tempoAconteceu=" + tempoAconteceu +
                ", tipoContato=" + tipoContato +
                ", utilizaEquipamentosProtecao=" + utilizaEquipamentosProtecao +
                ", roupaImprapropiada=" + roupaImprapropiada +
                ", bota=" + bota +
                ", luvas=" + luvas +
                ", mascaras=" + mascaras +
                ", oculosProtecao=" + oculosProtecao +
                ", protetorAuricular=" + protetorAuricular +
                '}';
    }

    // Enums para representar valores discretos

    public enum ProdutoQuimico {
        ACIDO_SULFURICO, AMONIA, CLORO, OUTRO;
    }

    public enum ComoAplicaProduto {
        BOMBA_COSTAL, MANGUEIRA, TRATOR_SEM_CABINE, TRATOR_CABINE_FECHADA, NI;
    }

    public enum ViaExposicao {
        CUTANEA, DIGESTIVA, RESPIRATORIA;
    }

    public enum FicouDoente {
        SIM, NAO;
    }

    public enum VezesDoente {
        UMA_UNICA_VEZ, MAIS_DE_UMA_VEZ, NENHUMA_VEZ;
    }

    public enum EstadoInternado {
        SIM, NAO;
    }

    public enum VezesInternado {
        UMA_UNICA_VEZ, MAIS_DE_UMA_VEZ, NENHUMA_VEZ;
    }

    public enum TempoAconteceu {
        MENOS_DE_10_ANOS, MAIS_DE_10_ANOS, NENHUMA_VEZ;
    }

    public enum TipoContato {
        DIRETO, INDIRETO, SEM_CONTATO;
    }

    public enum EquipamentosProtecao {
        COMPLETO, IMCOMPLETO, NAO;
    }

    public enum RoupaImprapropiada {
        SIM, NAO;
    }

    public enum Bota {
        SIM, NAO;
    }

    public enum Luvas {
        SIM, NAO;
    }

    public enum Mascaras {
        SIM, NAO;
    }

    public enum OculosProtecao {
        SIM, NAO;
    }

    public enum ProtetorAuricular {
        SIM, NAO;
    }
}
