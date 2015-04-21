package chzu.lujie.work.view.action;

import java.util.Date;
import java.util.List;






import org.apache.struts2.ServletActionContext;
import org.hibernate.classic.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Exercise;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.Subject;

import com.opensymphony.xwork2.ActionContext;

/**
 * 作业发布管理
 * 
 * @author jielu
 * 
 */
@Controller
@Scope("prototype")
public class ExerciseAction extends BaseAction<Exercise> {
	private Long subjectId;
	
	private Long charpterId;
	/**
	 * 显示
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showQuestion() throws Exception {
		Exercise exercise = exerciseService.getById(model.getEid());
		
		List<Questions> questionList = questionService.findQuestion(exercise);
		ActionContext.getContext().put("questionList", questionList);
		return "showQuestion";
	}

	public String delete() throws Exception {
		exerciseService.delete(model.getEid());
		return "toshow";
	}

	public String addUI() throws Exception {
		
		Subject subject = subjectService.getById(subjectId);
		
		 List<Charpter> charpterList = charpterService.findBySubject(subject);
		 ActionContext.getContext().put("charpterList", charpterList);
		return "saveUI";
	}

	public String add() throws Exception {
		
		Exercise exercise = new Exercise();
		exercise.setAuthor(getCurrentUser());
		exercise.setSubject(subjectService.getById(subjectId));
		exercise.setCharpter(charpterService.getById(charpterId));
		exercise.setName(model.getName());
		exercise.setStatu("0");
		exercise.setCurrentDate(new Date());
		exerciseService.save(exercise);

		return "toshow";
	}

	public String editUI() throws Exception {

		return "saveUI";
	}

	public String edit() throws Exception {

		
		return "toshow";
	}

	public String publish() throws Exception{	
		
		exerciseService.updateStatus(model.getEid());
		return "toshow";
	}
	
	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Long getCharpterId() {
		return charpterId;
	}

	public void setCharpterId(Long charpterId) {
		this.charpterId = charpterId;
	}

	

}
