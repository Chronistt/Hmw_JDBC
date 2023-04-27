import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


        /*Employee employee = new Employee();
    try (PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
            "SELECT * FROM employeeList INNER JOIN city " +
                    "ON employeeList.city_id = city.city_id WHERE id = (?)")){
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
        employee.setId(resultSet.getInt(1));
        employee.setFirst_name(resultSet.getString("first_name"));
        employee.setLast_name(resultSet.getString("last_name"));
        employee.setGender(resultSet.getString("gender"));
        employee.setAge(resultSet.getInt(5));
       employee.setCity(new City((resultSet.getInt("city_id")), resultSet.getString("city_name")));
        }


    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return employee;
    }        */
return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();

        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        String query = "SELECT * FROM employeeList";
        employees = entityManager.createQuery(query).getResultList();
        transaction.commit();
        entityManager.close();


      /*  try (PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                "SELECT * FROM employeeList INNER JOIN city " +
                        "ON employeeList.city_id = city.city_id")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = Integer.parseInt(resultSet.getString("age"));
                City city = new City(resultSet.getInt("city_id"), resultSet.getString("city_name"));
             //   employees.add(new Employee(id, firstName, lastName, gender,age, city));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
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
    /*try (
            PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                    "UPDATE employeeList SET first_name = (?), last_name= (?), gender = (?), city_id = (?), WHERE id = (?)")) {
            statement.setString(1, employee.getFirst_name());
        statement.setString(2, employee.getLast_name());
        statement.setString(3, employee.getGender());
        statement.setInt(4,employee.getAge());
       // statement.setInt(5,employee.getCity().getCity_id());
        statement.setInt(6,id);

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }*/
    }

    @Override
    public void deleteEmployee(Employee employee) {
    EntityManager entityManager = createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();

    entityManager.remove(employee);

    transaction.commit();
    entityManager.close();

    }
    private static EntityManager createEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistensUnit");

        return entityManagerFactory.createEntityManager();

    }
}
