package com.Projeto.ProjetoFinal.controller;

import com.Projeto.ProjetoFinal.model.fichas.DadosAltecaoficha;
import com.Projeto.ProjetoFinal.model.fichas.DadosCadastroFicha;
import com.Projeto.ProjetoFinal.model.fichas.Fichas;
import com.Projeto.ProjetoFinal.model.fichas.FichaRepository;
import com.Projeto.ProjetoFinal.model.pessoas.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fichas")
public class FichaController
{
    @Autowired
    private FichaRepository repository;

    @Autowired
    private PessoaRepository repositoryPessoas;


    @GetMapping("/formulario")
    public String carregaFormulario(@RequestParam(required = false) Long idFicha, Model model) {
        if (idFicha != null) {
            Fichas ficha = repository.getReferenceById(idFicha);
            model.addAttribute("fichas", ficha);
        } else {
            model.addAttribute("fichas", new Fichas()); // Adiciona um objeto vazio ao modelo
        }

        // Adicionando listas de enumerações ao modelo
        model.addAttribute("opcoesProdutoQuimico", Fichas.ProdutoQuimico.values());
        model.addAttribute("opcoesComoAplicaProduto", Fichas.ComoAplicaProduto.values());
        model.addAttribute("opcoesViaExposicao", Fichas.ViaExposicao.values());
        model.addAttribute("opcoesEstadoDeSaude", Fichas.FicouDoente.values());
        model.addAttribute("opcoesVezesDoente", Fichas.VezesDoente.values());
        model.addAttribute("opcoesEstadoInternado", Fichas.EstadoInternado.values());
        model.addAttribute("opcoesVezesInternado", Fichas.VezesInternado.values());
        model.addAttribute("opcoesTempoAconteceu", Fichas.TempoAconteceu.values());
        model.addAttribute("opcoesTipoContato", Fichas.TipoContato.values());
        model.addAttribute("opcoesEquipamentosProtecao", Fichas.EquipamentosProtecao.values());
        model.addAttribute("opcoesRoupaImprapropiada", Fichas.RoupaImprapropiada.values());
        model.addAttribute("opcoesBota", Fichas.Bota.values());
        model.addAttribute("opcoesLuvas", Fichas.Luvas.values());
        model.addAttribute("opcoesMascaras", Fichas.Mascaras.values());
        model.addAttribute("opcoesOculosProtecao", Fichas.OculosProtecao.values());
        model.addAttribute("opcoesProtetorAuricular", Fichas.ProtetorAuricular.values());

        // Carregar todas as pessoas para o select
        model.addAttribute("ListaPessoa", repositoryPessoas.findAll());

        return "/fichas/formulario";
    }

    // Exibir a listagem de fichas
    @GetMapping("/listagem")
    public String carregaListagem(Model model) {
        model.addAttribute("fichas", repository.findAll());
        return "/fichas/listagem";
    }

    // Cadastrar uma nova ficha
    @PostMapping("/formulario")
    public String cadastraFicha(@ModelAttribute DadosCadastroFicha dados) {
        Fichas ficha = new Fichas(dados);
        repository.save(ficha);
        return "redirect:/fichas/listagem";  // Redirecionar para listagem após salvar
    }

    // Alterar uma ficha existente
    @PutMapping("/formulario")
    @Transactional
    public String alteraFicha(@ModelAttribute DadosAltecaoficha dados)
    {
        Fichas ficha = repository.getReferenceById(dados.idFicha());
        ficha.atualizaDados(dados);
        repository.save(ficha);
        return "redirect:/fichas/listagem";  // Redirecionar para listagem após alteração
    }

    // Remover uma ficha
    @DeleteMapping("/{idFicha}")
    @Transactional
    public String removeFicha(@PathVariable Long idFicha) {
        repository.deleteById(idFicha);
        return "redirect:/fichas/listagem";  // Redirecionar para listagem após exclusão
    }

    @GetMapping("/pesquisaProdutoQuimico")
    public String pesquisaPorProdutoQuimico(@RequestParam(value = "produtoQuimico", required = false, defaultValue = "") String produtoQuimico, Model model) {
        if (!produtoQuimico.isEmpty()) {
            try {
                Fichas.ProdutoQuimico produto = Fichas.ProdutoQuimico.valueOf(produtoQuimico.toUpperCase()); // Convert string to enum
                List<Fichas> fichas = repository.findByProdutoQuimico(produto);
                model.addAttribute("fichas", fichas);
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", "Produto Químico não encontrado.");
            }
        }
        return "fichas/pesquisaProdutoQuimico"; // Return the view
    }


    @GetMapping("/pesquisaFicouDoente")
    public String pesquisaFicouDoente(@RequestParam(value = "ficouDoente", required = false, defaultValue = "") String ficouDoente, Model model) {
        if (!ficouDoente.isEmpty()) {
            try {
                Fichas.FicouDoente FicouDoenteEnum = Fichas.FicouDoente.valueOf(ficouDoente.toUpperCase());
                List<Fichas> fichas = repository.findByFicouDoente(FicouDoenteEnum);
                model.addAttribute("fichas", fichas);  // Adiciona a lista de fichas no modelo
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", "Valor inválido para 'ficouDoente'.");
            }
        }
        return "fichas/pesquisaFicouDoente";  // Retorna a view
    }

    @GetMapping("/pesquisarPorInternacao")
    public String pesquisaPorInternacao(@RequestParam(value = "internado", required = false, defaultValue = "") String internado, Model model) {
        if (!internado.isEmpty()) {
            try {
                // Converte o valor da requisição para o tipo enum
                Fichas.EstadoInternado internadoEnum = Fichas.EstadoInternado.valueOf(internado.toUpperCase());
                // Recupera as fichas com base no valor de 'internado'
                List<Fichas> fichas = repository.findByInternado(internadoEnum);
                // Adiciona as fichas ao modelo para a view
                model.addAttribute("fichas", fichas);
            } catch (IllegalArgumentException e) {
                // Se ocorrer um erro ao tentar converter o valor, exibe uma mensagem de erro
                model.addAttribute("error", "Valor inválido para 'internado'.");
            }
        }
        // Retorna a view para exibir as fichas
        return "fichas/pesquisarPorInternacao";
    }

    @GetMapping("/pesquisaPorViaExposicao")
    public String pesquisaPorViaExposicao(@RequestParam(value = "viaExposicao", required = false, defaultValue = "") String viaExposicao, Model model) {
        if (!viaExposicao.isEmpty()) {
            try {
                // Realiza a pesquisa usando JPQL no repositório
                Fichas.ViaExposicao viaExposicaoEnum = Fichas.ViaExposicao.valueOf(viaExposicao.toUpperCase());
                List<Fichas> fichas = repository.findByViaExposicao(viaExposicaoEnum);
                model.addAttribute("fichas", fichas); // Adiciona as fichas no modelo
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", "Valor inválido para 'viaExposicao'.");
            }
        }
        return "fichas/pesquisaPorViaExposicao"; // Retorna a view
    }

}
