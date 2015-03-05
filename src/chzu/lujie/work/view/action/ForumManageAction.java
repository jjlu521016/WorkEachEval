package chzu.lujie.work.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Forum;

@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {

	public String list() throws Exception {
		List<Forum> forumList = forumService.findAll();

		ActionContext.getContext().put("forumList", forumList);

		return "list";
	}

	public String delete() throws Exception {
		forumService.delete(model.getId());
		return "tolist";
	}

	public String add() throws Exception {
		forumService.save(model);
		return "tolist";

	}

	public String addUI() throws Exception {

		return "saveUI";
	}

	public String edit() throws Exception {
		// 从数据库中取对象
		Forum forum = forumService.getById(model.getId());

		// 设置修改的属性
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());;
		// 更新到数据库
		return "tolist";
	}

	public String editUI() throws Exception {

		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(forum);
		return "saveUI";
	}

	// 论坛版块的上移
	public String moveUp() throws Exception {
		forumService.moveUp(model.getId());	
		return "tolist";
	}

	// 论坛版块的下移
	public String moveDown() throws Exception {
		forumService.moveDown(model.getId());	
		return "tolist";
	}
}
