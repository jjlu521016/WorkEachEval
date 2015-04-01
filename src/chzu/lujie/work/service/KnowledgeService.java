package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.KnowledgeDetail;


public interface KnowledgeService extends DaoSupport<KnowledgeDetail>{

	List<KnowledgeDetail> findByCharpter(Charpter charpter);
}
