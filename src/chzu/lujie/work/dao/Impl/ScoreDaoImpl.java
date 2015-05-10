package chzu.lujie.work.dao.Impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.ScoreDao;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Score;
import chzu.lujie.work.domain.User;

@Repository
public class ScoreDaoImpl extends DaoSupportImpl<Score> implements ScoreDao {

	//查找数据库是否有改记录
	@SuppressWarnings("unchecked")
	@Override
	public List<Score> getScoreBytasker(ExamPaper paper, User student,User currentUser) {
		//用HQL语句报错，没有找到和哪个地方冲突
//		String sql = "select * from t_work_score s "
//					+ " where s.paperId="+paper.getEpid()+" and s.studentId="+student.getId()+" and taskerId="+currentUser.getId();
//		System.out.println("++++++++++++++sql"+sql);
//		List<Score> score = getSession().createSQLQuery(sql).list();
		String hql= "from Score s where s.student=? and s.paper=? and s.tasker=?";
		List<Score> list = getSession().createQuery(hql)//
				.setParameter(0, student)//
				.setParameter(1,paper)//
				.setParameter(2, currentUser)
				.list();
		System.out.println("_________"+list.size());
		
		
		return list;
	}

}
