package chzu.lujie.work.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.ExamDao;
import chzu.lujie.work.dao.ExamPaperDao;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.StudentQuestionRecord;
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
