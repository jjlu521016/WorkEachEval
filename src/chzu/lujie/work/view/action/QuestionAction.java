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
		List<Subject> subjectlist = subjectService
				.findMySubject(getCurrentUser());
		ActionContext.getContext().put("subjectlist", subjectlist);

		// List<Subject> subjectlist = subjectService.findAll();
		// ActionContext.getContext().put("subjectlist", subjectlist);
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

	public String add() throws Exception {
		
		request = ServletActionContext.getRequest();
		// 把答案存放在一个list 中。
		String[] texts = request.getParameterValues("answerText");
		System.out.println("-------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+texts[0]);
		String sid = request.getParameter("sid");
		
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
			//处理选择题
			for (int i = texts.length - 1; i >= 0; i--) {
				if (!"".equals(texts[i])) {
					Answers answers = new Answers();
					if ("isRight".equals(texts[i])&&!"".equals(texts[--i])) {
						answers.setAnswer(texts[i]);
						answers.setIsRight("1");// mean this answer is right
						System.out.println("&&&&&&&&&&&&&---"+answers);
					} else {
						
						answers.setAnswer(texts[i]);
						answers.setIsRight("0");
						System.out.println("##################---"+answers);
					}
					answerList.add(answers);
				} 
			}
			break;
		case 2:
			//处理判断题
			String judge = request.getParameter("judgeAnswer");//如果单选按钮没有选 则这个变量为NULL
			System.out.println("=======================================================");
			Answers answers = new Answers();
			answers.setAnswer(judge);
			answers.setIsRight("1");
			answerList.add(answers);
			break;
		case 3:
			//处理普通答案
			if (ptAnswer != null && !"".equals(ptAnswer)) {
				Answers vo = new Answers();
				vo.setAnswer(ptAnswer);
				vo.setIsRight("1");
				answerList.add(vo);
			}
			break;
		default:
			break;
		}
		
//		System.out.println("answerList"+answerList.size());
		
		Set<Answers> aList = new HashSet<Answers>();
		int aLength = 0;
		if (answerList != null && !answerList.isEmpty()) {
			aLength = answerList.size();

		}
				if (answerList != null && aLength  != 0) {

					for (int i = 0; i < aLength; i++) {
						Answers po = new Answers();
						Answers vo = answerList.get(i);
						po.setAnswer(vo.getAnswer());
						po.setIsRight(vo.getIsRight());
						po.setQuestions(questions);
						po.setSequence(vo.getSequence());
						aList.add(po);
					}
				}
		Questions questions = new Questions();
		questions.setAnswerses(aList);
		questions.setCharpter(charpterService.getById(charpterId));
		questions.setSubject(subjectService.getById(subjectId));
		questions.setQtime(new Date());
		questions.setTypes(typesService.getById(typeId));
		questions.setQtext(model.getQtext());
		
		
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

}
