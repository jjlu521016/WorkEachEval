package chzu.lujie.work.view.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Answers;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.KnowledgeDetail;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.domain.Types;
import chzu.lujie.work.util.QueryHelper;

/**
 * 章节管理
 * 
 * @author jielu
 * 
 */
@Controller
@Scope("prototype")
public class QuestionAction extends BaseAction<Questions> {
	private HttpServletRequest request;
	private Long subjectId;
	private Long charpterId;
	private Long typeId;
	private Long exerciseId;
	
	 Questions questions = new Questions();
	 
	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	/**
	 * 显示问题
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
//		List<Subject> subjectlist = subjectService
//				.findMySubject(getCurrentUser());
//		ActionContext.getContext().put("subjectlist", subjectlist);

//		new QueryHelper(Questions.class, "s").preparePageBean(questionService, pageNum, pageSize);
		 List<Subject> subjectlist = subjectService.findAll();
		 ActionContext.getContext().put("subjectlist", subjectlist);
		return "list";
	}

	public String delete() throws Exception {
		// 根据id删除数据
		questionService.delete(model.getQid());
		return "toshow";
	}

	public String addUI() throws Exception {
		// 准备数据
		 Subject subject = subjectService.getById(subjectId);
		 ActionContext.getContext().put("subject", subject);
		 
		 Charpter charpter = charpterService.getById(charpterId);
		 ActionContext.getContext().put("charpter", charpter);
		 
		 List<Types> typeList = typesService.findAll();
		 
		 ActionContext.getContext().put("typeList", typeList);
		 
		return "saveUI";
	}
/**
 * 本方法的 V4版本
 * @return
 * @throws Exception
 */
	public String add() throws Exception {
		
		request = ServletActionContext.getRequest();
		
		
		String qAnswer = request.getParameter("qAnswer");
		String ptAnswer = request.getParameter("ptAnswer");
		List<Answers> answerList = new ArrayList<Answers>();
		
		/*添加一个FLG位，
		1表示选择
		2表示判断
		3表示普通答案
		4表示高级答案*/
		int flg =Integer.parseInt( request.getParameter("typeId"));
		System.out.println("<><><><<><<<<><<<><>><><><<><><><><><>>"+flg);
		switch (flg) {
		case 1:
			//由于选择题的相关内容到封装好了，所以此处不需要任何语句
			break;
		case 2:
			//处理判断题
			String judge = request.getParameter("judgeAnswer");//如果单选按钮没有选 则这个变量为NULL
			System.out.println("=======================================================");
			Answers answers = new Answers();
			answers.setAnswer(judge);
			answers.setIsRight("1");
			answerList.add(answers);
			
			questions.setAnswerses(answerList);
			
			break;
		case 3:
			//处理普通答案
			if (ptAnswer != null && !"".equals(ptAnswer)) {
				Answers vo = new Answers();
				vo.setAnswer(ptAnswer);
				vo.setIsRight("1");
				answerList.add(vo);
				
				questions.setAnswerses(answerList);
			}
			break;
		default:
			break;
		}
		
		
		
		questions.setCharpter(charpterService.getById(charpterId));
		questions.setSubject(subjectService.getById(subjectId));
		questions.setQtime(new Date());
		questions.setTypes(typesService.getById(typeId));
		questions.setQtext(model.getQtext());
		questions.setExercise(exerciseService.getById(exerciseId));
		questions.setQscore(model.getQscore());
		questionService.save(questions);

		return "toshow";
	}

	public String editUI() throws Exception {
		// 准备数据
		// Subject subject = subjectService.getById(subjectId);
		// ActionContext.getContext().put("subject", subject);
		//
		// Charpter charpter = charpterService.getById(model.getCid());
		//
		// ActionContext.getContext().getValueStack().push(charpter);
		// ActionContext.getContext().put("charpter", charpter);

		return "saveUI";
	}

	public String edit() throws Exception {

		// Charpter charpter = charpterService.getById(model.getCid());
		//
		// charpter.setCname(model.getCname());
		// charpter.setDescription(model.getDescription());
		// charpter.setSubject(subjectService.getById(subjectId));

		// charpterService.update(charpter);
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

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(Long exerciseId) {
		this.exerciseId = exerciseId;
	}

}
