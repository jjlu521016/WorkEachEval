package chzu.lujie.work.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import chzu.lujie.work.domain.User;
import chzu.lujie.work.service.CharpterService;
import chzu.lujie.work.service.DepartmentService;
import chzu.lujie.work.service.ExamPaperService;
import chzu.lujie.work.service.ExamService;
import chzu.lujie.work.service.ExerciseService;
import chzu.lujie.work.service.ForumService;
import chzu.lujie.work.service.KnowledgeAnalyService;
import chzu.lujie.work.service.KnowledgeService;
import chzu.lujie.work.service.PermissionService;
import chzu.lujie.work.service.QuestionService;
import chzu.lujie.work.service.QuestiontaskerService;
import chzu.lujie.work.service.ReplyService;
import chzu.lujie.work.service.RoleService;
import chzu.lujie.work.service.ScoreService;
import chzu.lujie.work.service.StudentQuestionRecordService;
import chzu.lujie.work.service.SubjectService;
import chzu.lujie.work.service.TaskService;
import chzu.lujie.work.service.TaskerpaperService;
import chzu.lujie.work.service.TeacherService;
import chzu.lujie.work.service.TopicService;
import chzu.lujie.work.service.TypesService;
import chzu.lujie.work.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	public T model;
	
	public BaseAction(){
		try{
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			
			//通过反射获取model的真实类型
			Class<T> clazz =(Class<T>) pt.getActualTypeArguments()[0];
			//通过反射创建model的真实类型
			model = clazz.newInstance();
		}
		catch (Exception e){
			throw new RuntimeException(e);
			
		}
		
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}
@Resource	
protected RoleService roleService;

@Resource
protected DepartmentService departmentService;

@Resource
protected UserService userService; 

@Resource
protected TeacherService teacherService;
@Resource
protected PermissionService permissionService;

@Resource
protected ForumService forumService;

@Resource
protected TopicService topicService;

@Resource
protected ReplyService replyService;

@Resource
protected KnowledgeAnalyService knowledgeAnalyService;

@Resource
protected SubjectService subjectService;

@Resource
protected CharpterService charpterService; 

@Resource
protected KnowledgeService knowledgeService ; 

@Resource
protected TypesService typesService;

@Resource
protected QuestionService questionService;

@Resource
protected ExerciseService exerciseService;

@Resource
protected ExamService examService; 

@Resource
protected ExamPaperService examPaperService;

@Resource
protected StudentQuestionRecordService recordService;

@Resource
protected TaskService taskService;

@Resource
protected ScoreService scoreService;

@Resource
protected QuestiontaskerService questiontaskerService;

@Resource
protected TaskerpaperService taskerpaperService; 
/**
 * 其他一些常用的变量
 */

/**
 * 获取当前用户
 */

protected User getCurrentUser(){
	return (User) ActionContext.getContext().getSession().get("user");
}

//分页相关

protected int pageNum =1;
protected int pageSize =10;
public int getPageNum() {
	return pageNum;
}

public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
}
