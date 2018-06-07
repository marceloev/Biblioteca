package br.com.sinergia.Dao;

import br.com.sinergia.Entity.Biblioteca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BibliotecaDao {

    EntityManagerFactory emf;
    EntityManager em;
    Query query;

    public BibliotecaDao() {
        this.emf = Persistence.createEntityManagerFactory("Sinergia");
        this.em = emf.createEntityManager();
    }

    public List<Biblioteca> getAllBiblioteca() throws Exception {
        query = em.createNamedQuery("Biblioteca.findAll");
        return query.getResultList();
    }

    public Biblioteca getBibliotecaByCod(int cod) throws Exception {
        query = em.createNamedQuery("Biblioteca.findByCod");
        query.setParameter("P_CODBIB", cod);
        return (Biblioteca) query.getSingleResult();
    }

    public List<Biblioteca> getBibliotecaByName(String nome) throws Exception {
        query = em.createNamedQuery("Biblioteca.findByName");
        String p_nome = nome.replaceAll(" ", "%");
        query.setParameter("P_NOME", "%".concat(p_nome).concat("%"));
        return query.getResultList();
    }
}
