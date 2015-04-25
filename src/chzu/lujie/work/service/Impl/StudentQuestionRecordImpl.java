package chzu.lujie.work.service.Impl;

import java.util.ArrayList;
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
import chzu.lujie.work.service.ExamPaperService;
import chzu.lujie.work.service.QuestionService;
import chzu.lujie.work.service.StudentQuestionRecordService;

@Service
@Transactional
public class StudentQuestionRecordImpl extends DaoSupportImpl<StudentQuestionRecord> implements StudentQuestionRecordService {

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentQuestionRecord> getByPaper(ExamPaper paper) {
		//查询出本次考试的所有问题，并按照问题的类型排序
		return getSession().createQuery(//
				"From StudentQuestionRecord s where s.examPaper = ? order by s.question.types ")//
				.setParameter(0, paper)
				.list();
				
	}

}
