package ssxt.com.zeng.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.annotation.SystemControllerLog;
import common.dao.DataSourceHolder;
import common.exception.DataAccessException;
import common.page.PageControl;
import common.page.SqlBuffer;
import common.util.AccData;
import common.util.CtxHelper;
import common.util.CtxHelper1;
import common.util.EhcacheUtil;
import net.sf.ehcache.CacheManager;
import ssxt.com.jdbc.MyDataSource;
import ssxt.com.zeng.service.AopService;
import ssxt.com.zeng.service.CacheService;
import ssxt.com.zeng.service.DeptService;
import ssxt.com.zeng.service.EmpService;
import ssxt.com.zeng.service.UserService;
import ssxt.com.zeng.xml.Dept;
import ssxt.com.zeng.xml.Emp;
import ssxt.com.zeng.xml.Role;
import ssxt.com.zeng.xml.User;

@Controller
@RequestMapping(value = "/api/jdbc/")
public class jdbcContoller {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(jdbcContoller.class);

	@Resource
	private UserService userService;

	@Resource
	private DeptService deptService;

	@Resource
	private EmpService empService;
	
	@Resource
	private CacheService  cacheService ;
	
	@Resource
	private AopService  aopService ;


	
	@RequestMapping(value = "getConnection", method = RequestMethod.GET)
	@SystemControllerLog(description = "添加用户")     
	public void getConnection(HttpServletRequest request, HttpServletResponse response) throws Exception
        {
	        
		List list = null;
		AccData ad = CtxHelper1.createFailAccData();
		Connection   con=MyDataSource.getConnection();
	     System.out.println(con);
	    MyDataSource.release(con);
	     
		ad.setTotalCount(38);
		ad.setMsg("ddd");
		ad.setSuccess(true);
		
		CtxHelper1.writeToJson(response, ad);
	}
 
}
