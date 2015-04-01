package chzu.lujie.work.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.KnowledgeDetail;
import chzu.lujie.work.service.KnowledgeService;

@Service
@Transactional
public class KnowledgeServiceImpl extends DaoSupportImpl<KnowledgeDetail> implements KnowledgeService {

	@Override
	public List<KnowledgeDetail> findByCharpter(Charpter charpter) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"from KnowledgeDetail k  where charpter = ?")//
				.setParameter(0,charpter)//
				.list();
	}

}
