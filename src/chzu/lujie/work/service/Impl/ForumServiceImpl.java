package chzu.lujie.work.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.domain.Forum;
import chzu.lujie.work.service.ForumService;

@Service
@Transactional
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements ForumService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Forum> findAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM Forum f order by f.position")//
				.list();
	}

	@Override
	public void save(Forum forum) {
		// TODO Auto-generated method stub
		
		//保存到数据库
		super.save(forum);
		//设置position的值,最大值+1,.唯一且递增
		
		forum.setPosition(forum.getId().intValue());
		forum.getId();
	}

	@Override
	public void moveUp(Long id) {
		// TODO Auto-generated method stub
		Forum forum = getById(id);
		//其他板块，如果position比本position的值大，选择上面的第一个
		Forum other  = (Forum) getSession().createQuery(
						"FROM Forum f where f.position < ? order by f.position desc")//
						.setParameter(0, forum.getPosition())//
						.setFirstResult(0)//
						.setMaxResults(1)//
						.uniqueResult();//其他的版块
		//最上面的不能上移
		if(other == null){
			return;
		}
		
		//交换版块的位置
		int swap = forum.getPosition();
		
		forum.setPosition(other.getPosition());
		other.setPosition(swap);
		
		//提交到数据库
		getSession().update(forum);
		getSession().update(other);
		
		
	}

	@Override
	public void moveDown(Long id) {
		// TODO Auto-generated method stub
		Forum forum = getById(id);
		//其他板块，如果position比本position的值小，选择下面的第一个
		Forum other  = (Forum) getSession().createQuery(
						"FROM Forum f where f.position > ? order by f.position asc")//
						.setParameter(0, forum.getPosition())//
						.setFirstResult(0)//
						.setMaxResults(1)//
						.uniqueResult();//其他的版块
		//最下面的不能下移
		if(other == null){
			return;
		}
		
		//交换版块的位置
		int swap = forum.getPosition();
		
		forum.setPosition(other.getPosition());
		other.setPosition(swap);
		
		//提交到数据库
		getSession().update(forum);
		getSession().update(other);
	}

}
