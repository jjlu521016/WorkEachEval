package chzu.lujie.work.dao;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.QuestionTasker;
import chzu.lujie.work.domain.User;

public interface QuestionTaskerDao extends DaoSupport<QuestionTasker>
{


	boolean isexist(ExamPaper paper, User user);



}
