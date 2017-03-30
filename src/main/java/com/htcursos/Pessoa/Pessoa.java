package com.htcursos.Pessoa;

import com.fasterxml.jackson.annotation.JsonView;
import com.htcursos.EntidadeBase;

import javax.persistence.Entity;

@Entity
public class Pessoa extends EntidadeBase{

    @JsonView(Pessoa.class)
    private String nome;

    @JsonView(Pessoa.class)
    private double idade;

    public Pessoa(String nome, double idade) {

        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa() {

    }

    public double getIdade() {
        return idade;
    }
}
