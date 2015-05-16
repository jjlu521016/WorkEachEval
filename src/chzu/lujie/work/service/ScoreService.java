package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Score;
import chzu.lujie.work.domain.User;

public interface ScoreService extends DaoSupport<Score> {

	List<Score> getScoreBytasker(ExamPaper paper, User student, User currentUser);
	
	List<Score> getScoreByPaper(ExamPaper paper);

	void updateScoreInfo(Long sid, int i, int totalscore, double rate);


}
