package com.Projeto.ProjetoFinal.controller;

import com.Projeto.ProjetoFinal.model.produtos.DadosCadastroProduto;
import com.Projeto.ProjetoFinal.model.produtos.DadosAlteracaoProduto;
import com.Projeto.ProjetoFinal.model.produtos.ProdutoRepository;
import com.Projeto.ProjetoFinal.model.produtos.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/formulario")
    public String carregaFormulario(Long idProduto, Model model)
    {
        if (idProduto != null) {
            Produtos produto = repository.getReferenceById(idProduto);
            model.addAttribute("produto", produto);
        }
        return "/produtos/formulario";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "/produtos/listagem";
    }

    @PostMapping("/formulario")
    public String cadastraProduto(DadosCadastroProduto dados) {
        Produtos produto = new Produtos(dados);
        repository.save(produto);
        return "redirect:/produtos/listagem";
    }

    @DeleteMapping
    @Transactional
    public String removeProduto(@RequestParam Long id) {
        repository.deleteById(id);
        return "redirect:/produtos/listagem";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alteraProduto(DadosAlteracaoProduto dados)
    {
        Produtos produto = repository.getReferenceById(dados.idProduto());
        produto.atualizaDados(dados);
        repository.save(produto);
        return "redirect:/produtos/listagem";
    }

    @GetMapping("/pesquisaPorNome")
    public String pesquisaProdutosPorNome(@RequestParam(required = false) String nomeProduto, Model model) {
        // Se 'nomeProduto' for fornecido, faz a pesquisa, senão, não exibe resultados
        if (nomeProduto != null && !nomeProduto.isEmpty()) {
            List<Produtos> produtos = repository.findByNome(nomeProduto);
            model.addAttribute("produtos", produtos);
            model.addAttribute("nomeProduto", nomeProduto);
        } else {
            model.addAttribute("produtos", null);  // Não exibe produtos se não houver pesquisa
        }
        return "produtos/pesquisaPorNome"; // Retorna para a view de pesquisa
    }
}
