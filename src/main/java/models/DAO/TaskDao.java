package models.DAO;

import models.Client;
import models.Task;

import javax.persistence.EntityManager;
import java.util.List;

public class TaskDao {
    private final EntityManager manager;

    public TaskDao(EntityManager manager) {
        this.manager = manager;
    }

    public List<Task> findAllTasks() {
        return manager.createQuery("from Task", Task.class).getResultList();
    }

    public List<Task> findByStatus(int status) {
        return manager
                .createQuery("from Task where Task.status= :status", Task.class)
                .setParameter("status", status)
                .getResultList();
    }

    public List<Task> findByClient(Client client) {
        return manager
                .createQuery("from Task where Task.client= :client", Task.class)
                .setParameter("client", client)
                .getResultList();
    }

    public void add(Task task){manager.persist(task);}

    public void remove(Task task){manager.remove(task);}

}
