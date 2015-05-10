package chzu.lujie.work.dao;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Exercise;
import chzu.lujie.work.domain.User;

public interface ExamPaperDao extends DaoSupport<ExamPaper>
{

	boolean ispaperexist(Exam exam, User currentUser);



}
