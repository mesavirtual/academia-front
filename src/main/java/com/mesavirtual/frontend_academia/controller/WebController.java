package com.mesavirtual.frontend_academia.controller;

import com.mesavirtual.frontend_academia.model.Aluno;
import com.mesavirtual.frontend_academia.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "home";
    }


}
