package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Task;
import chzu.lujie.work.domain.User;


public interface TaskService extends DaoSupport<Task>{

	Task getUser(ExamPaper paper, User currentUser);
	/**
	 * 我的要批改作业列表
	 */
	List<Task> findMyTask(User currentUser);
	List<Task> findMyfinishTask(User currentUser);
	boolean isexist(ExamPaper paper, User currentUser);
	Task getScore(ExamPaper paper, User student);
	void updateFlg(Long tid);




}
