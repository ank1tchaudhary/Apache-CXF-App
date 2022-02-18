package te.cxf.DemoCXF.endpoint;

import org.springframework.beans.factory.annotation.*;
import te.cxf.DemoCXF.domain.Employee;
import te.cxf.DemoCXF.service.EmployeeService;

import java.util.List;

public class EmployeeEndpoint {

    @Autowired
    @Qualifier("employeeTest")
    private EmployeeService employeeService;

    public String test(){
        return employeeService.test();
    }

    public Employee getEmployeeRequest(int id){
        return employeeService.getEmployee(id);
    }

    public Employee createEmployeeRequest(Employee employee){
       return employeeService.createEmployee(employee);
    }

    public Employee updateEmployeeRequest(Employee employee){
       return employeeService.updateEmployee(employee);
    }

    public String deleteEmployeeRequest(int id)
    { return employeeService.deleteEmployee(id); }

    public List<Employee> listAllEmployeeRequest(){
       return employeeService.listEmployee();
    }

}
