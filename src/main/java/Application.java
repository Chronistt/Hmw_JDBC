import java.sql.*;
public class Application {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "dom88173827027";
        final String url = "jdbc:postgresql://localhost:5432/employee";

        try (final Connection connection = DriverManager.getConnection(user, password, url);
             PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM employeeList WHERE id = (?)")) {
            statement.setInt(1, 6);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = "Имя: " + resultSet.getString("first_name");
                String surname = "Фамилия: " + resultSet.getString("last_name");
                String gender = "Пол: " + resultSet.getString("gender");
                int age = resultSet.getInt("age");

                System.out.println(name);
                System.out.println(surname);
                System.out.println(gender);
                System.out.println("Возраст: " + age);
            }
        }

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        System.out.println(employeeDao.getAllEmployee());
        Employee employee = new Employee(1, "Мария", "Иванова", "fem", 37, new City(5, "Тобольск"));
        employeeDao.add(employee);
        System.out.println(employeeDao.getAllEmployee());

        employee.setLast_name("Жукова");
        employeeDao.updateEmployee(10, employee);
        System.out.println(employeeDao.getById(10));
        employeeDao.deleteEmployee(4);
        System.out.println(employeeDao.getAllEmployee());
    }

}
