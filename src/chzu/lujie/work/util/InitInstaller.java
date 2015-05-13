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
		Permission menu, menu1, menu2, menu3, menu4,menu5,menu6;
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
		
		//20150513------------------------
		session.save(new Permission("论坛列表", "forumManage_list", menu1));
		session.save(new Permission("添加版块", "forumManage_addUI", menu1));
		session.save(new Permission("删除版块", "forumManage_delete", menu1));
		session.save(new Permission("修改版块", "forumManage_editUI", menu1));
		session.save(new Permission("上移版块", "forumManage_moveUp", menu1));
		session.save(new Permission("下移版块", "forumManage_moveDown", menu1));
		//论坛
		session.save(new Permission("版块列表", "forum_list", menu2));
		session.save(new Permission("主题列表", "forum_show", menu2));
		session.save(new Permission("发帖",   "topic_addUI", menu2));
		session.save(new Permission("显示主题", "topic_show", menu2));
		session.save(new Permission("下移版块", "forumManage_moveDown", menu1));
		
		////////////////////////20150513

		// 老师作业管理
		menu = new Permission("老师作业管理", null, null);
		menu1 = new Permission("课程管理", "subject_list", menu);
		menu2 = new Permission("知识点分析", "charpter_list", menu);
		menu3 = new Permission("布置作业", "exam_showSubject", menu);
		menu4 = new Permission("作业题目管理", "question_list", menu);
		menu5 = new Permission("成绩管理", "score_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);

		session.save(new Permission("课程列表", "subject_list", menu1));
		session.save(new Permission("添加课程", "subject_addUI", menu1));
		session.save(new Permission("删除课程", "subject_delete", menu1));
		session.save(new Permission("修改课程", "subject_editUI", menu1));
		
		session.save(new Permission("知识点分析", "charpter_list", menu2));
		session.save(new Permission("课程列表", "subject_showsubjectById", menu2));
		session.save(new Permission("添加章节", "charpter_addUI", menu2));
		session.save(new Permission("删除章节", "charpter_delete", menu2));
		session.save(new Permission("修改章节", "charpter_editUI", menu2));
		session.save(new Permission("显示知识点", "charpter_showCharpterById", menu2));
		session.save(new Permission("添加知识点", "knowledge_addUI", menu2));
		session.save(new Permission("删除知识点", "knowledge_delete", menu2));
		session.save(new Permission("修改知识点", "knowledge_editUI", menu2));
		
		session.save(new Permission("课程列表", "exam_showSubject", menu3));
		session.save(new Permission("作业列表", "subject_showExamById", menu3));
		session.save(new Permission("添加作业", "exam_addUI", menu3));
		session.save(new Permission("删除作业", "exam_delete", menu3));
		session.save(new Permission("修改作业", "exam_editUI", menu3));
		session.save(new Permission("发布作业", "exam_publish", menu3));
		
		session.save(new Permission("显示章节", "subject_showquestion", menu4));
		session.save(new Permission("问题列表", "charpter_showQuestionById", menu4));
		session.save(new Permission("添加题目", "question_addUI", menu4));
		session.save(new Permission("删除题目", "question_delete", menu4));
		session.save(new Permission("修改题目", "question_editUI", menu4));
		
		session.save(new Permission("成绩列表", "score_list", menu5));
		session.save(new Permission("查询成绩数据", "score_querylistUI", menu5));

		
		// 学生作业管理
		menu = new Permission("我的任务管理", null, null);
		menu1 = new Permission("接收作业", "exam_list", menu);
		menu2 = new Permission("待批改的作业", "task_list", menu);
		menu3 = new Permission("已批改的作业", "task_finish", menu);
		menu4 = new Permission("未完成的作业", "examPaper_list", menu);
		menu5 = new Permission("已完成的作业", "examPaper_finish", menu);
		menu6 = new Permission("成绩管理", "score_studentlist", menu);

		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);
		session.save(menu6);
		
		session.save(new Permission("接收列表", "exam_list", menu1));
		session.save(new Permission("生成作业", "exam_createPaper", menu1));
		
		session.save(new Permission("待批改的作业", "task_list", menu2));
		session.save(new Permission("批改作业", "task_getQuestion", menu2));
		
		session.save(new Permission("已批改的作业", "task_finish", menu3));
		
		session.save(new Permission("未完成作业列表", "examPaper_list", menu4));
		session.save(new Permission("做作业", "examPaper_doQuestion", menu4));
		
		session.save(new Permission("已完成作业列表", "examPaper_finish", menu5));
		
		session.save(new Permission("成绩列表", "score_studentlist", menu6));
		session.save(new Permission("查询数据", "score_querylistUI", menu6));
		
		
	}

	public static void main(String[] args) {
		//
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		InitInstaller installer = (InitInstaller) ac.getBean("initInstaller");
		System.out.println("------>");
		installer.install();
	}
}
