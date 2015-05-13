package chzu.lujie.work.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.ExamDao;
import chzu.lujie.work.dao.ExamPaperDao;
import chzu.lujie.work.dao.QuestionTaskerDao;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.QuestionTasker;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.StudentQuestionRecord;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.service.ExamPaperService;
import chzu.lujie.work.service.QuestionService;
import chzu.lujie.work.service.QuestiontaskerService;
import chzu.lujie.work.service.StudentQuestionRecordService;

@Service
@Transactional
public class StudentQuestionRecordImpl extends DaoSupportImpl<StudentQuestionRecord> implements StudentQuestionRecordService {
	@Resource
	QuestiontaskerService questiontaskerService;
	@Resource
	QuestionTaskerDao questionTaskerDao;
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentQuestionRecord> getByPaper(ExamPaper paper) {
		//查询出本次考试的所有问题，并按照问题的类型排序
		return getSession().createQuery(//
				"From StudentQuestionRecord s where s.examPaper = ? order by s.question.types ")//
				.setParameter(0, paper)
				.list();
				
	}

	@Override
	public int getCount(ExamPaper paper) {
		List list = getSession().createQuery(//
				"from StudentQuestionRecord s where s.examPaper = ?")//
				.setParameter(0, paper)//
				.list();
		int count  = list.size();
		System.out.println("--------------------------------------count="+count);
		return count;
	}
//根据问题的类型获取问题的个数
//	@Override
//	public int getSubjectiveCount(ExamPaper paper, String type) {
//		String hql="from StudentQuestionRecord s where s.examPaper = ? and s.question.types = ?";
//		List list = getSession().createQuery(hql)//
//					.setParameter(0, paper)//
//					.setParameter(1, type)//
//					.list();
//		int count  = list.size();
//		System.out.println("--------------------------------------count="+count);
//		return count;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentQuestionRecord> findSubjective(ExamPaper paper,String type) {
		String hql ="from StudentQuestionRecord s where s.examPaper = ? and s.question.types = "+ type;
		List<StudentQuestionRecord> list = getSession().createQuery(hql)//
				.setParameter(0, paper)//
				.list();
		 return list;
	}
/*（
 * (non-Javadoc)
 * 把简答题保存在StudentQuestionRecord中
 * @see chzu.lujie.work.service.StudentQuestionRecordService#findSubject(chzu.lujie.work.domain.ExamPaper, java.lang.String, chzu.lujie.work.domain.User)
 */
	@SuppressWarnings("unchecked")
	@Override
	public void findSubject(ExamPaper paper,String type, User user) {

		boolean iscreate = questionTaskerDao.isexist(paper, user);
		System.out.println("-----------------------------" + iscreate);
		if (!iscreate) {
			String hql ="from StudentQuestionRecord s where s.examPaper = ? and s.question.types = "+ type;
			List<StudentQuestionRecord> list = getSession().createQuery(hql)//
					.setParameter(0, paper)//
					.list();		
			for (int i = 0;i < list.size();i++){
				StudentQuestionRecord record = list.get(i);
				//Questions questions = list.get(i).getQuestion();
				
				QuestionTasker question = new QuestionTasker();
				question.setRecord(record);
				//question.setQuestion(questions);
				question.setExamPaper(paper);
				question.setTasker(user);
				questiontaskerService.save(question);
			}
		}
	}

	@Override
	public int getStudentSorce(ExamPaper paper) {
		String hql="select sum(sqr.question.qscore) from StudentQuestionRecord sqr where sqr.examPaper = ?";
		List list = getSession().createQuery(hql).setParameter(0, paper).list();
		String Score = list.get(0).toString();
		int countScore = Integer.parseInt(Score);
		System.out.println("---------------"+countScore);
		
		return countScore;
	}

}
