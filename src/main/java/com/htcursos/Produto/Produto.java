package com.htcursos.Produto;

import com.htcursos.EntidadeBase;

import javax.persistence.Entity;

@Entity
public class Produto extends EntidadeBase{

    private final String produto;
    private final double valor;

    public Produto(String produto, double valor) {
        this.produto = produto;
        this.valor = valor;
    }
}
