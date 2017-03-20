package com.htcursos.Produto;

import java.util.Collection;

public interface ProdutoRepository  {
    void salvar(Produto produto);
    Produto buscaPela(String descricao);

    void excluir(int id);

    Produto buscarPeloId(int id);

    Collection<Produto> buscaTodos();
}
