package activemq.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ssxt.com.zeng.service.UserService;
import ssxt.com.zeng.xml.User;

public class QueueMessageListener implements MessageListener {

	 
	@Autowired
	JmsTransaction  jmsTransaction;

	@Autowired
	UserService userService;
	 
 
	public void onMessage(Message message){
		// TODO Auto-generated method stub
		
		jmsTransaction.test(message);
		 
	 }

	// 当收到消息后，自动调用该方法
	/*public void onMessage(Message message) {
		Thread current = Thread.currentThread();
		System.out.println("当前线程" + current);
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("QueueMessageListener监听到了文本消息 " + tm.getText());

			User user = new User();
			user.setPassword("123456");
			user.setUsername("测试");
			userService.save(user);
			
			 * if (1 == 1) { throw new RuntimeException("Error"); }
			 
			// do something ...
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}*/

}
