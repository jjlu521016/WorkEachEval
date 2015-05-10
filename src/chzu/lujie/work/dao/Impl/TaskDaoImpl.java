package chzu.lujie.work.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.TaskDao;
import chzu.lujie.work.domain.Task;
import chzu.lujie.work.domain.User;

@Repository
public class TaskDaoImpl extends DaoSupportImpl<Task> implements TaskDao {
/**
 * 根据用户在任务表里面查找该用户需要互评的作业
 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Task> findMyTask(User currentUser) {
		List<Task> list =  getSession().createQuery(//
						"FROM Task t where t.Tasker1=? or t.Tasker2=? or t.Tasker3=?")//
						.setParameter(0, currentUser)
						.setParameter(1, currentUser)
						.setParameter(2, currentUser)
						.list();
		 return list;
	}

}
