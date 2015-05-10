package chzu.lujie.work.dao;


import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Score;
import chzu.lujie.work.domain.User;

public interface ScoreDao extends DaoSupport<Score>
{

	List<Score> getScoreBytasker(ExamPaper paper, User student, User currentUser);

}
