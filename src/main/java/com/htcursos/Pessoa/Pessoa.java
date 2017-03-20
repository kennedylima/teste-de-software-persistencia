package com.htcursos.Pessoa;

import com.htcursos.EntidadeBase;

import javax.persistence.Entity;

@Entity
public class Pessoa extends EntidadeBase{
    private String nome;
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
