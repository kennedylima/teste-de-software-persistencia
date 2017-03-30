package com.htcursos.Produto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.htcursos.EntidadeBase;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity

public class Produto extends EntidadeBase implements Serializable {

    @JsonView(Produto.class)
    private  String descricao;

    @JsonView(Produto.class)
    private  double valor;

    public Produto() {}

    public Produto(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}
