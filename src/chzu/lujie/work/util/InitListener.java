package chzu.lujie.work.util;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import chzu.lujie.work.domain.Permission;
import chzu.lujie.work.service.PermissionService;
import javax.servlet.ServletContextListener;
//ServletContextListener 使用的是tomcat..../lib下的servlet-api.jar
public class InitListener implements ServletContextListener {

	
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("----init--hhhhhhhhhhhhhhhhhhhhhhhhhhh-");
		// 获取容器与相关的Service对象
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		PermissionService permissionService = (PermissionService) ac.getBean("permissionServiceImpl");
		// 准备数据：topPrivilegeList
		List<Permission> topPermissionList = permissionService.findTopList();
		sce.getServletContext().setAttribute("topPermissionList", topPermissionList);
		
		
		System.out.println("-lujie-----test----toppermissionList----");

		// 准备数据：allPrivilegeUrls
		Collection<String> allPermissionUrls = permissionService.getAllPermissionUrls();
		sce.getServletContext().setAttribute("allPermissionUrls", allPermissionUrls);
		System.out.println("-lujie-----test--allPermissionUrls-----");
	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}
}
