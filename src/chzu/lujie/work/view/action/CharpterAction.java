package chzu.lujie.work.view.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.KnowledgeDetail;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.util.QueryHelper;

/**
 * 章节管理
 * 
 * @author jielu
 * 
 */
@Controller
@Scope("prototype")
public class CharpterAction extends BaseAction<Charpter> {
	/**
	 * 显示课程列表
	 * 
	 * @return
	 * @throws Exception
	 */
	private Long subjectId;

	public String list() throws Exception {

		List<Subject> subjectlist = subjectService.findAll();
		//List<Subject> subjectlist = subjectService.findMySubject(getCurrentUser());
		ActionContext.getContext().put("subjectlist", subjectlist);
		return "list";
	}
	public String subjectlist() throws Exception {

		List<Subject> subjectlist = subjectService.findAll();
		//List<Subject> subjectlist = subjectService.findMySubject(getCurrentUser());
		ActionContext.getContext().put("subjectlist", subjectlist);
		return "subjectlist";
	}

	public String delete() throws Exception {

		charpterService.delete(model.getCid());
		return "toshow";
	}

	public String addUI() throws Exception {
		// 准备数据
		Subject subject = subjectService.getById(subjectId);
		ActionContext.getContext().put("subject", subject);
		return "saveUI";
	}

	public String add() throws Exception {

		// 表单中已经封装的有content，title
		model.setCname(model.getCname());
		model.setDescription(model.getDescription());
		model.setSubject(subjectService.getById(subjectId));

		charpterService.save(model);

		return "toshow";
	}

	public String editUI() throws Exception {
		// 准备数据
		Subject subject = subjectService.getById(subjectId);
		ActionContext.getContext().put("subject", subject);
		
		Charpter charpter = charpterService.getById(model.getCid());

		ActionContext.getContext().getValueStack().push(charpter);

		return "saveUI";
	}

	public String edit() throws Exception {
		
		Charpter charpter = charpterService.getById(model.getCid());
		
		charpter.setCname(model.getCname());
		charpter.setDescription(model.getDescription());
		charpter.setSubject(subjectService.getById(subjectId));

		charpterService.update(charpter);
		return "toshow";
	}

	public String showCharpterById() throws Exception {

		Charpter charpter = charpterService.getById(model.getCid());
		ActionContext.getContext().put("charpter", charpter);

		
		List<KnowledgeDetail> knowledgeList = knowledgeService.findByCharpter(charpter);
		ActionContext.getContext().put("knowledgeList", knowledgeList);
		return "showCharpterById";
	}
	
	public String showKnowledgeById() throws Exception {

		Charpter charpter = charpterService.getById(model.getCid());
		ActionContext.getContext().put("charpter", charpter);

		
		List<KnowledgeDetail> knowledgeList = knowledgeService.findByCharpter(charpter);
		ActionContext.getContext().put("knowledgeList", knowledgeList);
		return "showKnowledgeById";
	}
	
	public String showQuestionById() throws Exception {

//		Charpter charpter = charpterService.getById(model.getCid());
//		ActionContext.getContext().put("charpter", charpter);
//		
//		List<Questions> questionList = questionService.findByCharpter(charpter);
//		ActionContext.getContext().put("questionList", questionList);
		
		new QueryHelper(Questions.class, "s").addCondition("s.charpter.cid = ?", model.getCid()).preparePageBean(questionService, pageNum, pageSize);
		return "showQuestionById";
	}
	/**
	 * setter and getter
	 * 
	 * @return
	 */
	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

}
