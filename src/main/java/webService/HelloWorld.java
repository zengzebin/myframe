package webService;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import ssxt.com.zeng.xml.User;

@WebService
public interface HelloWorld {
	String sayHi(@WebParam(name="text")String text);  
    String sayHiToUser(User user);  
    String[] SayHiToUserList(List<User> userList);  
    
    public List<User>   loadAll();
}
