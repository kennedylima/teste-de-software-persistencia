package com.htcursos.Pessoa;

public interface PessoaRepository {

    void salvar(Pessoa pessoa);

    void excluir(int id);

    Pessoa buscarPelo(String nome);
}
