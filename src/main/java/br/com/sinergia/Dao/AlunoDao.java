package br.com.sinergia.Dao;

import br.com.sinergia.Entity.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AlunoDao {

    EntityManagerFactory emf;
    EntityManager em;
    Query query;

    public AlunoDao() {
        this.emf = Persistence.createEntityManagerFactory("Sinergia");
        this.em = emf.createEntityManager();
    }

    public List<Aluno> getAllAlunos() throws Exception {
        query = em.createNamedQuery("Aluno.findAll");
        return query.getResultList();
    }

    public Aluno getAlunoByCodigo(int codigo) throws Exception {
        query = em.createNamedQuery("Aluno.findByCod");
        query.setParameter("P_CODALU", codigo);
        return (Aluno) query.getSingleResult();
    }

    public Aluno getAlunoByMatricula(String matricula) throws Exception {
        query = em.createNamedQuery("Aluno.findByMatricula");
        query.setParameter("P_MATRICULA", matricula);
        return (Aluno) query.getSingleResult();
    }

    public List<Aluno> getAlunoByName(String nome) throws Exception {
        query = em.createNamedQuery("Aluno.findByName");
        String p_nome = nome.replaceAll(" ", "%");
        query.setParameter("P_NOME", "%".concat(p_nome).concat("%"));
        return query.getResultList();
    }
}
