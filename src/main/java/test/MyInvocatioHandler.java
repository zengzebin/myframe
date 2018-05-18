package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocatioHandler implements InvocationHandler {

	 private Object target;
	
	
	  public MyInvocatioHandler(Object target) {
	        this.target = target;
	    }
	 
	public Object invoke(Object arg0, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		    System.out.println("-----before-----");
	        Object result = method.invoke(target, args);
	        System.out.println("-----end-----");
	        return result;
	 
	}
	
	
	  public Object getProxy() {
	        ClassLoader loader = Thread.currentThread().getContextClassLoader();
	        Class<?>[] interfaces = target.getClass().getInterfaces();
	        return Proxy.newProxyInstance(loader, interfaces, this);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject service=new Proxy1();
	    MyInvocatioHandler handler = new MyInvocatioHandler(service);
	    Subject serviceProxy = (Subject)handler.getProxy();
	   System.out.println(serviceProxy.show());
	}

}
