package com.pivetta.cucumber.pessoa.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
    private Long id;
    private String nome;
    private String sobrenome;
    private int idade;

    public Pessoa(Long id, String nome, String sobrenome, int idade) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    public Pessoa(String nome, String sobrenome, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }
}
