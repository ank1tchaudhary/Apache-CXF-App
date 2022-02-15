package te.cxf.DemoCXF.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Operations {

    @WebMethod
    public int add(int a,int b);
}
