package activemq.service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ssxt.com.zeng.service.UserService;
import ssxt.com.zeng.xml.User;

@Service(value="JmsTransaction")
public class JmsTransaction {

	
	@Autowired
	UserService userService;
	 
	@Autowired
	 JmsTemplate jmsTemplate;  
	
	@Autowired
    Destination destination;  
	
	
	@Transactional
	public void test(Message message){
	
		try {
			TextMessage tm = (TextMessage) message;
			System.out.println("QueueMessageListener监听到了文本消息 " + tm.getText());
			Thread current = Thread.currentThread();
			System.out.println("当前线程" + current);
		    User user = new User();
			user.setPassword("123456");
			user.setUsername("测试");
			userService.save(user);
			System.out.println(5/0);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new RuntimeException("我");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new RuntimeException("我");
		}
		
	 }
	
    @Transactional
	public void  receive() throws Exception{
		TextMessage tm = (TextMessage) jmsTemplate.receive();  
	    System.out.println("QueueMessageListener监听到了文本消息 " + tm.getText());
	    User user = new User();
		user.setPassword("123456");
		user.setUsername("测试2");
		userService.save(user);
		//throw  new RuntimeException("我");
	 }

}
