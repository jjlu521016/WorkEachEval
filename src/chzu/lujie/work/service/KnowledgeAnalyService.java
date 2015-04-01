package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.domain.KnowledgeAnaly;


public interface KnowledgeAnalyService {

/**
 * 上移
 * @author jielu
 * @param id
 */
	void moveUp(Long id);

	
	/**
	 * 下移
	 * @author jielu
	 * @param id
	 */
	void moveDown(Long id);


	List<KnowledgeAnaly> findAll();


	void delete(Long id);


	void save(KnowledgeAnaly model);


	KnowledgeAnaly getById(Long id);

}
