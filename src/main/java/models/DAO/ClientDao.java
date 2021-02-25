package models.DAO;

import models.City;
import models.Client;
import models.Model;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDao {
    private final EntityManager manager;

    public ClientDao(EntityManager manager) {
        this.manager = manager;
    }

    public List<Client> findAllClients() {
        return manager.createQuery("from Client", Client.class).getResultList();
    }

    public List<Client> findByCity(City city) {
        return manager
                .createQuery("from Client where Client.city= :city", Client.class)
                .setParameter("city", city)
                .getResultList();
    }

    public List<Client> findByModel(Model model) {
        return manager
                .createQuery("from Client where Client.model= :model", Client.class)
                .setParameter("model", model)
                .getResultList();
    }

    public void add(Client client){manager.persist(client);}

    public void remove(Client client){manager.remove(client);}
}
