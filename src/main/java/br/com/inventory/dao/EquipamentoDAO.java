package br.com.inventory.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import br.com.inventory.modelo.Equipamento;

public class EquipamentoDAO {

    public void salvar(Equipamento equipamento) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(equipamento);
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

    public List<Equipamento> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Equipamento e", Equipamento.class).getResultList();
        } finally {
            em.close();
        }
    }
}