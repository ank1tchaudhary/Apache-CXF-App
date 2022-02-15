package te.cxf.DemoCXF.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import te.cxf.DemoCXF.demo.OperationsImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint= new EndpointImpl(bus,new OperationsImpl());
        endpoint.publish("/op");
        return endpoint;
    }
}
