package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Answers;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Exercise;
import chzu.lujie.work.domain.KnowledgeDetail;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.User;


public interface ExerciseService extends DaoSupport<Exercise>{

	List<Exercise> findMyExercise(User currentUser);

	void updateStatus(Long eid);


	
}
