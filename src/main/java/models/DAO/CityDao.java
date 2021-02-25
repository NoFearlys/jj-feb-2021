package models.DAO;

import models.City;

import javax.persistence.EntityManager;
import java.util.List;

public class CityDao {
    private final EntityManager manager;

    public CityDao(EntityManager manager) {
        this.manager = manager;
    }

    public List<City> findAll() {return manager.createQuery("from City", City.class).getResultList();}

    public void add(City city){
        manager.getTransaction().begin();
        manager.persist(city);
        manager.getTransaction().commit();
    }

    public void remove(City city){
        manager.getTransaction().begin();
        manager.remove(city);
        manager.getTransaction().commit();
    }
}
