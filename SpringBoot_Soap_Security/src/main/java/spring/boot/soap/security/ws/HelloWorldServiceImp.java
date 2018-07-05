package main.java.spring.boot.soap.security.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service
@WebService
public class HelloWorldServiceImp implements IHelloWorldService {

	@Override
	@WebMethod
	public String helloWorld(String name) {
		// TODO Auto-generated method stub
		return "Hello, "+name;
	}

}
