package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.domain.Forum;
import chzu.lujie.work.domain.Topic;

public interface TopicService {
//查询指定板块中所有的主题
	/**
	 * 置顶帖放在最前面。按最后更新时间排序
	 * @param forum
	 * @return
	 */
	List<Topic> findByForum(Forum forum);

	void save(Topic topic);

	Topic getById(Long id);


}
