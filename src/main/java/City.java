import javax.persistence.*;

import java.util.List;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;
    @Column
    private String city_name;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public City() {
    }

    public City(String city_name) {
        this.city_name = city_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}

