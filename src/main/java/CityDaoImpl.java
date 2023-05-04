import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class CityDaoImpl implements CityDao{

    @Override
    public City add(City city) {
       EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(city);
        transaction.commit();
        entityManager.close();
        return city;
    }

    @Override
    public City getById(int id) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        City cityId = entityManager.find(City.class, id);

        transaction.commit();
        entityManager.close();
        return cityId;
    }

    @Override
    public List<City> getAllCity() {
        List <City> cities;
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "SELECT e FROM City e";
        cities = entityManager.createQuery(query).getResultList();

        transaction.commit();
        entityManager.close();
        return null;
    }

    @Override
    public void updateCity(City city) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(city);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteCity(City city) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        int id = city.getCity_id();

        entityManager.remove(getById (id));

        transaction.commit();
        entityManager.close();

    }
    private static EntityManager createEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

        return entityManagerFactory.createEntityManager();

    }
}
