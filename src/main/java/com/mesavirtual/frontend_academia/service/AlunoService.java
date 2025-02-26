package com.mesavirtual.frontend_academia.service;

import com.mesavirtual.frontend_academia.model.Aluno;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AlunoService {

    @Value("${api.url}") // Injeta a URL da API do backend
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<Aluno> listarTodos() {
        Aluno[] alunos = restTemplate.getForObject(apiUrl + "/alunos", Aluno[].class);
        return Arrays.asList(alunos);
    }

    public Aluno buscarPorId(Long id) {
        return restTemplate.getForObject(apiUrl + "/alunos/" + id, Aluno.class);
    }

    public void salvarAluno(Aluno aluno) {
        restTemplate.postForObject(apiUrl + "/alunos", aluno, Aluno.class);
    }
}
