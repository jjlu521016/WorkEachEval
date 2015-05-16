package chzu.lujie.work.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.ScoreDao;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Score;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.service.ScoreService;

@Service
@Transactional
public class ScoreServiceImpl extends DaoSupportImpl<Score> implements
		ScoreService {

	
	@Resource
	ScoreDao scoreDao;
	@Resource
	SessionFactory sessionFactory;
	@Override
	public List<Score> getScoreBytasker(ExamPaper paper, User student,
			User currentUser) {
		List<Score> scorelist = scoreDao.getScoreBytasker(paper,student,currentUser);
		
		return scorelist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Score> getScoreByPaper(ExamPaper paper) {
		String hql="from Score s where s.paper=?";
		List<Score> list = getSession().createQuery(hql).setParameter(0, paper).list();
		return list;
	}

	@Override
	public void updateScoreInfo(Long sid, int i, int totalscore, double rate) {
		
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hqlString = "update Score s set s.manualscore = "+i+" "
							+ " , s.totalscore="+totalscore+" "
							+ " , s.rate = "+rate+"where s.sid = "+ sid;
		Query query = session.createQuery(hqlString);
		query.executeUpdate();
		tran.commit();
		session.close();
		
	}

}
