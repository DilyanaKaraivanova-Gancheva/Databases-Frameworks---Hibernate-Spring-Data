package auto.mapping.lab.repositories;

import auto.mapping.lab.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    List<Employee> findAllByBirthdayBeforeOrderBySalaryDesc(Date before);
}
