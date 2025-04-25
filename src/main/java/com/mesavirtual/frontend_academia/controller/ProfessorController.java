package com.mesavirtual.frontend_academia.controller;

import com.mesavirtual.frontend_academia.model.Professor;
import com.mesavirtual.frontend_academia.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/listar")
    public String listarProfessores(Model model) {
        model.addAttribute("professores", professorService.listarTodos());
        return "professores";
    }

    @GetMapping("/novo")
    public String formularioCadastrarProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "cadastrar-professor";
    }

    @PostMapping("/salvar")
    public String cadastrarProfessor(@ModelAttribute Professor professor) {
        professorService.salvarProfessor(professor);
        return "redirect:/professores/listar";
    }

    @GetMapping("/listar/{id}")
    public String detalhesProfessor(@PathVariable Long id, Model model) {
        Professor professor = professorService.buscarPorId(id);
        model.addAttribute("professor", professor);
        return "detalhes-professor";
    }
}
