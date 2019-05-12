package ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ps.entity.Employee;
import ps.exceptions.EmployeeNotFoundException;
import ps.service.EmployeeServiceHibernate;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {
    private EmployeeServiceHibernate employeeServiceHibernate;

    @Autowired
    public EmployeeController(EmployeeServiceHibernate employeeServiceHibernate) {
        this.employeeServiceHibernate = employeeServiceHibernate;
    }

    @GetMapping("/list")
    public List<Employee> getListOfEmployee() {
        return employeeServiceHibernate.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        Employee employee = employeeServiceHibernate.findById(id);

        if (employee == null) {
            throw new EmployeeNotFoundException("Customer id not found: " + id);
        }
        return employee;
    }

    @PostMapping("/save")
    public Employee saveNewEmployee(@RequestBody Employee employee) {
        employee.setId(0L);

        employeeServiceHibernate.save(employee);

        return employee;
    }

    @DeleteMapping("/delete")
    public String deleteTest() {
        System.out.println("delete test git");
        return "delete";
    }
}
