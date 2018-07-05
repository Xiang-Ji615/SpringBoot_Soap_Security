package main.java.spring.boot.soap.security.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="helloWorldService")
public interface IHelloWorldService {
	
	@WebMethod
	public String helloWorld(@WebParam String name);

}
