package chzu.lujie.work.view.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Forum;
import chzu.lujie.work.domain.Reply;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.domain.Topic;
import chzu.lujie.work.util.QueryHelper;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {

	private Long topicId;

	public String addUI() throws Exception {
//		Topic topic = topicService.getById(topicId);
//		ActionContext.getContext().put("topic", topic);
		new QueryHelper(Reply.class, "r").preparePageBean(replyService, pageNum, pageSize);
		return "addUI";
	}

	public String add() throws Exception {

		// 来自表单封装的数据title和content
		model.setTopic(topicService.getById(topicId));

		model.setAuthor(getCurrentUser());
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());
		
		replyService.save(model);
		return "toTopicShow";
	}

	// /////////////////////////////////////////////////////////////////////////////
	/**
	 * setter and getter
	 * 
	 * @return
	 */
	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

}
