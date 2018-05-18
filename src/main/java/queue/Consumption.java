package queue;

 
 

public class Consumption extends Thread {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Consumption.class);
/*	private smsInfoDao smsInfoDao;	
	
	public Consumption(smsInfoDao smsInfoDao){
		this.smsInfoDao=smsInfoDao;
	}*/
	
	public void run() {
		// TODO Auto-generated method stub
		doScan();
	}

	private void doScan() {
		boolean isBoolean = true;
		while (isBoolean) {
			
			try{
			 SmsInfo sms = queue.que4httpOriginMsg.poll();
			if(sms!=null){
				log.info("执行方法"+sms.getMethodName());
				log.info("发送人"+sms.getName());
				log.info("号码"+sms.getPhone());
				log.info("内容"+sms.getMessage());
				log.info("其他信息"+sms.getRemarks());
			   // smsInfoDao.save(sms);
			 }else{
				log.info("没有生产无法消费");
			}
			}catch (Exception e){
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println("单位单位");
	}

}
