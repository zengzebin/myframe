package ssxt.com.zeng.dao;

 
import java.util.List;

import org.springframework.stereotype.Repository;

import common.dao.GenericDaoImpl;
import common.page.SqlCondGroup;
import ssxt.com.zeng.xml.Dept;
import ssxt.com.zeng.xml.User;
@Repository(value = "deptDao")
public class DeptDao  extends GenericDaoImpl<Dept, Integer>{

	public void commonConList(List<SqlCondGroup> conList, Dept bean) {
		// TODO Auto-generated method stub
		
	} 

}
