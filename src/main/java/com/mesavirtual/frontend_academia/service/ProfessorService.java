package com.mesavirtual.frontend_academia.service;

import com.mesavirtual.frontend_academia.model.Professor;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProfessorService {

    @Value("${api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<Professor> listarTodos() {
        Professor[] professores = restTemplate.getForObject(apiUrl + "/professores", Professor[].class);
        return Arrays.asList(professores);
    }

    public Professor buscarPorId(Long id) {
        return restTemplate.getForObject(apiUrl + "/professores/" + id, Professor.class);
    }

    public void salvarProfessor(Professor professor) {
        restTemplate.postForObject(apiUrl + "/professores", professor, Professor.class);
    }
}
