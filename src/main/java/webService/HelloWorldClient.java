package webService;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class HelloWorldClient {
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress("http://localhost:8080/myframe/webservice/HelloWorld?wsdl");
		factory.setServiceClass(HelloWorld.class);
		HelloWorld helloWorld = (HelloWorld) factory.create();
		List list=helloWorld.loadAll();
		System.out.println(list.size());
		// System.out.println("111");

	}
}
