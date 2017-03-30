package com.htcursos.Produto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class ProdutoTeste extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    ProdutoRepository produtoRepository ;
    Produto banana;

    @Before
    public void inicializar(){
        banana = new Produto("banana", 5d);
        produtoRepository.salvar(banana);
    }

    @Test
    public void deve_salvar_um_produto(){
        assertNotNull(banana.getId());
    }


    @Test(expected = EmptyResultDataAccessException.class)
    public void deve_excluir_um_produto(){
        produtoRepository.excluir(banana.getId());
        produtoRepository.buscaPela("banana");
    }

    @Test
    public void deve_excluir_um_produto_bucando_todos(){
        produtoRepository.excluir(banana.getId());

        Collection<Produto> produtos = produtoRepository.buscarTodos();

        assertThat(produtos, not(hasItem(banana)));
    }

    @Test
    public void deve_buscar_um_produto_pelo_id(){
        Produto produtoEncontrado = produtoRepository.buscarPelo(banana.getId());
        assertEquals(banana.getId(),produtoEncontrado.getId());
    }

    @Test
    public void deve_buscar_todos_os_produtos(){
        Produto maca = new Produto("maça", 2d);
        int quantidadeEsperada = 2;

        produtoRepository.salvar(maca);
        Collection<Produto> produtos = produtoRepository.buscarTodos();

        assertEquals(quantidadeEsperada, produtos.size());

    }

}
