package te.cxf.DemoCXF.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import te.cxf.DemoCXF.domain.Employee;
import te.cxf.DemoCXF.service.EmployeeService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "EmployeeServices")
@RestController
public class EmployeeRestController {

    @Autowired
    @Qualifier("empService")
    private EmployeeService employeeService;


    @ApiOperation(value = "Get Employee By Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeRequest(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @ApiOperation(value = "Create Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping("/createEmployee")
    public ResponseEntity<Employee> createEmployeeRequest(@Valid @RequestBody Employee employee){
        Employee emp = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(emp);
    }

    @ApiOperation(value = "Update Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PatchMapping("/updateEmployee")
    public ResponseEntity updateEmployeeRequest(@Valid @RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @ApiOperation(value = "Delete Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity deleteEmployeeRequest(@PathVariable int id)
    {
         employeeService.deleteEmployee(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @ApiOperation(value = "List Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/listEmployee")
    public ResponseEntity<List<Employee>> listAllEmployeeRequest(){
        List<Employee> employees = employeeService.listEmployee();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }
}
