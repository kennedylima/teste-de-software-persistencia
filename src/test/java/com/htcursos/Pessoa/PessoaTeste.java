package com.htcursos.Pessoa;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class PessoaTeste {

    @Autowired
    PessoaRepository pessoaRepository;
    Pessoa pessoa;

    @Test
    public void deve_salvar_uma_pessoa (){
        pessoa = new Pessoa("Paula",21d);

        pessoaRepository.salvar(pessoa);

        assertNotNull(pessoa.getId());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deve_excluir_uma_pessoa(){
        pessoa = new Pessoa("Jao", 19d);

        pessoaRepository.salvar(pessoa);
        pessoaRepository.excluir(pessoa.getId());

        pessoaRepository.buscarPelo("Jao");
    }

}
