package chzu.lujie.work.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.QuestionTasker;
import chzu.lujie.work.domain.StudentQuestionRecord;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.service.QuestiontaskerService;

@Service
@Transactional
public class QuestionTaskerServiceImpl extends DaoSupportImpl<QuestionTasker> implements QuestiontaskerService {

	@Override
	public List<QuestionTasker> findrecord(ExamPaper paper, User currentUser) {
		String hql ="from QuestionTasker qt where qt.examPaper = ? and qt.tasker= ?";
		List<QuestionTasker> list = getSession().createQuery(hql)//
				.setParameter(0, paper)//
				.setParameter(1, currentUser)//
				.list();
		 return list;
	}

	@Override
	public QuestionTasker updateInfo(int manualscore, String opinion) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getByPaperUser(ExamPaper paper, User currentUser) {
		String hql ="select sum(qt.score)  from QuestionTasker qt where qt.examPaper = ? and qt.tasker= ?";
		List list = getSession().createQuery(hql)//
				.setParameter(0, paper)//
				.setParameter(1, currentUser)//
				.list();
		//将查询的sum值转换成String 
		String score = list.get(0).toString();
		return score;
	}

	

}
