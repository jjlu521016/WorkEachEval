package chzu.lujie.work.dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.DepartmentDao;
import chzu.lujie.work.dao.ExamDao;
import chzu.lujie.work.dao.ExamPaperDao;
import chzu.lujie.work.domain.Department;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.User;

@Repository
public class ExamPaperDaoImpl extends DaoSupportImpl<ExamPaper> implements
		ExamPaperDao {
	@Resource
	SessionFactory sessionFactory;

	@Override
	public boolean ispaperexist(Exam exam, User currentUser) {
		@SuppressWarnings("unchecked")
		List<ExamPaper> list = sessionFactory.getCurrentSession().createQuery(//
				" from ExamPaper p where p.student=? and p.exam=?")//
				.setParameter(0, currentUser)//
				.setParameter(1, exam)//
				.list();
		System.out.println("---------------------------"+list+"============"+list.size());
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
