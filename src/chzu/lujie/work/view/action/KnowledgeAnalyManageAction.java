package chzu.lujie.work.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.KnowledgeAnaly;

@Controller
@Scope("prototype")
public class KnowledgeAnalyManageAction extends BaseAction<KnowledgeAnaly> {

	public String list() throws Exception {
		
		List<KnowledgeAnaly> analyList = knowledgeAnalyService.findAll();
		ActionContext.getContext().put("analyList", analyList);

		return "list";
	}

	public String delete() throws Exception {
		knowledgeAnalyService.delete(model.getId());
		return "tolist";
	}

	public String add() throws Exception {
		knowledgeAnalyService.save(model);
		return "tolist";

	}

	public String addUI() throws Exception {

		return "saveUI";
	}

	public String edit() throws Exception {
		// 从数据库中取对象
		KnowledgeAnaly knowledgeAnaly = knowledgeAnalyService.getById(model.getId());

		// 设置修改的属性
		knowledgeAnaly.setTitle(model.getTitle());
		knowledgeAnaly.setDescription(model.getDescription());
		// 更新到数据库
		knowledgeAnalyService.save(knowledgeAnaly);
		return "tolist";
	}

	public String editUI() throws Exception {

		KnowledgeAnaly knowledgeAnaly = knowledgeAnalyService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(knowledgeAnaly);
		return "saveUI";
	}

	// 知识点的上移
	public String moveUp() throws Exception {
		knowledgeAnalyService.moveUp(model.getId());	
		return "tolist";
	}

	// 知识点的下移
	public String moveDown() throws Exception {
		knowledgeAnalyService.moveDown(model.getId());	
		return "tolist";
	}
}
