package ps.service;

import ps.entity.Employee;

import java.util.List;

public interface EmployeeServiceHibernate {
    List<Employee> findAll();

    Employee findById(long theId);

    void save(Employee theEmployee);

    void deleteById(int theId);
}
