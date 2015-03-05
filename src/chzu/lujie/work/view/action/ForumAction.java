package chzu.lujie.work.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Forum;

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {

	public String list() throws Exception {
		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}

	public String show() throws Exception {
		// 准备数据：forum
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);
		return "show";
	}

}
