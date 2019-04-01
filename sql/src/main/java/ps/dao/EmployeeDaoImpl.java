package ps.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ps.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> theQuery = session.createQuery("from Employee", Employee.class);

        return theQuery.getResultList();
    }

    @Override
    public Employee findById(long theId) {
        Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class, theId);

        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
        Session session = entityManager.unwrap(Session.class);

        session.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from employee where id=:employeeId");

        query.setParameter("employeeId", theId);

        query.executeUpdate();
    }
}
