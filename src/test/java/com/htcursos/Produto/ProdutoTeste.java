package com.htcursos.Produto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoTeste {

    @Autowired
    ProdutoRepository produtoRepository;

    @Test
    public void deve_salvar_um_produto(){
        Produto geladeira = new Produto("Geladeira", 2000d);

        produtoRepository.salvar(geladeira);

        assertNotNull(produtoRepository.buscaPelo("Geladeira"));
    }
}
