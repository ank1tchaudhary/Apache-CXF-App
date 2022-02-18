package te.cxf.DemoCXF.service;

import org.springframework.transaction.annotation.Transactional;
import te.cxf.DemoCXF.domain.Employee;

import javax.jws.*;
import java.util.List;

@WebService
@Transactional
public interface EmployeeService {

    @WebMethod
    public String test();

    @WebMethod
    public Employee createEmployee(Employee employee);

    @WebMethod
    public Employee getEmployee(int id);

    @WebMethod
    public Employee updateEmployee(Employee employee);

    @WebMethod
    public String deleteEmployee(int id);

    @WebMethod
    public List<Employee> listEmployee();

}
