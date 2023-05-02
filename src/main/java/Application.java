import java.sql.*;
public class Application {
    public static void main(String[] args) throws SQLException {



        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee ("Мария", "Иванова", "fem", 37, 5);

        employeeDao.add(employee);
        System.out.println(employeeDao.getAllEmployee());
        employeeDao.deleteEmployee(employee);
        System.out.println(employeeDao.getAllEmployee());

        employeeDao.updateEmployee(employee);
    }

}
