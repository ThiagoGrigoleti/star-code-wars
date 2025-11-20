package br.com.thiago.starcodewars.repository;

import br.com.thiago.starcodewars.model.Planeta;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.List;

@ApplicationScoped
public class PlanetaDao {

    private EntityManagerFactory emf;

    public PlanetaDao() {
        this.emf = Persistence.createEntityManagerFactory("PlanetasPU");
    }

    public void salvar(Planeta planeta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(planeta);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Planeta> listar() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Planeta p", Planeta.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Planeta buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Planeta.class, id);
        } finally {
            em.close();
        }
    }

    public List<Planeta> buscarPorNome(String nome) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Planeta> query = em.createQuery(
                    "SELECT p FROM Planeta p WHERE LOWER(p.nome) LIKE LOWER(:nome)",
                    Planeta.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public boolean remover(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Planeta planeta = em.find(Planeta.class, id);
            if (planeta != null) {
                em.remove(planeta);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } finally {
            em.close();
        }
    }

    public boolean existe(String nome) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(p) FROM Planeta p WHERE LOWER(p.nome) = LOWER(:nome)",
                    Long.class);
            query.setParameter("nome", nome);
            return query.getSingleResult() > 0;
        } finally {
            em.close();
        }
    }
}