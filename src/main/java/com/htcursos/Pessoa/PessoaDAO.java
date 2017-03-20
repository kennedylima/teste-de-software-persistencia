package com.htcursos.Pessoa;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PessoaDAO implements PessoaRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    @Override
    public void excluir(int id) {
        entityManager.remove(entityManager.getReference(Pessoa.class, id));
    }

    @Override
    public Pessoa buscarPelo(String nome) throws EmptyResultDataAccessException {
        return (Pessoa) entityManager.createQuery("FROM Pessoa WHERE nome=:nome")
                .setParameter("nome", nome)
                .setMaxResults(1)
                .getSingleResult();
    }
}
