package threadlocal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 

public class ThreadPol2 implements Runnable{
	private String name;
	public ThreadPol2(String name){
		this.name=name;
		
	}
	
	 
	public static void main(String[] args) {
		 // 获取当前程序运行时对象
       
         ExecutorService service = Executors.newFixedThreadPool(2);
     
 	     for (int i = 0; i < 10; i++) {
 	    	ThreadPol2 t=new ThreadPol2("线程"+i);
 	    	service.execute(t);
		}
 	     service.shutdown();
           
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(name+"：处理");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
