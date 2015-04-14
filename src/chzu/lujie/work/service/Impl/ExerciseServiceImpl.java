package chzu.lujie.work.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.domain.Exercise;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.service.ExerciseService;
import chzu.lujie.work.util.HibernateUtil;

@Service
@Transactional
public class ExerciseServiceImpl extends DaoSupportImpl<Exercise> implements
		ExerciseService {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Exercise> findMyExercise(User currentUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatus(Long eid) {

		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

		String hqlString = "update Exercise e set e.statu = '1' where e.eid = "
				 + eid;
		Query query = session.createQuery(hqlString);
		query.executeUpdate();
		tran.commit();
		session.close();
	}

}
