package webService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import ssxt.com.zeng.service.UserService;
import ssxt.com.zeng.xml.User;

@WebService(endpointInterface = "webService.HelloWorld", serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	@Resource
	private UserService userService;
	 
	Map<Integer, User> users = new LinkedHashMap<Integer, User>();

	public String sayHi(@WebParam(name = "text") String text) {
		
		return "Hello," + text;
	}

	public String sayHiToUser(User user) {
		users.put(users.size() + 1, user);
		return "Hello," + user.getUsername();
	}

	public String[] SayHiToUserList(List<User> userList) {
		String[] result = new String[userList.size()];
		int i = 0;
		for (User u : userList) {
			result[i] = "Hello " + u.getUsername();
			i++;
		}
		return result;
	}
	
	

	 
	public List<User> loadAll() {
		// TODO Auto-generated method stub
		//延迟加载不行所以不要延迟加载
		return userService.loadAll();
	}

	 

}
