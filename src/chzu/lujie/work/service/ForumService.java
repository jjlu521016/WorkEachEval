package chzu.lujie.work.service;

import java.util.List;
import chzu.lujie.work.domain.Forum;

public interface ForumService {

	List<Forum> findAll();

	void delete(Long id);

	void save(Forum model);

	Forum getById(Long id);
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

}
