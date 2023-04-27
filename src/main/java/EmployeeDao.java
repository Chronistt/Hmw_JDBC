import java.util.List;
public interface EmployeeDao {
void add (Employee employee);
Employee getById (Employee employee);
List <Employee> getAllEmployee ();
void updateEmployee (Employee employee);
void deleteEmployee (Employee employee);
}
