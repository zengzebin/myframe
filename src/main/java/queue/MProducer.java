package queue;

 

import java.text.SimpleDateFormat;
import java.util.Date;

 

public class MProducer  extends Thread{
	
	public void run() {
		// TODO Auto-generated method stub
		doProduce();
	}
	
	private void doProduce() {
		boolean autoProduceMoni=true;
		//while(autoProduceMoni){
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			String time= dateFormater.format(date);
			SmsInfo sms=new SmsInfo();
			sms.setError(1);
			sms.setPhone("15464");
			//sms.setSend("1");
			sms.setMessage(time);
			queue.que4httpOriginMsg.offer(sms);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sms=new SmsInfo();
			date=new Date();
			time=dateFormater.format(date);
			sms.setMessage(time);
			queue.que4httpOriginMsg.offer(sms);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sms=new SmsInfo();
			date=new Date();
			time=dateFormater.format(date);
			sms.setMessage(time);
			queue.que4httpOriginMsg.offer(sms);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sms=new SmsInfo();
			date=new Date();
			time=dateFormater.format(date);
			sms.setMessage(time);
			queue.que4httpOriginMsg.offer(sms);
			
		//}
		
	}
}
