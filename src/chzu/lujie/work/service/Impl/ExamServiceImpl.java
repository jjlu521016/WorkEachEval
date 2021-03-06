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
import chzu.lujie.work.dao.ExamDao;
import chzu.lujie.work.dao.ExamPaperDao;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.StudentQuestionRecord;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.service.ExamService;
import chzu.lujie.work.service.QuestionService;


@Service
@Transactional
public class ExamServiceImpl extends DaoSupportImpl<Exam> implements
		ExamService {
	
	ExamDao examDao;
	ExamPaperDao examPaperDao;
	@Resource
	QuestionService questionService;
	@Resource
	SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public ExamPaper createPaper(Exam exam, User currentUser) {

		ExamPaper paper = new ExamPaper();
		paper.setExam(exam);
		paper.setStudent(currentUser);

		//List<Questions> list =questionService.findAll();
		String hql = "from question q where q.exam=?";
		List<Questions> list = getSession().createQuery(hql).setParameter(0, exam).list();
	
		
		System.out.println("------------------>>>>"+list.size());
		
		for(Questions q:list){
			StudentQuestionRecord record = new StudentQuestionRecord();
			
			record.setQuestion(q);
			System.out.println("++++++++++++++++++++++++++++++++++++++++"+q.getQtext());
			
			paper.getRecords().add(record);		
		}
		
		examPaperDao.save(paper);
		return paper;
	}
	@Override
	public void updateFlg(Long eid) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hqlString = "update Exam e set e.flg = '1' where e.eid = "
				+ eid;
		Query query = session.createQuery(hqlString);
		query.executeUpdate();
		tran.commit();
		session.close();
		
	}
	@Override
	public List<Exam> getBysubject(Subject subject) {
		String hql="from Exam e where e.subject =?";
		List<Exam> list = getSession().createQuery(hql).setParameter(0, subject).list();
		
		return list;
	}



}
