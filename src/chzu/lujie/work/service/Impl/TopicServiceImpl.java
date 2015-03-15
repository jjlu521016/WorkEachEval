package chzu.lujie.work.service.Impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.domain.Forum;
import chzu.lujie.work.domain.Topic;
import chzu.lujie.work.service.TopicService;

@Service
@Transactional
public class TopicServiceImpl extends DaoSupportImpl<Topic> implements TopicService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findByForum(Forum forum) {
		return getSession().createQuery(//
				//先按类型排序，再按更新时间排序
				// TODO
				// FIXME
				"from Topic t  where forum = ? order by t.type desc,t.lastUpdateTime desc ")//
				.setParameter(0, forum)//
				.list();
	}

	@SuppressWarnings("static-access")
	@Override
	public void save(Topic topic) {
		//放在service层中
		topic.setLastReply(null);
		topic.setLastUpdateTime(topic.getLastUpdateTime());		
		topic.setReplyCount(0);		
		topic.setType(topic.TYPE_NORMAL);
		
		getSession().save(topic);
		
		//特殊属性
		Forum forum = topic.getForum();
		
		forum.setTopicCount(forum.getTopicCount() + 1);
		forum.setArticleCount(forum.getArticleCount() +1);
		forum.setLastTopic(topic);
		
		getSession().update(forum);
	}

	

}
