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
	 * 根据用户在任务表里面查找该用户需要互评的作业 未完成互评的
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Task> findMyTask(User currentUser) {

		String sql = "select t.* from t_work_task t "
				+ " where t.studentId   not in ( "
				+ " select tp.studentId from t_work_taskpaper tp "
				+ " where tp.paperId = t.paperId and tp.taskerId ="
				+ currentUser.getId() + " )";
		List<Task> list = getSession().createSQLQuery(sql)
				.addEntity(Task.class).list();

		return list;
	}

	/**
	 * 已完成互评的
	 */
	public List<Task> findMyfinishTask(User currentUser) {

		String sql = "select t.* from t_work_task t "
				+ " where t.studentId  in ( "
				+ " select tp.studentId from t_work_taskpaper tp "
				+ " where tp.paperId = t.paperId and tp.taskerId ="
				+ currentUser.getId() + " )";
		List<Task> list = getSession().createSQLQuery(sql)
				.addEntity(Task.class).list();

		return list;
	}

}
