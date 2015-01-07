package chzu.lujie.work.util;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.domain.Permission;
import chzu.lujie.work.domain.User;

@Component
public class InitInstaller {

	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();
		// 初始化超级管理员信息
		User user = new User();
		user.setLoginName("admin");
		user.setPassword(MD5Utils.GetMD5Code("admin"));
		session.save(user);

		// 初始化权限
		Permission menu, menu1, menu2, menu3, menu4;
		menu = new Permission("系统管理", null, null);

		menu1 = new Permission("角色管理", "role_list", menu);
		menu2 = new Permission("院系管理", "department_list", menu);
		menu3 = new Permission("用户管理", "user_list", menu);

		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);

		session.save(new Permission("角色列表", "role_list", menu1));
		session.save(new Permission("角色添加", "role_add", menu1));
		session.save(new Permission("角色删除", "role_delete", menu1));
		session.save(new Permission("角色修改", "role_edit", menu1));

		session.save(new Permission("院系列表", "department_list", menu2));
		session.save(new Permission("院系添加", "department_add", menu2));
		session.save(new Permission("院系删除", "department_delete", menu2));
		session.save(new Permission("院系修改", "department_edit", menu2));

		session.save(new Permission("用户列表", "user_list", menu3));
		session.save(new Permission("用户添加", "user_add", menu3));
		session.save(new Permission("用户删除", "user_delete", menu3));
		session.save(new Permission("用户修改", "user_edit", menu3));
		session.save(new Permission("初始化密码", "user_initPassword", menu3));

		// ------------------------------------------------------------
		// 论坛管理
		menu = new Permission("学习交流", null, null);
		menu1 = new Permission("论坛管理", "forumManage_list", menu);
		menu2 = new Permission("论坛", "forum_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		
		
		// 老师作业管理
		menu = new Permission("老师作业管理", null, null);
		menu1 = new Permission("知识点分析", "knowlegeManage_list", menu);
		menu2 = new Permission("布置作业", "giveHWork_list", menu);
		menu3 = new Permission("批改作业", "CrHWork_list", menu);
		menu4 = new Permission("成绩统计", "grade_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		
		session.save(new Permission("例题讲解", "question_list", menu1));
		session.save(new Permission("当前作业", "nowhomework_list", menu2));
		session.save(new Permission("历史作业", "historyhomework_list", menu2));
		
		// 学生作业管理
		menu = new Permission("我的任务管理", null, null);
		menu1 = new Permission("待批改的作业", "homework_list", menu);
		menu2 = new Permission("已完成的作业", "Fhomework_list", menu);
		menu3 = new Permission("未完成的作业", "TOhomework_list", menu);
		menu4 = new Permission("成绩管理", "grade_list", menu);
		
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
	}

	public static void main(String[] args) {
//
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		InitInstaller installer = (InitInstaller) ac.getBean("initInstaller");
		System.out.println("------>");
		installer.install();
	}
}
