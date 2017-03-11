package com.htcursos.Produto;

public interface ProdutoRepository  {
    void salvar(Produto produto);
    Produto buscaPela(String descricao);
}
