package queue;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ssxt.com.zeng.controller.UserContoller;

 

public class ListenerQueue implements ServletContextListener {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ListenerQueue.class);

	private WebApplicationContext springContext;
	//private ErrReportDao errReportDao;	

	public void contextInitialized(ServletContextEvent sce) {
		springContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		/*if (springContext != null) {
			errReportDao = (ErrReportDao) springContext.getBean("errReportDao");
		} else {
			System.out.println("获取应用程序上下文失败!");
			return;
		}*/
		//queue.Consumption(errReportDao);
		 log.info("开启队列");
		 Thread t=new Consumption();
		 t.run();
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}