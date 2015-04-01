package chzu.lujie.work.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.domain.Forum;
import chzu.lujie.work.domain.KnowledgeAnaly;
import chzu.lujie.work.service.ForumService;
import chzu.lujie.work.service.KnowledgeAnalyService;

@Service
@Transactional
public class KnowledgeAnalyServiceImpl extends DaoSupportImpl<KnowledgeAnaly> implements KnowledgeAnalyService {

	@SuppressWarnings("unchecked")
	@Override
	public List<KnowledgeAnaly> findAll() {
		return getSession().createQuery(//
				"FROM KnowledgeAnaly k order by k.position")//
				.list();
	}

	@Override
	public void save(KnowledgeAnaly knowledgeAnaly) {
		
		//保存到数据库
		super.save(knowledgeAnaly);
		//设置position的值,最大值+1,.唯一且递增
		
		knowledgeAnaly.setPosition(knowledgeAnaly.getId().intValue());
		knowledgeAnaly.getId();
	}

	@Override
	public void moveUp(Long id) {
		KnowledgeAnaly knowledgeAnaly = getById(id);
		//其他板块，如果position比本position的值大，选择上面的第一个
		KnowledgeAnaly other  = (KnowledgeAnaly) getSession().createQuery(
						"FROM KnowledgeAnaly k where k.position < ? order by k.position desc")//
						.setParameter(0, knowledgeAnaly.getPosition())//
						.setFirstResult(0)//
						.setMaxResults(1)//
						.uniqueResult();//其他的版块
		//最上面的不能上移
		if(other == null){
			return;
		}
		
		//交换版块的位置
		int swap = knowledgeAnaly.getPosition();
		
		knowledgeAnaly.setPosition(other.getPosition());
		other.setPosition(swap);
		
		//提交到数据库
		getSession().update(knowledgeAnaly);
		getSession().update(other);
		
		
	}

	@Override
	public void moveDown(Long id) {
		KnowledgeAnaly knowledgeAnaly = getById(id);
		//其他板块，如果position比本position的值小，选择下面的第一个
		Forum other  = (Forum) getSession().createQuery(
						"FROM Forum f where f.position > ? order by f.position asc")//
						.setParameter(0, knowledgeAnaly.getPosition())//
						.setFirstResult(0)//
						.setMaxResults(1)//
						.uniqueResult();//其他的版块
		//最下面的不能下移
		if(other == null){
			return;
		}
		
		//交换版块的位置
		int swap = knowledgeAnaly.getPosition();
		
		knowledgeAnaly.setPosition(other.getPosition());
		other.setPosition(swap);
		
		//提交到数据库
		getSession().update(knowledgeAnaly);
		getSession().update(other);
	}

}
