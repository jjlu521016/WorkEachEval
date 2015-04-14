package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Answers;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Exercise;
import chzu.lujie.work.domain.KnowledgeDetail;
import chzu.lujie.work.domain.Questions;


public interface QuestionService extends DaoSupport<Questions>{

	List<Questions> findByCharpter(Charpter charpter);

	List<Questions> findQuestion(Exercise exercise);


//	List<Questions> findByCharpter(Charpter charpter);
}
