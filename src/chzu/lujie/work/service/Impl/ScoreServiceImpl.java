package chzu.lujie.work.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.ScoreDao;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Score;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.service.ScoreService;

@Service
@Transactional
public class ScoreServiceImpl extends DaoSupportImpl<Score> implements
		ScoreService {

	
	@Resource
	ScoreDao scoreDao;
	@Override
	public List<Score> getScoreBytasker(ExamPaper paper, User student,
			User currentUser) {
		List<Score> scorelist = scoreDao.getScoreBytasker(paper,student,currentUser);
		
		return scorelist;
	}

}
