package chzu.lujie.work.service.Impl;

import java.util.ArrayList;
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
import chzu.lujie.work.domain.Answers;
import chzu.lujie.work.domain.AnswersUser;
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
public class ExamPaperServiceImpl extends DaoSupportImpl<ExamPaper> implements
		ExamPaperService {

	@Resource
	QuestionService questionService;
	@Resource
	ExamPaperDao examPaperDao;
	@Resource
	SessionFactory sessionFactory;
	@Resource
	StudentQuestionRecordService recordService;

	/**
	 * 自动生成作业
	 */
	@Override
	public ExamPaper createPaper(Exam exam, User currentUser) throws Exception {

		ExamPaper paper = new ExamPaper();
		//TODO
		List<Questions> list = questionService.findAll();
		// 检查是否已经生成试卷
		boolean iscreate = examPaperDao.ispaperexist(exam, currentUser);
		System.out.println("-----------------------------" + iscreate);
		// 如果数据库中已经存在该条数据，则往上抛异常，在页面上显示出来
		if (iscreate) {
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

	@Override
	public ExamPaper updatePaper(ExamPaper paper) {
		examPaperDao.update(paper);
		return paper;
	}

	/**
	 * 
	 * 更新试卷的状态 flg=1 表示已经完成
	 */

	@Override
	public void updateFlg(Long paperId) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hqlString = "update ExamPaper p set p.flg = '1' where p.epid = "
				+ paperId;
		Query query = session.createQuery(hqlString);
		query.executeUpdate();
		tran.commit();
		session.close();

	}

	/**
	 * 计算当前考试中的选择题和判断题的分数
	 */
	@Override
	public int getScore(ExamPaper paper) {
		int result = 0;
		// 获取选择题
		List<StudentQuestionRecord> list1 = recordService.findSubjective(paper,
				"1");
		int count1 = list1.size();

		// 选择题的得分计算
		for (int i = 0; i < count1; i++) {
			StudentQuestionRecord record = list1.get(i);// paper.getRecords().get(i);
			List<AnswersUser> userlist = record.getAnswers();
			List<Answers> answerlist = record.getQuestion().getAnswerses();
			// 匹配正确答案，四个选项都正确的时候才能得分。
			// 注意是两个布尔值的比较！
			if (userlist.get(0).getIsRight()
					.equals(answerlist.get(0).getIsRight())
					&& userlist.get(1).getIsRight()
							.equals(answerlist.get(1).getIsRight())
					&& userlist.get(2).getIsRight()
							.equals(answerlist.get(2).getIsRight())
					&& userlist.get(3).getIsRight()
							.equals(answerlist.get(3).getIsRight())) {

				result = result
						+ Integer.parseInt(record.getQuestion().getQscore());
				System.out.println("###########################" + result);
			}
		}

		// 获取判断题
		List<StudentQuestionRecord> list2 = recordService.findSubjective(paper,
				"2");
		int count2 = list2.size();

		for (int j = 0; j < count2; j++) {
			StudentQuestionRecord record = list2.get(j);
			List<AnswersUser> userlist = record.getAnswers();
			List<Answers> answerlist = record.getQuestion().getAnswerses();
			// 判断题匹配正确答案，
			// 注意是两个布尔值的比较！
			if (userlist.get(0).getIsRight()
					.equals(answerlist.get(0).getIsRight())) {
				result = result
						+ Integer.parseInt(record.getQuestion().getQscore());
				// System.out.println("###########################"+result);
			}

		}
		return result;
	}

	public List<ExamPaper> getCountByTypes(User currentUser) {

		return getSession().createQuery(//
				"FROM ExamPaper p where student=?")
				.setParameter(0, currentUser)//
				.list();
	}
}
