package com.example.unicar.usuario;

public class Usuario {

    private String codigo_aluno;
    private String nome;
    private String email;
    private String numero;
    private String senha;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigo_aluno() {
        return codigo_aluno;
    }

    public void setCodigo_aluno(String codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
