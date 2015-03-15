package chzu.lujie.work.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.domain.Forum;
import chzu.lujie.work.domain.PageBean;
import chzu.lujie.work.domain.Reply;
import chzu.lujie.work.domain.Topic;
import chzu.lujie.work.service.ReplyService;

@Service
@Transactional
public class ReplyServiceImpl extends DaoSupportImpl<Reply> implements
		ReplyService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> findByTopic(Topic topic) {

		return getSession()
				.createQuery(
						"from Reply r where r.topic =? order by r.postTime")//
				.setParameter(0, topic)//
				.list();
	}

	@Override
	public void save(Reply reply) {

		getSession().save(reply);

		// 2，维护相关的信息
		Topic topic = reply.getTopic();
		Forum forum = topic.getForum();

		forum.setArticleCount(forum.getArticleCount() + 1); // 文章数量（主题数+回复数）
		topic.setReplyCount(topic.getReplyCount() + 1); // 回复数量
		topic.setLastReply(reply); // 最后发表的回复
		topic.setLastUpdateTime(reply.getPostTime()); // 最后更新时间（主题的发表时间或最后回复的时间）

		getSession().update(topic);
		getSession().update(forum);
	}

	@Override
	/**
	 * 
	 */
	public PageBean getPageByTopic(int pageNum, int pageSize, Topic topic) {
//查询列表
		List recordList = getSession().createQuery(//
							"from Reply r where r.topic=? order by r.postTime asc")//
						  .setParameter(0, topic)
						  .setFirstResult((pageNum-1) * pageSize)
						  .setMaxResults(pageSize)
						  .list();
		Long recordCount = (Long) getSession().createQuery(//
							"select count(*) from Reply r where r.topic=?")//
							 .setParameter(0, topic)//
							 .uniqueResult();
		
		return new PageBean(pageNum, pageSize, recordCount.intValue(), recordList);
	}

}
