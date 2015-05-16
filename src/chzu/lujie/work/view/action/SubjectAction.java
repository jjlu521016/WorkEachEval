package chzu.lujie.work.view.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.Exercise;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.domain.Types;
import chzu.lujie.work.util.QueryHelper;

@Controller
@Scope("prototype")
public class SubjectAction extends BaseAction<Subject> {
	
	private InputStream inputStream;

	public String list() throws Exception {

		// List<Subject> subjectList = subjectService.findAll();
		// ActionContext.getContext().put("subjectList", subjectList);
		// 分页显示
		new QueryHelper(Subject.class, "s").preparePageBean(subjectService, pageNum, pageSize);
		return "list";
	}

	public String delete() throws Exception {
		subjectService.delete(model.getSid());
		return "tolist";
	}

	public String add() throws Exception {
		model.setAuthor(getCurrentUser());
		subjectService.save(model);
		return "tolist";

	}

	public String addUI() throws Exception {

		return "saveUI";
	}

	public String edit() throws Exception {
		// 从数据库中取对象
		Subject subject = subjectService.getById(model.getSid());

		// 设置修改的属性
		subject.setSname(model.getSubject_code());
		subject.setSname(model.getSname());
		subject.setAuthor(getCurrentUser());
		subject.setDescription(model.getDescription());
		// 更新到数据库
		subjectService.save(subject);
		return "tolist";
	}

	public String editUI() throws Exception {

		Subject subject = subjectService.getById(model.getSid());
		ActionContext.getContext().getValueStack().push(subject);
		return "saveUI";
	}

	public String showsubjectById() throws Exception {

		Subject subject = subjectService.getById(model.getSid());
		ActionContext.getContext().put("subject", subject);

		List<Charpter> charpterList = charpterService.findBySubject(subject);
		ActionContext.getContext().put("charpterList", charpterList);
		return "showsubjectById";
	}

	// gen
	public String showexerciseById() throws Exception {

		Subject subject = subjectService.getById(model.getSid());
		ActionContext.getContext().put("subject", subject);

		List<Exercise> exerciseList = exerciseService.findAll();// findMyExercise(getCurrentUser());
		ActionContext.getContext().put("exerciseList", exerciseList);
		return "showexerciseById";
	}
	
	// gen
	public String showExamById() throws Exception {

		Subject subject = subjectService.getById(model.getSid());
		ActionContext.getContext().put("subject", subject);

		List<Exam> examList = examService.getBysubject(subject);//findAll();// findMyExercise(getCurrentUser());
		ActionContext.getContext().put("examList",examList);
		return "showExamById";
	}

	public String showquestionById() throws Exception {

		Subject subject = subjectService.getById(model.getSid());
		ActionContext.getContext().put("subject", subject);

		List<Charpter> charpterList = charpterService.findBySubject(subject);
		ActionContext.getContext().put("charpterList", charpterList);
		return "showquestionById";
	}
	
	public String check() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String scode=request.getParameter("scode");
		if(subjectService.checkScode(scode)){
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8")); 
			System.out.println("11");
		} else {
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8")); 
			System.out.println("00");
			
		}
		
		return "ajax-success";
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
}
