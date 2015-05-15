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

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkScode(String scode) {
		String hql="from Subject s where s.subject_code='"+scode+"'";		
		List<Subject> list = getSession().createQuery(hql).list();
		if(list!=null&&list.size()>0){
			//数据库已经存在
			return true;
		}
		//数据库中不存在
		return false;     
	}

	

}
