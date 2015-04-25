package chzu.lujie.work.service.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.domain.Answers;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Exercise;
import chzu.lujie.work.domain.KnowledgeDetail;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.service.KnowledgeService;
import chzu.lujie.work.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl extends DaoSupportImpl<Questions> implements
		QuestionService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Questions> findByCharpter(Charpter charpter) {
		return getSession().createQuery(//
				"from Questions k  where charpter = ?")//
				.setParameter(0, charpter)//
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Questions> findQuestion(Exercise exercise) {
		return getSession().createQuery(//
				"from Questions k  where exercise = ?")//
				.setParameter(0, exercise)//
				.list();
	}

	
	
}

