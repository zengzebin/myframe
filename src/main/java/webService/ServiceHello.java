package webService;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class ServiceHello {

	public String getValue(String name) {
		return "你好" + name;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:8080/Service/ServiceHello",
				new ServiceHello());
		System.out.print("发布完成");
	}

}
