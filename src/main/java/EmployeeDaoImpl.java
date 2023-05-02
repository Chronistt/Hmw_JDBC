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

        /*try (PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                "INSERT INTO employeeList (first_name, last_name, gender, age, city_id) VALUES ((?),(?),(?),(?),(?))");) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
           // statement.setInt(5, employee.getCity().getCity_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

    }

    @Override
    public Employee getById(Employee employee) {
        Employee employeeId;
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        employeeId = entityManager.find(Employee.class, employee.getId());
        transaction.commit();
        entityManager.close();
        return employeeId;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();

        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        String query = "SELECT e FROM employeeList e";
        employees = entityManager.createQuery(query).getResultList();
        transaction.commit();
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

        entityManager.remove(getById(employee.getId()));

    transaction.commit();
    entityManager.close();

    }
    private static EntityManager createEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

        return entityManagerFactory.createEntityManager();

    }
}
