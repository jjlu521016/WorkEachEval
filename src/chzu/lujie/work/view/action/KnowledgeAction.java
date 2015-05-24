package chzu.lujie.work.view.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Forum;
import chzu.lujie.work.domain.KnowledgeDetail;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.domain.User;

/**
 * 章节管理
 * 
 * @author jielu
 * 
 */
@Controller
@Scope("prototype")
public class KnowledgeAction extends BaseAction<KnowledgeDetail> {
	/**
	 * 显示知识点列表
	 * 
	 * @return
	 * @throws Exception
	 */
	private Long charpterId;

	public String list() throws Exception {

		Charpter charpter = charpterService.getById(charpterId);
		ActionContext.getContext().put("charpter", charpter);

		
		List<KnowledgeDetail> knowledgeList = knowledgeService.findByCharpter(charpter);
		ActionContext.getContext().put("knowledgeList", knowledgeList);
		return "list";
	}
	
	public String slist() throws Exception {

		return "slist";
	}
	public String studentList() throws Exception{
		List<Subject> subjectlist = subjectService.findAll();
		ActionContext.getContext().put("subjectlist", subjectlist);
		return "studentList";
	}
	public String delete() throws Exception {
		knowledgeService.delete(model.getKid());
		return "toshow";
	}

	public String addUI() throws Exception {
		
		// 准备数据
		Charpter charpter = charpterService.getById(charpterId);
		ActionContext.getContext().put("charpter", charpter);
		return "saveUI";
	}

	public String add() throws Exception {

	// 表单中已经封装的有content，title
		
		model.setCharpter(charpterService.getById(charpterId));
		model.setAuthor(getCurrentUser());
		model.setPostTime(new Date());
		
		knowledgeService.save(model);
		return "toshow";
	}

	public String editUI() throws Exception {
		// 准备数据
		Charpter charpter = charpterService.getById(charpterId);
		ActionContext.getContext().put("charpter", charpter);
		
		KnowledgeDetail knowledge = knowledgeService.getById(model.getKid());
		ActionContext.getContext().getValueStack().push(knowledge);

		return "saveUI";
	}

	public String edit() throws Exception {
		
		KnowledgeDetail knowledge = knowledgeService.getById(model.getKid());
		
		knowledge.setAuthor(getCurrentUser());
		knowledge.setCharpter(charpterService.getById(charpterId));
		knowledge.setContent(model.getContent());
		knowledge.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		knowledge.setPostTime(new Date());
		knowledge.setTitle(model.getTitle());
		
		knowledgeService.save(knowledge);
		return "toshow";
	}

	public String showUI() throws Exception {
		// 准备数据
		Charpter charpter = charpterService.getById(charpterId);
		ActionContext.getContext().put("charpter", charpter);
		
		KnowledgeDetail knowledge = knowledgeService.getById(model.getKid());
		ActionContext.getContext().getValueStack().push(knowledge);

		return "showUI";
	}
	/**
	 * setter and getter
	 * 
	 * @return
	 */


	public Long getCharpterId() {
		return charpterId;
	}

	public void setCharpterId(Long charpterId) {
		this.charpterId = charpterId;
	}
	
	

}
