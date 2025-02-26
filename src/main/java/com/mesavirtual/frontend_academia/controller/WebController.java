package com.mesavirtual.frontend_academia.controller;

import com.mesavirtual.frontend_academia.model.Aluno;
import com.mesavirtual.frontend_academia.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/alunos")
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", alunoService.listarTodos());
        return "alunos";
    }

    @GetMapping("/alunos/novo")
    public String formularioCadastrarAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "cadastrar-aluno";
    }

    @PostMapping("/alunos")
    public String cadastrarAluno(@ModelAttribute Aluno aluno) {
        alunoService.salvarAluno(aluno);
        return "redirect:/web/alunos";
    }

    @GetMapping("/alunos/{id}")
    public String detalhesAluno(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id);
        model.addAttribute("aluno", aluno);
        return "detalhes-aluno";
    }
}
