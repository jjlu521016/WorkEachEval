package chzu.lujie.work.view.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Forum;
import chzu.lujie.work.domain.PageBean;
import chzu.lujie.work.domain.Reply;
import chzu.lujie.work.domain.Topic;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {
	private Long forumId;
	



	public String show() throws Exception {

		Topic topic = topicService.getById(model.getId());		
		ActionContext.getContext().put("topic", topic);
		
		List<Reply> replyList = replyService.findByTopic(topic);
		ActionContext.getContext().put("replyList", replyList);
		
		//分页显示：
		PageBean pageBean = replyService.getPageByTopic(pageNum,pageSize,topic);
		
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "show";
	}

	public String addUI() throws Exception {
		// 准备数据
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}

	public String add() throws Exception {
		//Topic topic = new Topic();
		//表单中已经封装的有content，title
		model.setTitle(model.getTitle());
		model.setContent(model.getContent());
		model.setForum(forumService.getById(forumId));
		

		model.setAuthor(getCurrentUser());
		//获取IP地址
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());
		

		topicService.save(model);
		
		return "toShow";
	}



	// /////////////////////////////////////////////////////////////////////////
	public Long getForumId() {
		return forumId;
	}

	

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	


}
