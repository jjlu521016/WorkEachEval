package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.QuestionTasker;
import chzu.lujie.work.domain.User;


public interface QuestiontaskerService extends DaoSupport<QuestionTasker>{

	List<QuestionTasker> findrecord(ExamPaper paper, User currentUser);

	QuestionTasker updateInfo(int manualscore, String opinion);

	String getByPaperUser(ExamPaper paper, User currentUser);





}
