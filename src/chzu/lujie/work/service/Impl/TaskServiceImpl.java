package chzu.lujie.work.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.TaskDao;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Task;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.service.TaskService;

/**
 * 
 * @author jielu
 * 
 */
@Service
@Transactional
public class TaskServiceImpl extends DaoSupportImpl<Task> implements TaskService {
	
	@Resource
	TaskDao taskDao;
	
	
	@Override
	public Task getUser(ExamPaper paper, User currentUser) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		List array = new ArrayList();
		// 根据角色查询用户：由于没有t_work_user_role实体。所以不能使用HQL语句。
		// hibernate如果使用原生sql语句进行query查询时，hibernate是不会自动把结果包装成实体的
		@SuppressWarnings("unchecked")
		List<User> list = getSession().createSQLQuery(//
						"select * from t_work_user u LEFT JOIN t_work_user_role ur ON ur.userId = u.id "
						+ " where ur.roleId = '3' and u.id not in(?)")
				.addEntity(User.class)//
				.setParameter(0, currentUser)//
				.list();
		int maxSize = list.size();
		while (true) {
			int randNumber = (int) (Math.random() * maxSize + 1) - 1;		
			array.add(randNumber);
			if(array.size()>=3){
				break;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//随机抽取几个学生进行作业互评
		User u1 = (User) list.get((int) array.get(0));
		User u2 = (User) list.get((int) array.get(1));
		User u3 = (User) list.get((int) array.get(2));

		Task task = new Task();
		task.setExamPaper(paper);
		task.setStudent(currentUser);
		task.setFlg("0");
		task.setTasker1(u1);
		task.setTasker2(u2);
		task.setTasker3(u3);

		return task;

	}
/**
 * 我的要批改作业列表
 */
	@Override
	public List<Task> findMyTask(User currentUser) {
		return taskDao.findMyTask(currentUser);
	}

}
