package com.Projeto.ProjetoFinal.controller;

import com.Projeto.ProjetoFinal.model.fichas.FichaRepository;
import com.Projeto.ProjetoFinal.model.pessoas.DadosCadastroPessoa;
import com.Projeto.ProjetoFinal.model.pessoas.DadosAltecaopessoa;
import com.Projeto.ProjetoFinal.model.pessoas.PessoaRepository;
import com.Projeto.ProjetoFinal.model.pessoas.Pessoas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

import java.util.List;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;


    @GetMapping("/formulario")
    public String carregaFormulario(Long idPessoa, Model model) {
        if (idPessoa != null)
        {
            Pessoas pessoa = repository.getReferenceById(idPessoa);
            model.addAttribute("pessoas", pessoa);
        }
        return "/pessoas/formulario";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model) {
        model.addAttribute("listaPessoas", repository.findAll());
        return "/pessoas/listagem";
    }

    @PostMapping("/formulario")
    public String cadastraPessoa(DadosCadastroPessoa dados) {
        Pessoas pessoa = new Pessoas(dados);
        repository.save(pessoa);
        return "redirect:/pessoas/listagem";
    }

    @DeleteMapping
    @Transactional
    public String removePessoa(Long id) {
        repository.deleteById(id);
        return "redirect:/pessoas/listagem";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alteraPessoa(DadosAltecaopessoa dados)
    {
        Pessoas pessoa = repository.getReferenceById(dados.idPessoa());
        pessoa.atualizaDados(dados);
        repository.save(pessoa);
        return "redirect:/pessoas/listagem";
    }

}
