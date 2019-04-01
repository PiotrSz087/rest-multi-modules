package ps.dao;

import ps.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

    Employee findById(long theId);

    void save(Employee theEmployee);

    void deleteById(int theId);
}
