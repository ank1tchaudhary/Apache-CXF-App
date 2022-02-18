package te.cxf.DemoCXF.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import te.cxf.DemoCXF.domain.Employee;
import te.cxf.DemoCXF.repo.EmployeeRepo;

import java.util.List;

@Service("empSOAPService")
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String test() {
        return "SOAP WS";
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepo.deleteById(id);
        return "Employee No. : "+id+" deleted successfully.";
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeRepo.findAll();
    }
}
