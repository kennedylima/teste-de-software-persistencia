package com.htcursos.Produto;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

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
    public void excluir(int id) {
        entityManager.remove(entityManager.getReference(Produto.class, id));
    }

    @Override
    public Produto buscarPeloId(int id) {
        return entityManager.find(Produto.class,id);
    }

    @Override
    public Collection<Produto> buscaTodos() {
        return entityManager.createQuery("FROM Produto p ").getResultList();
    }

    @Override
    public Produto buscaPela(String descricao)throws EmptyResultDataAccessException {

        return (Produto) entityManager.createQuery("FROM Produto WHERE descricao=:descricao")
                .setParameter("descricao", descricao)
                .setMaxResults(1)
                .getSingleResult();

    }


}
