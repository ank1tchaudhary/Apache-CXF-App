package te.cxf;

import te.cxf.demo.Operations;
import te.cxf.demo.OperationsImplService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        OperationsImplService service= new OperationsImplService();
        Operations operationsImplPort = service.getOperationsImplPort();
        System.out.println("add(10,10) : "+operationsImplPort.add(10, 10));
    }
}
