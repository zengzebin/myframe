package activemq.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	
	  @Resource(name="jmsTemplate")
	    private JmsTemplate jmsTemplate;
	 
	     
	    /*  接收消息 
	      */
	    public TextMessage receive(Destination destination) {
	       Thread current = Thread.currentThread();  
	    	System.out.println("当前线程"+current.getName());
	        TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
	        try {
	            System.out.println("从队列" + destination.toString() + "收到了消息：\t"
	                    + tm.getText());
	            if (1 == 1) {  
                    throw new RuntimeException("Error");  
                }  
	        } catch (JMSException e) {
	            e.printStackTrace();
	        }
	        
	        return tm;
	        
	    } 
}
