package chzu.lujie.work.dao;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Task;
import chzu.lujie.work.domain.User;

public interface TaskDao extends DaoSupport<Task>
{

	List<Task> findMyTask(User currentUser);

}
