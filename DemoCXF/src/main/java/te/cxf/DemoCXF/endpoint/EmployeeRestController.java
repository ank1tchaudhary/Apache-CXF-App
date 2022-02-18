package te.cxf.DemoCXF.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import te.cxf.DemoCXF.domain.Employee;
import te.cxf.DemoCXF.repo.EmployeeRepo;
import te.cxf.DemoCXF.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    @Qualifier("empSOAPService")
    private EmployeeService employeeService;

    @GetMapping("/test")
    public String test(){
        return employeeService.test();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeRequest(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public Employee createEmployeeRequest(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PatchMapping
    public Employee updateEmployeeRequest(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeRequest(@PathVariable int id)
    {
         employeeService.deleteEmployee(id);
    }

    @GetMapping
    public List<Employee> listAllEmployeeRequest(){
        return employeeService.listEmployee();
    }
}
