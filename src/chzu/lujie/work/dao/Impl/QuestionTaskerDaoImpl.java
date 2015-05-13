package chzu.lujie.work.dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.DepartmentDao;
import chzu.lujie.work.dao.ExamDao;
import chzu.lujie.work.dao.ExamPaperDao;
import chzu.lujie.work.dao.QuestionTaskerDao;
import chzu.lujie.work.domain.Department;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.QuestionTasker;
import chzu.lujie.work.domain.User;

@Repository
public class QuestionTaskerDaoImpl extends DaoSupportImpl<QuestionTasker> implements
		QuestionTaskerDao {
	@Resource
	SessionFactory sessionFactory;
/*(
 * (non-Javadoc)
 *判断是否已经生成数据
 * @see chzu.lujie.work.dao.QuestionTaskerDao#isexist(chzu.lujie.work.domain.ExamPaper, chzu.lujie.work.domain.User)
 */
	@Override
	public boolean isexist(ExamPaper paper, User user) {
		@SuppressWarnings("unchecked")
		List<QuestionTasker> list = sessionFactory.getCurrentSession().createQuery(//
				" from QuestionTasker qt where qt.examPaper=? and qt.tasker=?")//
				.setParameter(0, paper)//
				.setParameter(1, user)//
				.list();
		System.out.println("---------------------------"+list+"============"+list.size());
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
