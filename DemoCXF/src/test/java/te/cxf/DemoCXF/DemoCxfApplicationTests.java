package te.cxf.DemoCXF;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import te.cxf.DemoCXF.client.Operations;
import te.cxf.DemoCXF.client.OperationsImplService;

@SpringBootTest
class DemoCxfApplicationTests {

	@Test
	void contextLoads() {
	}

//
//	@Test
//	void testcxfapp(){
//		OperationsImplService service = new OperationsImplService();
//		Operations operationsImplPort = service.getOperationsImplPort();
//		assertEquals(20,operationsImplPort.add(10,10));
//	}

}
