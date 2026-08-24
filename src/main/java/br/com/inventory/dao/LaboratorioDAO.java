package br.com.inventory.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import br.com.inventory.modelo.Laboratorio;

public class LaboratorioDAO {

    public void salvar(Laboratorio laboratorio) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(laboratorio);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Laboratorio> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT l FROM Laboratorio l", Laboratorio.class).getResultList();
        } finally {
            em.close();
        }
    }
}