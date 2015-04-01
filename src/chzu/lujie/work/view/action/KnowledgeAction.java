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
	private Long charptertId;

	public String list() throws Exception {
		
//		List<KnowledgeDetail> knowledgelist = knowledgeService.findAll();
//		ActionContext.getContext().put("knowledgelist", knowledgelist);

		return "list";
	}

	public String delete() throws Exception {
		knowledgeService.delete(model.getKid());
		return "toshow";
	}

	public String addUI() throws Exception {
		
		// 准备数据
		Charpter charpter = charpterService.getById(charptertId);
		ActionContext.getContext().put("charpter", charpter);
		return "saveUI";
	}

	public String add() throws Exception {

	// 表单中已经封装的有content，title
		
		model.setCharpter(charpterService.getById(charptertId));
		model.setAuthor(getCurrentUser());
		model.setPostTime(new Date());
		
		knowledgeService.save(model);
		return "toshow";
	}

	public String editUI() throws Exception {
		// 准备数据
//		Subject subject = subjectService.getById(subjectId);
//		ActionContext.getContext().put("subject", subject);
//		
//		Charpter charpter = charpterService.getById(model.getCid());
//
//		ActionContext.getContext().getValueStack().push(charpter);
//		ActionContext.getContext().put("charpter", charpter);

		return "saveUI";
	}

	public String edit() throws Exception {
		
//		Charpter charpter = charpterService.getById(model.getCid());
//		
//		charpter.setCname(model.getCname());
//		charpter.setDescription(model.getDescription());
//		charpter.setSubject(subjectService.getById(subjectId));
//
//		charpterService.update(charpter);
		return "toshow";
	}
	
	/**
	 * setter and getter
	 * 
	 * @return
	 */
	public Long getCharptertId() {
		return charptertId;
	}

	public void setCharptertId(Long charptertId) {
		this.charptertId = charptertId;
	}


	

}
