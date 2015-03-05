package chzu.lujie.work.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Forum;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Forum> {

	
	public String addUI() throws Exception {
		

		return "addUI";
	}
	
	public String add() throws Exception {
		

		return "toTopicShow";
	}

	
}
