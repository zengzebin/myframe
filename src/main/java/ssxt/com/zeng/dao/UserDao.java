package ssxt.com.zeng.dao;

 
import java.util.List;

import org.springframework.stereotype.Repository;

import common.dao.GenericDaoImpl;
import common.page.SqlCondGroup;
import ssxt.com.zeng.xml.User;
@Repository(value = "userDao")
public class UserDao  extends GenericDaoImpl<User, Integer>{

	public void commonConList(List<SqlCondGroup> conList, User bean) {
		// TODO Auto-generated method stub
		
	} 

}
