package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.domain.User;

public interface SubjectService extends DaoSupport<Subject> {

	List<Subject> findMySubject(User currentUser);

}
