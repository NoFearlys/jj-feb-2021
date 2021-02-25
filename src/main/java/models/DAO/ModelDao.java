package models.DAO;

import models.Model;

import javax.persistence.EntityManager;
import java.util.List;

public class ModelDao {
    private final EntityManager manager;

    public ModelDao(EntityManager manager) {
        this.manager = manager;
    }

    public List<Model> findAllModels() {
        return manager.createQuery("from Model", Model.class).getResultList();
    }

    public List<Model> findByVersion(String version) {
        return manager
                .createQuery("from Model where Model.version= :version", Model.class)
                .setParameter("version", version)
                .getResultList();
    }

    public void add(Model model){
        manager.persist(model);
    }

    public void remove(Model model){
        manager.remove(model);
    }
}
