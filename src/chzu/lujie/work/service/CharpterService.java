package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Subject;


public interface CharpterService extends DaoSupport<Charpter>{
	
	List<Charpter> findBySubject(Subject subject);

//	List<Charpter> findBySubject(Long subjectId);




}
