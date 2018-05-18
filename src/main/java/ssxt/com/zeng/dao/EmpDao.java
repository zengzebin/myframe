package ssxt.com.zeng.dao;

 
import java.util.List;

import org.springframework.stereotype.Repository;

import common.dao.GenericDaoImpl;
import common.page.SqlCondGroup;
import ssxt.com.zeng.xml.Emp;
import ssxt.com.zeng.xml.User;
@Repository(value = "empDao")
public class EmpDao  extends GenericDaoImpl<Emp, Integer>{

	public void commonConList(List<SqlCondGroup> conList, Emp bean) {
		// TODO Auto-generated method stub
		
	} 

}
