import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void add(Employee employee) {

        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();



    }

    @Override
    public Employee getById(int id) {
        Employee employeeId;
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        employeeId = entityManager.find(Employee.class, id);
        transaction.commit();
        entityManager.close();
        return employeeId;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees;

        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        String query = "SELECT e FROM Employee e";
        employees = entityManager.createQuery(query).getResultList();
        //transaction.commit();
        entityManager.close();


      return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(employee);

        transaction.commit();
        entityManager.close();

    }

    @Override
    public void deleteEmployee(Employee employee) {
    EntityManager entityManager = createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    int id = employee.getId();

        entityManager.remove(getById (id));

    transaction.commit();
    entityManager.close();

    }
    private static EntityManager createEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

        return entityManagerFactory.createEntityManager();

    }
}
