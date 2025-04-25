package com.mesavirtual.frontend_academia.model;

public class Professor {

    private Long id;
    private String nome;
    private String cpf;
    private String especializacao;

    // Construtor padrão
    public Professor() {
    }

    // Construtor com parâmetros
    public Professor(Long id, String nome, String cpf, String especializacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.especializacao = especializacao;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    // Método toString para facilitar a visualização
    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", especializacao='" + especializacao + '\'' +
                '}';
    }
}
