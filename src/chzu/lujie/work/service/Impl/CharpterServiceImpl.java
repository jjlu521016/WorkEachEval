package chzu.lujie.work.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Forum;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.service.CharpterService;
import chzu.lujie.work.service.ForumService;

@Service
@Transactional
public class CharpterServiceImpl extends DaoSupportImpl<Charpter> implements CharpterService {

	@Override
	public List<Charpter> findBySubject(Subject subject) {
		return getSession().createQuery(//
				"from Charpter c  where subject = ?")//
				.setParameter(0,subject)//
				.list();
	}




	

}
