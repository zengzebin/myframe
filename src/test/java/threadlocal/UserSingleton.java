package threadlocal;

public class UserSingleton {
	private static   User user=null;
	 
	public static  User getUser(){
	  if(user ==null){
			  user = new  User();
	    }
		return user;
	}

}
