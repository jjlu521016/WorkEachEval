package chzu.lujie.work.service.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.ExamDao;
import chzu.lujie.work.dao.ExamPaperDao;
import chzu.lujie.work.domain.Answers;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Exercise;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.StudentQuestionRecord;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.service.ExamService;
import chzu.lujie.work.service.ExerciseService;
import chzu.lujie.work.service.QuestionService;
import chzu.lujie.work.util.HibernateUtil;


@Service
@Transactional
public class ExamServiceImpl extends DaoSupportImpl<Exam> implements
		ExamService {
	
	ExamDao examDao;
	ExamPaperDao examPaperDao;
	@Resource
	QuestionService questionService;
	@Override
	public ExamPaper createPaper(Exam exam, User currentUser) {

		ExamPaper paper = new ExamPaper();
		paper.setExam(exam);
		paper.setStudent(currentUser);

		List<Questions> list =questionService.findAll();
		
	
		
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



}
