package chzu.lujie.work.service;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Teacher;
import chzu.lujie.work.domain.User;

public interface TeacherService extends DaoSupport<Teacher>{

	Teacher findByLoginNameAndPassword(String loginName, String password);

//	public List<User> finAll() ;
//
//		// TODO Auto-generated method stub
//	public void delete(Long id);
//
//	public void save(User model) ;
//
//	public User getById(Long id);
//
//	public void update(User model);



}
