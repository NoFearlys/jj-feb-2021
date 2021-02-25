package models.DAO;

import models.City;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.*;

public class CityDaoTest {

    private EntityManagerFactory factory;
    private EntityManager manager;
    private CityDao cityDao;
    private City city;

    @Before
    public void configure(){
        factory = Persistence.createEntityManagerFactory(
                "TestPersistenceUnit"
        );
        manager = factory.createEntityManager();
        cityDao = new CityDao(manager);
        city = new City("SPb");
    }

    @After
    public void cleanup() {
        if (manager != null) {
            manager.close();
        }
        if (factory != null) {
            factory.close();
        }
    }
@Test
    public void testAdd() {
        cityDao.add(city);
        assertEquals("SPb", cityDao.findAll().get(0).getName());
    }
@Test
    public void testRemove() {
        int cityId = city.getCityId();
        cityDao.remove(city);
        assertNull(manager.find(City.class, cityId));
    }
}