package br.com.sinergia.Dao;

import br.com.sinergia.Entity.Livro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LivroDao {

    EntityManagerFactory emf;
    EntityManager em;
    Query query;

    public LivroDao() {
        this.emf = Persistence.createEntityManagerFactory("Sinergia");
        this.em = emf.createEntityManager();
    }

    public List<Livro> getAllLivros() throws Exception {
        query = em.createNamedQuery("Livro.findAll");
        return query.getResultList();
    }

    public Livro getLivroByCodigo(int codigo) throws Exception {
        query = em.createNamedQuery("Livro.findByCod");
        query.setParameter("P_CODLIV", codigo);
        return (Livro) query.getSingleResult();
    }

    public List<Livro> getLivroByNome(String nome) throws Exception {
        query = em.createNamedQuery("Livro.findByNome");
        String p_nome = nome.replaceAll(" ", "%");
        query.setParameter("P_NOMELIV", "%".concat(p_nome).concat("%"));
        return query.getResultList();
    }
}
