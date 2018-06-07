package br.com.sinergia.Dao;

import br.com.sinergia.Entity.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EnderecoDao {

    EntityManagerFactory emf;
    EntityManager em;
    Query query;

    public EnderecoDao() {
        this.emf = Persistence.createEntityManagerFactory("Sinergia");
        this.em = emf.createEntityManager();
    }

    public List<Endereco> getAllEndereco() throws Exception {
        query = em.createNamedQuery("Endereco.findAll");
        return query.getResultList();
    }

    public Endereco getEnderecoByCod(int cod) throws Exception {
        query = em.createNamedQuery("Endereco.findByCod");
        query.setParameter("P_CODEND", cod);
        return (Endereco) query.getSingleResult();
    }

    public List<Endereco> getEnderecoByName(String nome) throws Exception {
        query = em.createNamedQuery("Endereco.findByName");
        String p_nome = nome.replace(" ", "%");
        query.setParameter("P_DESCREND", "%".concat(p_nome).concat("%"));
        return query.getResultList();
    }
}
