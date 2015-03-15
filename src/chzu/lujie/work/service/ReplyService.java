package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.PageBean;
import chzu.lujie.work.domain.Reply;
import chzu.lujie.work.domain.Topic;

public interface ReplyService extends DaoSupport<Reply>{

	List<Reply> findByTopic(Topic topic);

	PageBean getPageByTopic(int pageNum, int pageSize, Topic topic);

	
}
