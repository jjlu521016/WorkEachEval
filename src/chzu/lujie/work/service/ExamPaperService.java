package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.User;

public interface ExamPaperService extends DaoSupport<ExamPaper> {

	ExamPaper createPaper(Exam exam, User currentUser) throws Exception;

	List<ExamPaper> findMyPaper(User currentUser);

	ExamPaper updatePaper(ExamPaper paper);

	void updateFlg(Long paperId);

	int getScore(ExamPaper paper);

}
