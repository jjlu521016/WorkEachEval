package chzu.lujie.work.service.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.service.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl extends DaoSupportImpl<Subject> implements
		SubjectService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> findMySubject(User currentUser) {

		String userName = currentUser.getLoginName();

		if (userName == "admin") {
			return getSession().createQuery(//
					"FROM Subject s order by sid")//
					.list();
		}
		
		else
		{
			return getSession().createQuery(//
					"FROM Subject s where s.author= ? order by sid")//
					.setParameter(0, currentUser)//
					.list();
		}
	}

	// @Override
	// protected Session getSession() {
	// // TODO Auto-generated method stub
	// return super.getSession();
	// }
	//
	// @Override
	// public void save(Subject entity) {
	// // TODO Auto-generated method stub
	// super.save(entity);
	// }
	//
	// @Override
	// public void update(Subject entity) {
	// // TODO Auto-generated method stub
	// super.update(entity);
	// }
	//
	// @Override
	// public void delete(Long id) {
	// // TODO Auto-generated method stub
	// super.delete(id);
	// }
	//
	// @Override
	// public Subject getById(Long id) {
	// // TODO Auto-generated method stub
	// return super.getById(id);
	// }
	//
	// @Override
	// public List<Subject> getByIds(Long[] ids) {
	// // TODO Auto-generated method stub
	// return super.getByIds(ids);
	// }
	//
	// @Override
	// public List<Subject> findAll() {
	// // TODO Auto-generated method stub
	// return super.findAll();
	// }

}
