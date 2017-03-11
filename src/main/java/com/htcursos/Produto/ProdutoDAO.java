package com.htcursos.Produto;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ProdutoDAO implements ProdutoRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Produto produto) {
       entityManager.persist(produto);

    }


    @Override
    public Produto buscaPela(String descricao) {
        return (Produto) entityManager.createQuery("FROM Produto WHERE valor=:descricao")
                .setParameter("descricao", descricao)
                .setMaxResults(1)
                .getSingleResult();
    }
}
