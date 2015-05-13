package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.QuestionTasker;
import chzu.lujie.work.domain.StudentQuestionRecord;
import chzu.lujie.work.domain.User;


public interface StudentQuestionRecordService extends DaoSupport<StudentQuestionRecord>{

	List<StudentQuestionRecord> getByPaper(ExamPaper paper);

	int getCount(ExamPaper paper);


	List<StudentQuestionRecord> findSubjective(ExamPaper paper, String type);

	void findSubject(ExamPaper paper, String type,
			User user);

	int getStudentSorce(ExamPaper paper);



	
}
