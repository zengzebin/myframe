package Redis;
import java.text.DateFormat;
import java.text.ParsePosition;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.Calendar;  
import java.util.Date;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
public class ClientThread extends Thread {  
  
    int i = 0;  
  
    public ClientThread(int i) {  
        this.i = i;  
    }  
  
    public void run() {  
    	JedisUtilSynchronized.poolInit();
        Date date = new Date();  
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String time = format.format(date);  
        JedisUtilSynchronized.setString("foo", time);  
        String foo = JedisUtilSynchronized.getString("foo");        
        System.out.println("【输出>>>>】foo:" + foo + " 第："+i+"个线程" +"当前时间："+new Date());  
    }  
    
    public static void main(String[] args) {                
        for (int i = 0; i < 10; i++) {            
            ClientThread t = new ClientThread(i);  
            t.start();  
        }  
    }  


}
