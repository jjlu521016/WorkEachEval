package chzu.lujie.work.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Forum;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Forum> {

	public String list() throws Exception {

		return "list";
	}

	public String show() throws Exception {

		return "show";
	}

	public String addUI() throws Exception {

		return "addUI";
	}

	public String add() throws Exception {

		return "toShow";
	}
}
