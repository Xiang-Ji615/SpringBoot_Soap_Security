package main.java.spring.boot.soap.security.ws;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@WebService
public class HelloWorldServiceImp implements IHelloWorldService {
	
	@Resource
	WebServiceContext context;

	@Override
	@WebMethod(operationName = "hello")
	public String helloWorld(@WebParam(name="name") String name) throws IOException {
		// TODO Auto-generated method stub
		HttpServletResponse response = (HttpServletResponse)context.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
//		context.getMessageContext()
//	     .put(MessageContext.HTTP_RESPONSE_CODE, HttpStatus.UNAUTHORIZED);
		 response.sendError(401, "Not authorized");
//         throw new RuntimeException("Not authorized");
		 return "";
	}
	
	@WebMethod(operationName = "testCode")
    public String testCode(@WebParam(name = "code") int code) {
        if (code < 200 || code > 299) {
            try {
                MessageContext ctx = context.getMessageContext();
                HttpServletResponse response = (HttpServletResponse) 
                        ctx.get(MessageContext.SERVLET_RESPONSE);
                response.sendError(code, code + " You want it!");
            } catch (IOException e) {
              
            }
        }
        return code + " Everything is fine!";
    }

}
