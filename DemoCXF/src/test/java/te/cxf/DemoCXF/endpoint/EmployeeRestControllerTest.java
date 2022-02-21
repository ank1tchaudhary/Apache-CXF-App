package te.cxf.DemoCXF.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import te.cxf.DemoCXF.domain.Employee;
import te.cxf.DemoCXF.service.EmployeeService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeRestController.class)
class EmployeeRestControllerTest {

   private MockMvc mockMvc;

   @MockBean
   @Qualifier("empService")
   private EmployeeService employeeService;

   @Autowired
   private EmployeeRestController controller;

   private ObjectMapper mapper = new ObjectMapper();

   @Autowired
   private WebApplicationContext context;

    @BeforeEach
    void setUp() {
     mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("GET : /getEmployeeById")
    void testGetEmployeeRequest() throws Exception {
        Employee output= Employee.builder().id(1).name("Ankit").dept("Dept1").salary(10000).build();
        when(employeeService.getEmployee(1)).thenReturn(output);
        mockMvc.perform(get("/getEmployeeById/"+1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        assertEquals(HttpStatus.OK,controller.getEmployeeRequest(1).getStatusCode());
        assertEquals("Ankit",controller.getEmployeeRequest(1).getBody().getName());
    }

    @Test
    @DisplayName("POST : /createEmployee")
    void testCreateEmployeeRequest() throws Exception {
     Employee ankit= Employee.builder().name("Ankit").dept("Dept1").salary(10000).dob("10-10-2020").email("ankit@gmail.com").phone(3456789109L).build();
     Employee output= Employee.builder().id(1).name("Ankit").dept("Dept1").salary(10000).dob("10-10-2020").email("ankit@gmail.com").phone(3456789109L).build();

     when(employeeService.createEmployee(ankit)).thenReturn(output);

     String jsonRequest = mapper.writeValueAsString(ankit);

     mockMvc.perform(post("/createEmployee")
             .content(jsonRequest)
             .contentType(MediaType.APPLICATION_JSON))
             .andExpect(status().isCreated())
             .andExpect(content().contentType(MediaType.APPLICATION_JSON));

     assertEquals(HttpStatus.CREATED,controller.createEmployeeRequest(ankit).getStatusCode());
     assertEquals(output,controller.createEmployeeRequest(ankit).getBody());
    }

    @Test
    @DisplayName("PATCH : /updateEmployee")
    void testUpdateEmployeeRequest() throws Exception {
        Employee ankit= Employee.builder().id(1).name("Ankit").dept("Dept1").salary(10000).dob("10-10-2020").email("ankit@gmail.com").phone(3456789109L).build();

        when(employeeService.updateEmployee(ankit)).thenReturn(ankit);

        String jsonRequest = mapper.writeValueAsString(ankit);

        mockMvc.perform(patch("/updateEmployee")
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(employeeService,times(1)).updateEmployee(ankit);
        assertEquals(HttpStatus.NO_CONTENT,controller.updateEmployeeRequest(ankit).getStatusCode());
    }

    @Test
    @DisplayName("DELETE : /deleteEmployee")
    void testDeleteEmployeeRequest() throws Exception {
        mockMvc.perform(delete("/deleteEmployee/"+1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(employeeService,times(1)).deleteEmployee(1);
        assertEquals(HttpStatus.NO_CONTENT,controller.deleteEmployeeRequest(1).getStatusCode());

    }

    @Test
    @DisplayName("GET : /listEmployee")
    void testListAllEmployeeRequest() throws Exception {
        Employee ankit= Employee.builder().id(1).name("Ankit").dept("Dept1").salary(10000).build();
        Employee rahul= Employee.builder().id(2).name("Rahul").dept("Dept2").salary(20000).build();
        Employee aamir= Employee.builder().id(3).name("aamir").dept("Dept3").salary(20000).build();
        Employee anuj= Employee.builder().id(4).name("anuj").dept("Dept4").salary(10000).build();

        when(employeeService.listEmployee()).thenReturn(Arrays.asList(ankit,rahul,aamir,anuj));

        mockMvc.perform(get("/listEmployee")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());

        assertEquals(HttpStatus.OK,controller.listAllEmployeeRequest().getStatusCode());
        assertEquals(4,controller.listAllEmployeeRequest().getBody().size());

    }
}