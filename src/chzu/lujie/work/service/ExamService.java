package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Answers;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Exercise;
import chzu.lujie.work.domain.KnowledgeDetail;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.User;


public interface ExamService extends DaoSupport<Exam>{

	ExamPaper createPaper(Exam exam, User currentUser);

	void updateFlg(Long eid);


	
}
