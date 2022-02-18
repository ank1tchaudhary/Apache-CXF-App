package te.cxf.DemoCXF.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import te.cxf.DemoCXF.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
