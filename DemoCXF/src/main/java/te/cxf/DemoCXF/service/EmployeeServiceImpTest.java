package te.cxf.DemoCXF.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import te.cxf.DemoCXF.domain.Employee;
import te.cxf.DemoCXF.repo.EmployeeRepo;

import java.util.Arrays;
import java.util.List;

@Service("employeeTest")
public class EmployeeServiceImpTest implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String test() {
        return "Just a test";
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employee;
    }

    @Override
    public Employee getEmployee(int id) {
        return Employee.builder().id(id).name("Ankit").dept("Test").salary(10000).build();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
    }

    @Override
    public List<Employee> listEmployee() {
        return Arrays.asList(Employee.builder().id(1).name("Ankit").dept("Test").salary(10000).build());
    }
}
