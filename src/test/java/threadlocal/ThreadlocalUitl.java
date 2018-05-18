package threadlocal;

public class ThreadlocalUitl {
	/*private final static ThreadLocal<User> threadLocal = new ThreadLocal<User>();
	
	public  static User getUser(){
		User user=threadLocal.get();
		if(user ==null){
			  user = new  User();
			threadLocal.set(user);
		}
		return user;
	}*/
	
	private static   User user=null;
	 
	public static  User getUser(){
	  if(user ==null){
			  user = new  User();
	    }
		return user;
	}
	
}
