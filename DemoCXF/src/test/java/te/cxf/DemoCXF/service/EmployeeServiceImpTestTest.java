package te.cxf.DemoCXF.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import te.cxf.DemoCXF.domain.Employee;
import te.cxf.DemoCXF.repo.EmployeeRepo;
import te.cxf.DemoCXF.service.EmployeeService;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeServiceImpTestTest {

    @Autowired
    @Qualifier("empService")
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepo employeeRepo;

    @Test
    void createEmployee() {
        Employee aamir= Employee.builder().id(3).name("aamir").dept("Dept3").salary(20000).build();

        when(employeeRepo.save(aamir)).thenReturn(aamir);

        assertEquals(aamir,employeeService.createEmployee(aamir));
    }

    @Test
    void getEmployee() {
        Employee ankit= Employee.builder().id(1).name("Ankit").dept("Dept1").salary(10000).build();
        Employee rahul= Employee.builder().id(2).name("Rahul").dept("Dept2").salary(20000).build();
        Employee aamir= Employee.builder().id(3).name("aamir").dept("Dept3").salary(20000).build();
        Employee anuj= Employee.builder().id(4).name("anuj").dept("Dept4").salary(10000).build();

        int empId= 4;

        when(employeeRepo.findById(empId))
                .thenReturn(Arrays.asList(ankit,rahul,aamir,anuj).stream().filter(e -> e.getId() == empId).findFirst());

        assertEquals("anuj",employeeService.getEmployee(empId).getName());
    }

    @Test
    void updateEmployee() {
        Employee ankit= Employee.builder().id(1).name("Ankit").dept("Dept1").salary(10).build();

        when(employeeRepo.save(ankit)).thenReturn(ankit);

        assertEquals(10,employeeService.updateEmployee(ankit).getSalary());
    }

    @Test
    void deleteEmployee() {
        Employee ankit= Employee.builder().id(1).name("Ankit").dept("Dept1").salary(10000).build();

        employeeRepo.delete(ankit);

        verify(employeeRepo,times(1)).delete(ankit);
    }

    @Test
    void listEmployee() {
        Employee ankit= Employee.builder().id(1).name("Ankit").dept("Dept1").salary(10000).build();
        Employee rahul= Employee.builder().id(2).name("Rahul").dept("Dept2").salary(20000).build();
        Employee aamir= Employee.builder().id(3).name("aamir").dept("Dept3").salary(20000).build();
        Employee anuj= Employee.builder().id(4).name("anuj").dept("Dept4").salary(10000).build();

        when(employeeRepo.findAll())
                .thenReturn(Arrays.asList(ankit,rahul,aamir,anuj));

        assertEquals(4,employeeService.listEmployee().size());
    }
}