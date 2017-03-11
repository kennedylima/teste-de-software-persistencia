package com.htcursos.Produto;

import com.htcursos.EntidadeBase;

import javax.persistence.Entity;

@Entity
public class Produto extends EntidadeBase{

    private  String descricao;
    private  double valor;

    public Produto() {}

    public Produto(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
