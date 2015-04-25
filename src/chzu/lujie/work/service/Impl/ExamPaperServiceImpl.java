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

@Service
@Transactional
public class ExamPaperServiceImpl extends DaoSupportImpl<ExamPaper> implements
		ExamPaperService {

	@Resource
	QuestionService questionService;
	@Resource
	ExamPaperDao examPaperDao;

	/**
	 * 自动生成作业
	 */
	@Override
	public ExamPaper createPaper(Exam exam, User currentUser)  throws Exception{

		ExamPaper paper = new ExamPaper();
		List<Questions> list = questionService.findAll();
		// 检查是否已经生成试卷
		boolean iscreate= examPaperDao.ispaperexist(exam,currentUser);
		System.out.println("-----------------------------"+iscreate);
		//如果数据库中已经存在该条数据，则往上抛异常，在页面上显示出来
		if(iscreate){
			throw new Exception("你的作业已经生成了，请到“我的未完成作业”里面查看！");
		}
//		
		List<StudentQuestionRecord> record2 = new ArrayList<StudentQuestionRecord>();

		for (Questions q : list) {
			StudentQuestionRecord record = new StudentQuestionRecord();

			record.setQuestion(q);
			record.setExamPaper(paper);
			// System.out.println("++++++++++++++++++++++++++++++++++++++++"+q.getQtext());

			record2.add(record);
		}

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ record2.size());
		paper.setExam(exam);
		paper.setStudent(currentUser);
		paper.setRecords(record2);
		paper.setFlg("0");
		return paper;
	}

	/**
	 * 根据用户查找该用户的未完成的作业
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ExamPaper> findMyPaper(User currentUser) {

		return getSession().createQuery(//
				"FROM ExamPaper p where student=?")
				.setParameter(0, currentUser)//
				.list();
	}

}
