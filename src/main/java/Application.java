import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static CityDaoImpl cityDao = new CityDaoImpl();
    static EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

    public static void main(String[] args) throws SQLException {

        City city = new City("Pskov");
        cityDao.add(city);

        Employee employee1 = new Employee ("Мария", "Иванова", "fem", 37, city);
        Employee employee2 = new Employee ("Максим", "Ганнов", "masc", 19, city);

        city.setEmployees(List.of(employee1,employee2));

        cityDao.updateCity(city);

        System.out.println("Работники города: "+ employeeDao.getAllEmployee().containsAll(city.getEmployees()));







    }

}
