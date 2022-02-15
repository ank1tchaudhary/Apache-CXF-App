package te.cxf.DemoCXF.demo;


import javax.jws.WebService;


public class OperationsImpl implements Operations{
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
